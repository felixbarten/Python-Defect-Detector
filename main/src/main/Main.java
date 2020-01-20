package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import analysis.Register;
import analysis.detector.InappropriateIntimacyDetector;
import analysis.detector.RefusedBequestDetector;
import ast.Module;
import model.ModelBuilder;
import model.Project;
import process.File2Tree;
import process.GitLocationProcessor;
import util.Debugging;
import util.FileHelper;
import util.Settings;

public class Main {

	private static GitLocationProcessor gitLocs;

	private static final String CSV_NAME = "RESULTS";
	private static final String PREFIX = "[MAIN] ";
	private static boolean debugging = true;
	private static PrintStream console;

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		printMain("Starting program...");
		console = System.out;
		Properties config = null;
		if(args[0] != null) {
			config = Settings.getConfig(args[0]);
		} else {
			config = Settings.getConfig();
		}
		Debugging.getInstance();
		createLocations(config);

		boolean filterEnabled = config.containsKey("locations.data.input.filter");
		
		PrintStream out = new PrintStream(new FileOutputStream(FileHelper.stampedFileName(config.getProperty("locations.log.out"), "out", "log")));
		PrintStream err = new PrintStream(new FileOutputStream(FileHelper.stampedFileName(config.getProperty("locations.log.error"), "err", "log")));
		System.setOut(out);
		
		printMain("Starting detection.");
		// Don't redirect error stream for development
		//System.setErr(err);
		printMain("Registering detectors...");

		Register register = new Register();
		registerDetectors(register);
		printMain("Registered detectors.");
		
		printMain("Reading Git Location data");
		gitLocs = new GitLocationProcessor(config.getProperty("locations.data.input.disklocations"));
		gitLocs.readData();
		printMain("Finished reading Git Location data");

		
		printMain("Fetching projects...");
		// Only projects in the filtered list are processed. If filtered list exists.
		List<String> projects = fetchFilteredProjects(config, filterEnabled);
		printMain("Fetched projects.");
		printMain("Processing projects...");
		File projectsFolder = new File(config.getProperty("locations.data.input"));
		
		for (File file : projectsFolder.listFiles()) {
			if (file.isDirectory() && (!filterEnabled || projects.contains(file.getAbsolutePath()))) {
				long startProject = System.currentTimeMillis();
				processProject(register, file);
				printMain("Processed project: " + file.toString() + " in " + printExecutionTime(startProject));
			}
		}
		printMain("Finished processing projects.");

		CsvCreator csvCreator = new CsvCreator(config.getProperty("locations.data.results"));
		csvCreator.createStream(CSV_NAME, "Project", "Url", "Location", "Defect");
		register.finish(gitLocs, csvCreator);
		err.close();
		String endTime = printExecutionTime(startTime);
		console.println(PREFIX + " Finished program in : " + endTime);
	}

	private static void printMain(String msg) {
		System.out.println(PREFIX + msg);
		if(debugging && console != null) {
			console.println(PREFIX + msg);
		}
	}

	private static String printExecutionTime(long start) { 
		long duration = System.currentTimeMillis() - start;
		return (String.format("%d days, %d hours, %d min, %d sec", 
				TimeUnit.MILLISECONDS.toDays(duration),
				TimeUnit.MILLISECONDS.toHours(duration),
			    TimeUnit.MILLISECONDS.toMinutes(duration),
			    TimeUnit.MILLISECONDS.toSeconds(duration) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
			));
	}
	
	/**
	 * Replaces the projects list with a new List of projects if filtering is enabled. 
	 * @param config
	 * @param boolean to enable or disable filtering. 
	 * @return list of projects for processing
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static List<String> fetchFilteredProjects(Properties config, boolean filterEnabled)
			throws FileNotFoundException, IOException {
		List<String> projects = Collections.emptyList();
		if (filterEnabled) {
			BufferedReader br = new BufferedReader(new FileReader(config.getProperty("locations.data.input.filter")));
			projects = br.lines().collect(Collectors.toList());
			br.close();
		}
		return projects;
	}

	/**
	 * Method processes a project. After gathering data from a project memory is flushed with the garbage collector to prevent running out of RAM. 
	 * @param register object with detectors that are in use for code smell detection
	 * @param file object with a path to the project location
	 * @throws FileNotFoundException
	 */
	private static void processProject(Register register, File file) throws FileNotFoundException {
		//String memory = Long.toString(((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024));
		Project project = createProject(file);
		register.check(project);
		System.gc();
		//printMain("Memory usage: " + memory + " -> " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024) + "\t\t" + file.getAbsolutePath());
	}

	
	/**
	 * Registers all detector classes to the Register for futher processing.
	 * @param register object where detectors will be registrered 
	 * @throws IOException
	 */
	private static void registerDetectors(Register register) throws IOException {
		/*
		register.add(new LongMethodDetector());
		register.add(new LongParamListDetector());
		register.add(new LargeClassDetector());
		register.add(new DataClassDetector());
		register.add(new BlobDecorDetector());
		register.add(new FunctionalDecompositionDecorDetector());
		register.add(new SpaghettiCodeDecorDetector());
		register.add(new SwissArmyKnifeDecorDetector());
		register.add(new FeatureEnvyLiShatnawiDetector());
		register.add(new LargeClassDecorDetector());
		register.add(new DataClassDecorDetector());
		register.add(new DataClassDetector());
		*/
		register.add(new RefusedBequestDetector());
		register.add(new InappropriateIntimacyDetector());
	}

	/**
	 * Creates files necessary for the detector to work. Creates split log files, temporary data storage files and the result files.
	 * @param Config object from which to retrieve the file paths. 
	 */
	private static void createLocations(Properties config) {
		FileHelper.createLocation(config.getProperty("locations.log.out"), true);
		FileHelper.createLocation(config.getProperty("locations.log.error"), true);
		FileHelper.createLocation(config.getProperty("locations.data.input"), false);
		FileHelper.createLocation(config.getProperty("locations.data.output"), true);
		FileHelper.createLocation(config.getProperty("locations.data.results"), true);
	}

	/**
	 * Returns a Project object. In this method the path to the project is checked for all relevant Python files. 
	 * The next step is to generate the Abstract Syntax trees. After AST's are created 
	 * a symantic model is created from which a Project object can be returned.
	 * @param File object which contains the path to the project folder
	 * @return Project object after processing the files.
	 */
	private static Project createProject(File projectFolder) {
		//printMain("Project: " + projectFolder.getAbsolutePath());
		List<String> allFiles = FileHelper.getPythonFilePaths(projectFolder);
		Map<String, Module> trees = File2Tree.getAsts(allFiles);
		ModelBuilder mb = new ModelBuilder(projectFolder, trees.values());
		return mb.getProject();
	}

}
