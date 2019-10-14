package analysis.detector;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import analysis.Metric;
import analysis.Metrics;
import analysis.storage.ListMap;
import analysis.storage.PrimitiveFloatMap;
import analysis.storage.PrimitiveIntMap;
import analysis.storage.SetIntMap;
import analysis.storage.SetStrMap;
import main.CsvCreator;
import model.Class;
import model.ContentContainer;
import model.ContentContainerVisitor;
import model.Project;
import model.Subroutine;
import process.GitLocationProcessor;
import util.FileHelper;
import util.Settings;

/**
 * Created by Nik on 04-11-2015
 */
public abstract class Detector {

	private static final String DATA_STORES_EXTENSION = "data";

	private SetStrMap defects;

	protected Map<String, analysis.storage.Map> dataStores;

	private final Map<Metric, Set<Integer>> requiredPercentages;

	protected Metrics metrics;
	private final PreliminaryVisitor preliminaryVisitor;
	private boolean finished;

	public Detector() throws IOException {
		// get suspect filename from suspect.properties. Points to file with existing data. 
		String fileName = this.getSuspectFilePath();
		// create map with existing filename if it exists. 
		this.defects = new SetStrMap(fileName);
		this.dataStores = new HashMap<>();
		this.requiredPercentages = new HashMap<>();
		this.addRequiredPercentages();
		this.preliminaryVisitor = new PreliminaryVisitor();
		this.addDataStores();
	}

	public void addMetrics(Metrics metrics) {
		this.metrics = metrics;
		this.finished = false;
	}

	public void process(String projectPath, ContentContainer contentContainer) {
		if (this.finished) {
			throw new IllegalStateException();
		}
		this.processChecked(projectPath, contentContainer);
	}

	private void processChecked(String projectPath, ContentContainer contentContainer) {
		Boolean defective = this.preliminaryVisitor.checkForDefect(contentContainer);
		if (defective) {
			this.defects.add(projectPath, contentContainer.getFullPath());
		}
	}

	/**
	 * This method is called after DeserializeData()
	 * @param gitLocs
	 * @param csvCreator
	 * @param csvName
	 * @throws IOException
	 */
	public void finish(GitLocationProcessor gitLocs, CsvCreator csvCreator, String csvName) throws IOException {
		this.defects.deserialize(false);
		// get key from possible defects
		String projectPath = this.defects.getNextKey();
		while (projectPath != null) {
			String fullPath = this.defects.getNextVal();
			if (this.confirmDefect(fullPath, projectPath)) {
				String projectUrl = gitLocs != null ? gitLocs.getLink(projectPath) : "";
				csvCreator.addLine(csvName, projectPath, projectUrl, fullPath, this.getName());
			}
			projectPath = this.defects.getNextKey();
		}
	}

	public Map<Metric, Set<Integer>> getRequiredPercentages() {
		return this.requiredPercentages;
	}

	protected void addRequiredPercentages() {
	}

	protected void addRequiredPercentage(Metric metric, Integer percentage) {
		if (!this.requiredPercentages.containsKey(metric)) {
			this.requiredPercentages.put(metric, new HashSet<>());
		}
		this.requiredPercentages.get(metric).add(percentage);
	}

	public abstract void addDataStores() throws IOException;

	protected void addDataStore(String name, analysis.storage.Map dataStore) {
		this.dataStores.put(name, dataStore);
	}

	protected PrimitiveIntMap getPrimitiveMapStore(String name) {
		return (PrimitiveIntMap) this.dataStores.get(name);
	}
	
	protected PrimitiveFloatMap getPrimitiveFloatMapStore(String name) {
		return (PrimitiveFloatMap) this.dataStores.get(name);
	}
	
	protected SetStrMap getPrimitiveStringMapStore(String name) {
		return (SetStrMap) this.dataStores.get(name);
	}

	protected SetIntMap getSetMapStore(String name) {
		return (SetIntMap) this.dataStores.get(name);
	}

	protected ListMap getListMapStore(String name) {
		return (ListMap) this.dataStores.get(name);
	}

	public void removeData() {
		this.defects.clean();
		this.dataStores.values().forEach(analysis.storage.Map::clean);
	}

	/**
	 * Loops through the Storage maps in DataStores and reads/writes them to file
	 * @throws IOException
	 */
	public void deserializeData() throws IOException {
		for (analysis.storage.Map m : this.dataStores.values()) {
			m.deserialize();
		}

	}

	/**
	 * What does this do?
	 * 
	 * If there is a suspects.properties file and if it contains properties it can return the file name in the property.
	 * If there is no suspects.properties file a new filename will be generated.
	 * 
	 * @return String Filename
	 * @throws IOException
	 */
	protected String getSuspectFilePath() throws IOException {
		// fetch suspect properties (which are stored names of suspected defects.)
		Properties suspectConfig = Settings.getSuspectConfig();
		// does key exist in properties?
		boolean exists = suspectConfig.containsKey(this.getName());
		// fetch folder name
		String folder = Settings.getConfig().getProperty("locations.data.output");
		// if it does exist fetch fro suspects. if it does not. create new stampedFileName with Detector name.  
		return exists ? suspectConfig.getProperty(this.getName()) : FileHelper.stampedTempFileName(folder, this.getName(), DATA_STORES_EXTENSION);
	}

	
	/**
	 * This method checks if maps.properties has defined mappings for detectors to point to data already processed.
	 * Problem is this data is never read just added to. If the mapping already has keys data is discarded. 
	 * @param type
	 * @return
	 * @throws IOException
	 */
	protected String getDataStoreFilePath(String type) throws IOException {
		Properties mapsConfig = Settings.getMapsConfig();
		String fullName = this.getName() + "_" + type;
		boolean exists = mapsConfig.containsKey(fullName);
		String folder = Settings.getConfig().getProperty("locations.data.output");
		return exists ? mapsConfig.getProperty(fullName) : FileHelper.stampedTempFileName(folder, type, DATA_STORES_EXTENSION);
	}

	//override these where necessary
	protected Boolean isPreliminarilyDefective(model.Module module) {
		return false;
	}

	protected Boolean isPreliminarilyDefective(Class cls) {
		return false;
	}

	protected Boolean isPreliminarilyDefective(Subroutine subroutine) {
		return false;
	}

	protected abstract Boolean confirmDefect(String fullPath, String projectPath);

	protected abstract String getName();

	/**
	 * Visitor for visiting modules,classes, subroutines and projects. Check each if there are possible signs of the to be detected defect. If so add to list 
	 *
	 */
	private class PreliminaryVisitor implements ContentContainerVisitor<Boolean> {

		public Boolean checkForDefect(ContentContainer contentContainer) {
			return contentContainer.accept(this);
		}

		@Override
		public Boolean visit(model.Module m) {
			return isPreliminarilyDefective(m);
		}

		@Override
		public Boolean visit(model.Class m) {
			return isPreliminarilyDefective(m);
		}

		@Override
		public Boolean visit(Subroutine m) {
			return isPreliminarilyDefective(m);
		}

		@Override
		public Boolean visit(Project m) {
			return false;
		}
	}
}
