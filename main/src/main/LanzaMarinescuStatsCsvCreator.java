package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import ast.Module;
import model.Class;
import model.ModelBuilder;
import model.Project;
import model.Subroutine;
import model.VarType;
import model.Variable;
import process.File2Tree;
import process.GitLocationProcessor;
import util.FileHelper;

/**
 * Refactored for Lanza/marinescu stats.
 * @author felixbarten
 *
 */
public class LanzaMarinescuStatsCsvCreator extends CsvCreator {
	private final List<File> projectFolders;
	private final GitLocationProcessor gitLocs;
	private final String filterFile;
	private boolean filtering = true;

	private static final String CLASS_STREAM_NAME = "class";
	private static final String MODULE_STREAM_NAME = "module";
	private static final String PROJECT_STREAM_NAME = "project";
	private static final String METRICS_STREAM_NAME = "metrics";
	
	public LanzaMarinescuStatsCsvCreator(List<File> projectFolders, Properties config) {
		super(config.getProperty("locations.data.results"));
		this.filterFile = config.getProperty("locations.data.input.filter");
		this.projectFolders = projectFolders;
		this.gitLocs = new GitLocationProcessor(config.getProperty("locations.data.input.disklocations"));
		this.gitLocs.readData();
		if (this.filterFile == null) {
			this.filtering = false;
		}
	}

	public void createStatsCsv() throws IOException {
		this.createClassStream();
		this.createModuleStream();
		this.createProjectStream();
		this.createMetricsStream();

		List<String> projects = new ArrayList<String>();

		if (this.filterFile != null) {
			BufferedReader br = new BufferedReader(new FileReader(this.filterFile));
			projects = br.lines().collect(Collectors.toList());
			br.close();
			System.out.println("Filtered projects: " + projects.size());
		}

		for (File f : this.projectFolders) {
			if (!filtering) {
				this.createStatsCsv(f);
				System.gc();
			} else {
				if (projects.contains(f.getAbsolutePath())) {
					this.createStatsCsv(f);
					System.gc();
				}
			}
		}
	}

	private void createClassStream() throws IOException {
		this.createStream(CLASS_STREAM_NAME, "project", "module", "class name", "# of private variables",
				"# of protected variables", "# of public variables", "# of accessors", "LCOM", "LOC", "CC", "# of parents",
				"# of methods with no params", "# of used globals", "# of defined globals", "# of methods",
				"total method AID", "total method ALD", "average method AID", "average method ALD");
	}

	private void createModuleStream() throws IOException {
		this.createStream(MODULE_STREAM_NAME, "project", "git link", "module", "parses", "LOC", "# of classes", "# of methods");
	}

	private void createProjectStream() throws IOException {
		this.createStream(PROJECT_STREAM_NAME, 
				"project", 
				"git link", 
				"modules", 
				"LOC(project)", 
				"LOC(classes)", 
				"CC(project)", 
				"CC(classes)", 
				"NOM(project)",
				"NOM(classes)", 
				"# classes", 
				"parse ratio");
	}

	private void createMetricsStream() throws IOException {
		this.createStream(METRICS_STREAM_NAME, 
				"project", 
				"CYCLO/LOC",
				"LOC/Method", 
				"NOM/Class",
				"LOC(project)", 
				"LOC(classes)",
				"CC(project)",
				"CC(classes)",
				"NOM(project)",	
				"NOM(classes)",
				"# classes",
				"# modules",  
				"parse ratio");
	}

