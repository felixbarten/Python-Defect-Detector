package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
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
	private static String processedProjectsLoc = "";

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		printMain("Starting program...");
		console = System.out;
		Properties config = null;
		if (args[0] != null) {
			config = Settings.getConfig(args[0]);
		} else {
			config = Settings.getConfig();
		}
		Debugging.getInstance();
		createLocations(config);

		boolean filterEnabled = config.containsKey("locations.data.input.filter");

		PrintStream out = new PrintStream(new FileOutputStream(
				FileHelper.stampedFileName(config.getProperty("locations.log.out"), "out", "log")));
		PrintStream err = new PrintStream(new FileOutputStream(
				FileHelper.stampedFileName(config.getProperty("locations.log.error"), "err", "log")));
		System.setOut(out);

		printMain("Starting detection.");
		// Don't redirect error stream for development
		// System.setErr(err);
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
		boolean processLogging = propertyToBoolean("processing.keeplog", config);
		boolean forceReprocess = propertyToBoolean("processing.reprocess", config);

		long totalProjects = Arrays.asList(projectsFolder.listFiles()).parallelStream().filter((f) -> f.isDirectory())
				.count();

		processedProjectsLoc = config.getProperty("locations.data.outputProjects");
		long projectNum = 0;
		List<String> processedProjects = fetchProcessedProjects(config);
		for (File file : projectsFolder.listFiles()) {
			if (file.isDirectory() && (!filterEnabled || projects.contains(file.getAbsolutePath()))) {
				long startProject = System.currentTimeMillis();
				if (processedProjects.contains(file.getPath()) && !forceReprocess) {
					// deserialize project from storage
					try {
						printMain("Fetching preprocessed project from disk.");
						String projectName = file.getName();
						File serFile = new File(processedProjectsLoc + "/" + projectName + ".ser");
						if (serFile.exists()) {
							FileInputStream fis = new FileInputStream(
									processedProjectsLoc + "/" + projectName + ".ser");
							ObjectInputStream ois = new ObjectInputStream(fis);
							Project project = (Project) ois.readObject();
							ois.close();
							reprocessProject(register, project);
							projectNum++;
							printMain("Processed " + projectNum + " out of " + totalProjects + " projects.\nCompleted: "
									+ file.getName() + " in " + printExecutionTime(startProject));
							continue;
						} else {
							printMain("Serialized File could not be located. Processing normally...");
						}
					} catch (ClassNotFoundException cnf) {
						printMain("Processed project object could not be restored. Reprocessing...");
						Debugging.getInstance().debug(cnf);
					}
				}
				processProject(register, file);
				if (processLogging) {
					recordProgress(file, config);
				}
				projectNum++;
				printMain("Processed " + projectNum + " out of " + totalProjects + " projects.\nCompleted: "
						+ file.getName() + " in " + printExecutionTime(startProject));
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

	private static void recordProgress(File file, Properties config) throws FileNotFoundException {
		PrintStream print = new PrintStream(
				new FileOutputStream(config.getProperty("locations.data.input.processlog"), true));
		print.append(file.getPath());
		print.append('\n');
		print.close();
	}

	private static boolean propertyToBoolean(String key, Properties config) {
		String value = config.getProperty(key);
		if (value.equalsIgnoreCase("true")) {
			return true;
		}
		return false;
	}

	private static void reprocessProject(Register register, Project project) throws FileNotFoundException {
		register.check(project);
		System.gc();
	}

	private static void printMain(String msg) {
		System.out.println(PREFIX + msg);
		if (debugging && console != null) {
			console.println(PREFIX + msg);
		}
	}

	private static String printExecutionTime(long start) {
		long duration = System.currentTimeMillis() - start;
		return (String.format("%d days, %d hours, %d min, %d sec", TimeUnit.MILLISECONDS.toDays(duration),
				TimeUnit.MILLISECONDS.toHours(duration), TimeUnit.MILLISECONDS.toMinutes(duration),
				TimeUnit.MILLISECONDS.toSeconds(duration)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))));
	}

	/**
	 * Replaces the projects list with a new List of projects if filtering is
	 * enabled.
	 * 
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

	private static List<String> fetchProcessedProjects(Properties config) throws FileNotFoundException, IOException {

		List<String> projects = Collections.emptyList();
		String path = config.getProperty("locations.data.input.processlog");
		File CSV = new File(path);

		if (!CSV.exists()) {
			CSV.createNewFile();
		}

		BufferedReader br = new BufferedReader(new FileReader(path));
		projects = br.lines().collect(Collectors.toList());
		br.close();

		return projects;
	}

	/**
	 * Method processes a project. After gathering data from a project memory is
	 * flushed with the garbage collector to prevent running out of RAM.
	 * 
	 * @param register object with detectors that are in use for code smell
	 *                 detection
	 * @param file     object with a path to the project location
	 * @throws IOException
	 */
	private static void processProject(Register register, File file) throws IOException {
		// String memory = Long.toString(((Runtime.getRuntime().totalMemory() -
		// Runtime.getRuntime().freeMemory()) / 1024 / 1024));
		Project project = createProject(file);
		storeProject(project, file);
		register.check(project);
		System.gc();

		// printMain("Memory usage: " + memory + " -> " +
		// ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /
		// 1024 / 1024) + "\t\t" + file.getAbsolutePath());
	}

	private static void storeProject(Project project, File file) throws IOException {

		String projectName = file.getName();
		FileOutputStream fos = new FileOutputStream(processedProjectsLoc + "/" + projectName + ".ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(project);
		oos.close();
	}

	/**
	 * Registers all detector classes to the Register for futher processing.
	 * 
	 * @param register object where detectors will be registrered
	 * @throws IOException
	 */
	private static void registerDetectors(Register register) throws IOException {
		/*
		 * register.add(new LongMethodDetector()); register.add(new
		 * LongParamListDetector()); register.add(new LargeClassDetector());
		 * register.add(new DataClassDetector()); register.add(new BlobDecorDetector());
		 * register.add(new FunctionalDecompositionDecorDetector()); register.add(new
		 * SpaghettiCodeDecorDetector()); register.add(new
		 * SwissArmyKnifeDecorDetector()); register.add(new
		 * FeatureEnvyLiShatnawiDetector()); register.add(new
		 * LargeClassDecorDetector()); register.add(new DataClassDecorDetector());
		 * register.add(new DataClassDetector());
		 */
		register.add(new RefusedBequestDetector());
		register.add(new InappropriateIntimacyDetector());
	}

	/**
	 * Creates files necessary for the detector to work. Creates split log files,
	 * temporary data storage files and the result files.
	 * 
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
	 * Returns a Project object. In this method the path to the project is checked
	 * for all relevant Python files. The next step is to generate the Abstract
	 * Syntax trees. After AST's are created a symantic model is created from which
	 * a Project object can be returned.
	 * 
	 * @param File object which contains the path to the project folder
	 * @return Project object after processing the files.
	 */
	private static Project createProject(File projectFolder) {
		// printMain("Project: " + projectFolder.getAbsolutePath());
		List<String> allFiles = FileHelper.getPythonFilePaths(projectFolder);
		Map<String, Module> trees = File2Tree.getAsts(allFiles);
		ModelBuilder mb = new ModelBuilder(projectFolder, trees.values());
		return mb.getProject();
	}

}
