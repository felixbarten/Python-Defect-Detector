package analysis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import analysis.detector.Detector;
import main.CsvCreator;
import model.ContentContainer;
import model.Project;
import process.GitLocationProcessor;

/**
 * This class keeps track of the smell detectors by registering them. 
 * Created by Nik on 04-11-2015
 */
public class Register {

	private static final String CSV_NAME = "RESULTS";

	private final List<Detector> detectors;
	private final Metrics metrics;
	private boolean allDetectorsAdded;
	private boolean finished;

	public Register() throws IOException {
		this.detectors = new ArrayList<>();
		this.metrics = new Metrics();
		this.allDetectorsAdded = false;
	}

	/**
	 * Add a detector
	 * @param detector
	 */
	public void add(Detector detector) {
		if (this.allDetectorsAdded) {
			throw new IllegalStateException();
		}
		detector.addMetrics(this.metrics);
		this.detectors.add(detector);
	}

	/**
	 * Perform checking on a project by iterating through python modules. Don't allow more detectors to be added at this step. 
	 * @param project
	 * @throws FileNotFoundException
	 */
	public void check(Project project) throws FileNotFoundException {
		if (this.finished) {
			throw new IllegalStateException();
		}
		if (!this.allDetectorsAdded) {
			this.allDetectorsAdded = true; //don't allow any additional detectors
		}
		
		project.getModules().forEach(m -> this.check(project.getPath(), m));
		this.metrics.getProjectData(project); //write metric data for one project. 
		
		project.unlink();
	}

	private void checkProject(String path, Project project) {
		//this.metrics.register(contentContainer);

	}

	/**
	 * Overloaded check method. Goes deeper into modules in previous check method. Recurses on itself untill there are no more internal children in the ContentContainer. 
	 * @param projectPath
	 * @param contentContainer
	 */
	private void check(String projectPath, ContentContainer contentContainer) {
		this.metrics.register(contentContainer);
		this.detectors.forEach(d -> d.process(projectPath, contentContainer));
		contentContainer.getChildren().forEach(c -> this.check(projectPath, c));
	}

	/**
	 * Finish method after all checking has been performed. Blocks additional checking from taking place. Iterates through detectors to save data to disk. 
	 * 
	 * *important* Deserialize has to be called before anything else. If deserialize is called late the data gathered during the running of the detector 
	 * will only exist on disk and will not be loaded into memory.
	 * @param gitLocs
	 * @param csvCreator
	 * @throws IOException
	 */
	public void finish(GitLocationProcessor gitLocs, CsvCreator csvCreator) throws IOException {
		this.finished = true; //don't allow any additional checking
		Map<Metric, Set<Integer>> reqMetrics = aggregateRequiredMetrics();
		this.metrics.terminateCollecting(reqMetrics);
		this.metrics.getGlobalData().deserializeData();

		for (Detector detector : this.detectors) {
			detector.deserializeData();
			detector.finish(gitLocs, csvCreator, CSV_NAME);
			detector.removeData();
		}
		this.metrics.getGlobalData().deserializeData();
		// where to deserialize
	}

	private Map<Metric, Set<Integer>> aggregateRequiredMetrics() {
		Map<Metric, Set<Integer>> aggregatedRequiredMetrics = new HashMap<>();
		for (Detector detector : this.detectors) {
			Map<Metric, Set<Integer>> detectorPercentages = detector.getRequiredPercentages();
			for (Metric metric : detectorPercentages.keySet()) {
				if (!aggregatedRequiredMetrics.containsKey(metric)) {
					aggregatedRequiredMetrics.put(metric, new HashSet<>());
				}
				aggregatedRequiredMetrics.get(metric).addAll(detectorPercentages.get(metric));
			}
		}
		return aggregatedRequiredMetrics;
	}
}