	private void createStatsCsv(File projectFolder) {
		System.out.println("----------------------------------------------- NEW PROJECT -----------------------------------------------");
		System.out.println("Name: " + projectFolder.getAbsolutePath());
		try {
			List<String> allFiles = FileHelper.getPythonFilePaths(projectFolder);
			Map<String, Module> trees = File2Tree.getAsts(allFiles);
			ModelBuilder mb = new ModelBuilder(projectFolder, trees.values());
			Project project = mb.getProject();
			String link = this.gitLocs.getLink(project.getPath());

			Long totalLOC = 0L;
			Long classLOC = 0L;

			Integer classCount = 0;
			Integer classNOM = 0;
			Integer totalNOM = 0;
			Integer correctlyParsed = 0;
			Integer classCC = 0;
			AtomicInteger totalCC= new AtomicInteger(0);
			for (model.Module module : project.getModules()) {
				this.printModuleLine(module, project.getPath(), link);

				Map<String, model.Class> classes = module.getDefinedClassesInclSubclassesByName();
				classCount += classes.size();
				for (String clsAlias : classes.keySet()) {
					Class cls = classes.get(clsAlias);
					this.printClassLine(clsAlias, cls, project.getPath(), module.getFilePath());
					classCC += cls.getCC();
					classNOM += cls.getNOM();
					classLOC += cls.getLoc();
				}

				if (!module.hasError()) {
					correctlyParsed++;
				}
				int moduleLOC = module.getLoc();
				AtomicInteger adjustedLOC = new AtomicInteger(0);
				module.getDefinedClassesInclSubclassesSet().stream().forEach((f) -> {
					adjustedLOC.addAndGet(f.getLoc());
				});
				module.getDefinedSubroutinesSet().stream().forEach((s) -> {
					adjustedLOC.addAndGet(s.getLoc());
				});
				
				if(moduleLOC != adjustedLOC.intValue()) {
					// 
					System.out.println("LOC values diverge");
				}
				
				
				totalLOC += module.getLoc();
				totalNOM += module.getDefinedSubroutinesSet().size();
				
				module.getDefinedSubroutinesSet().stream().forEach((f) -> {
					totalCC.addAndGet(f.getCC());
				});
			}
			int moduleCount = project.getModules().size();
			Double corrParse = correctlyParsed.doubleValue() / moduleCount;
			this.printProjectLine(project.getPath(), 
					link, 
					moduleCount, 
					totalLOC, 
					classLOC, 
					totalCC.get(), 
					classCC, 
					totalNOM, 
					classNOM, 
					classCount,
					corrParse);
			// maybe more low level would be better and then add all values divided by the
			// amount of figures.

			this.printMetricsLine(project.getPath(), 
					moduleCount, 
					totalLOC, 
					classLOC,  
					totalCC.get(),
					classCC,
					totalNOM,
					classNOM, 
					classCount, 
					corrParse
					);
			
		} catch (Exception ex) {
			System.err.println("EXCEPTION: " + ex.getMessage());
			ex.printStackTrace();
		}
		System.gc();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------");
	}

	private void printMetricsLine(String projectPath, 
			Integer moduleCount, 
			Long totalLOC, 
			Long classLOC, 
			Integer totalCC,
			Integer classCC, 
			Integer totalNOM, 
			Integer classNOM, 

			Integer classCount, 
			Double ParseRatio) {
		
		List<String> statsLine = this.createMetricsLine(projectPath, 
				moduleCount, 
				totalLOC, 
				classLOC, 
				totalCC,
				classCC,  
				totalNOM,
				classNOM,
				classCount, 
				ParseRatio);
		this.addLine(METRICS_STREAM_NAME, statsLine);
	}

	private void printProjectLine(String projectPath, 
			String gitLink, 
			Integer moduleCount, 
			Long totalLOC,
			Long classLOC, 
			Integer totalCC,
			Integer classCC,
			Integer totalNOM,  
			Integer classNOM,
			Integer classCount,
			Double parseRatio) {
		
		List<String> projectLine = this.createProjectLine(projectPath, 
				gitLink, 
				moduleCount, 
				totalLOC,
				classLOC,
				totalCC,
				classCC,
				totalNOM,
				classNOM,
				classCount,
				parseRatio);
		this.addLine(PROJECT_STREAM_NAME, projectLine);
	}

	private void printModuleLine(model.Module module, String projectPath, String gitLink) {
		List<String> moduleLine = this.createModuleLine(module, projectPath, gitLink);
		this.addLine(MODULE_STREAM_NAME, moduleLine);
	}

	private void printClassLine(String alias, model.Class cls, String projectPath, String modulePath) {
		List<String> classLine = this.createClassLine(alias, cls, projectPath, modulePath);
		this.addLine(CLASS_STREAM_NAME, classLine);
	}

