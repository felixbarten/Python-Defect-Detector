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
		this.createStream(MODULE_STREAM_NAME, "project", "git link", "module", "parses", "LOC", "# of classes");
	}

	private void createProjectStream() throws IOException {
		this.createStream(PROJECT_STREAM_NAME, "project", "git link", "modules", "LOC", "CC", "classes", "parse ratio");
	}

	private void createMetricsStream() throws IOException {
		this.createStream(METRICS_STREAM_NAME, "project", "CYCLO/LOC", "LOC/Method", "NOM/Class", "LOC", "CC", "NOM",
				"classes", "modules",  "parse ratio");
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

			Long LOC = 0L;
			Integer classCount = 0;
			Integer NOM = 0;
			Integer correctlyParsed = 0;
			Integer CC = 0;
			for (model.Module module : project.getModules()) {
				this.printModuleLine(module, project.getPath(), link);

				Map<String, model.Class> classes = module.getDefinedClassesInclSubclassesByName();
				classCount += classes.size();
				for (String clsAlias : classes.keySet()) {
					Class cls = classes.get(clsAlias);
					this.printClassLine(clsAlias, cls, project.getPath(), module.getFilePath());
					CC += cls.getCC();
					NOM += cls.getNOM();
				}

				if (!module.hasError()) {
					correctlyParsed++;
				}
				LOC += module.getLoc();
			}
			int moduleCount = project.getModules().size();
			Double corrParse = correctlyParsed.doubleValue() / moduleCount;
			this.printProjectLine(project.getPath(), link, moduleCount, LOC, CC, classCount,
					corrParse);
			// maybe more low level would be better and then add all values divided by the
			// amount of figures.
			BigDecimal bdLOC, bdCC, bdNOM;
			bdLOC = new BigDecimal(LOC);
			bdCC = new BigDecimal(CC);
			bdNOM = new BigDecimal(NOM);
			
			MathContext context = new MathContext(32);
			
			BigDecimal cycloLOC =  new BigDecimal(0);
			BigDecimal locMethod = new BigDecimal(0);
			BigDecimal nomClass = new BigDecimal(0);

			// div/0
			if(bdLOC.intValue() != 0) {
				cycloLOC = bdCC.divide(bdLOC,context);
			} else {
				cycloLOC = bdCC.divide(new BigDecimal(1),context);
			}
			
			if(bdNOM.intValue() != 0) {
				locMethod = bdLOC.divide(bdNOM, context);
			} else {
				locMethod = bdLOC.divide(new BigDecimal(1), context);
			}
			
			if(classCount != 0) {
				nomClass = bdNOM.divide(new BigDecimal(classCount), context);
			} else {
				nomClass = bdNOM.divide(new BigDecimal(1), context);
			}

			this.printMetricsLine(project.getPath(), moduleCount, LOC, CC, NOM,  
					classCount, 
					corrParse, 
					cycloLOC,
					nomClass, 
					locMethod);
			
		} catch (Exception ex) {
			System.err.println("EXCEPTION: " + ex.getMessage());
			ex.printStackTrace();
		}
		System.gc();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------");
	}

	private void printMetricsLine(String projectPath, Integer moduleCount, Long LOC, Integer CC, Integer NOM,
			Integer classCount, 
			Double ParseRatio,
			BigDecimal cycloLOC, 
			BigDecimal nomClass, 
			BigDecimal locMethod) {
		
		List<String> statsLine = this.createMetricsLine(projectPath, moduleCount, LOC, CC, NOM, classCount, ParseRatio,
				cycloLOC, nomClass, locMethod);
		this.addLine(METRICS_STREAM_NAME, statsLine);
	}

	private void printProjectLine(String projectPath, String gitLink, Integer moduleCount, Long loc, Integer CC,  Integer classCount,
			Double parseRatio) {
		List<String> projectLine = this.createProjectLine(projectPath, gitLink, moduleCount, loc, CC, classCount,
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

	private List<String> createMetricsLine(String projectPath, 
			Integer moduleCount, Long loc, Integer cc,
			Integer NOM, Integer classCount,
			Double parseRatio, BigDecimal cycloLOC,
			BigDecimal nomClass, BigDecimal locMethod) {
		
		Double parsePercentage = parseRatio * 100;

		List<String> line = new ArrayList<>();
		line.add(projectPath);
		// line.add(moduleCount);
		line.add(String.valueOf(cycloLOC));
		line.add(String.valueOf(locMethod));
		line.add(String.valueOf(nomClass));

		line.add(loc.toString());
		line.add(cc.toString());
		line.add(NOM.toString());

		line.add(classCount.toString());
		line.add(moduleCount.toString());
		line.add(parsePercentage.toString());
		return line;
	}

	private List<String> createProjectLine(String projectPath, String gitLink, 
			Integer moduleCount, Long loc, Integer CC,
			Integer classCount, Double parseRatio) {
		Double parsePercentage = parseRatio * 100;

		List<String> line = new ArrayList<>();
		line.add(projectPath);
		line.add(gitLink);
		line.add(String.valueOf(moduleCount));
		line.add(String.valueOf(loc));
		line.add(String.valueOf(CC));
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