	private List<String> createMetricsLine(
			String projectPath, 
			Integer moduleCount, 
			Long totalLOC, 
			Long classLOC, 
			Integer totalCC,
			Integer classCC,	
			Integer totalNOM,
			Integer classNOM, 
			Integer classCount,
			Double parseRatio) {
		
		Double parsePercentage = parseRatio * 100;

		List<String> line = new ArrayList<>();
		line.add(projectPath);
		// line.add(moduleCount);
		// fill space.
		line.add("TBD");
		line.add("TBD");
		line.add("TBD");
		// total then specific.
		
		line.add(totalLOC.toString());
		line.add(classLOC.toString());
		line.add(totalCC.toString());
		line.add(classCC.toString());
		
		line.add(totalNOM.toString());
		line.add(classNOM.toString());
		
		line.add(classCount.toString());
		line.add(moduleCount.toString());
		line.add(parsePercentage.toString());
		return line;
	}

	private List<String> createProjectLine(String projectPath, 
			String gitLink, 
			Integer moduleCount, 
			Long totalLOC, 
			Long classLOC, 
			Integer totalCC,
			Integer classCC,	
			Integer totalNOM,
			Integer classNOM, 
			Integer classCount,
			Double parseRatio) {
		Double parsePercentage = parseRatio * 100;

		List<String> line = new ArrayList<>();
		line.add(projectPath);
		line.add(gitLink);
		line.add(String.valueOf(moduleCount));
		line.add(String.valueOf(totalLOC));
		line.add(String.valueOf(classLOC));
		line.add(String.valueOf(totalCC));
		line.add(String.valueOf(classCC));
		line.add(String.valueOf(totalNOM));
		line.add(String.valueOf(classNOM));

		line.add(String.valueOf(classCount));
		line.add(String.valueOf(parsePercentage.intValue()));
		return line;
	}

	private List<String> createModuleLine(model.Module module, String projectPath, String gitLink) {
		List<String> line = new ArrayList<>();
		line.add(projectPath);
		line.add(gitLink);
		line.add(module.getFilePath());
		line.add(module.hasError() ? "0" : "1");
		line.add(String.valueOf(module.getLoc()));
		//line.add(String.valueOf(module.getCC()));
		line.add(String.valueOf(module.getDefinedClassesInclSubclassesSet().size()));
		line.add(String.valueOf(module.getDefinedSubroutinesSet().size()));
		return line;
	}

	private List<String> createClassLine(String alias, model.Class cls, String projectPath, String modulePath) {
		List<String> line = new ArrayList<>();
		line.add(projectPath);
		line.add(modulePath);
		line.add(alias);
		line.add(String.valueOf(cls.getDefinedVariablesSet().stream().filter(Variable::isPrivate).count()));
		line.add(String.valueOf(cls.getDefinedVariablesSet().stream().filter(Variable::isProtected).count()));
		line.add(String.valueOf(cls.getDefinedVariablesSet().stream().filter(Variable::isPublic).count()));
		line.add(String.valueOf(cls.getDefinedSubroutinesSet().stream().filter(Subroutine::isAccessor).count()));
		line.add(String.valueOf(cls.getLcom()));
		line.add(String.valueOf(cls.getLoc()));
		line.add(String.valueOf(cls.getCC()));
		line.add(String.valueOf(cls.superclassCount()));
		line.add(String.valueOf(cls.subroutinesWithNoParamsCount()));
		line.add(String.valueOf(cls.getReferencedGlobalsSet().size()));
		line.add(String.valueOf(cls.getDefinedVariablesOfTypeSet(VarType.GLOBAL).size()));

		int amountMethods = cls.getDefinedSubroutinesSet().size();
		Double aid = 0.0;
		Double ald = 0.0;
		for (Subroutine s : cls.getDefinedSubroutinesSet()) {
			aid += s.getAccessOfImportData();
			ald += s.getAccessOfLocalData();
		}

		line.add(String.valueOf(amountMethods));
		line.add(String.valueOf(aid));
		line.add(String.valueOf(ald));
		line.add(String.valueOf(amountMethods != 0 ? aid / amountMethods : 0));
		line.add(String.valueOf(amountMethods != 0 ? ald / amountMethods : 0));

		return line;
	}
}