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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import analysis.Register;
import analysis.detector.InappropriateIntimacyDetector;
import analysis.detector.RefusedBequestDetector;
import ast.Module;
import model.ModelBuilder;
import model.Project;
import process.File2Tree;
import process.GitLocationProcessor;
import util.DebuggingLogger;
import util.FileHelper;
import util.Settings;

public class Main {

	private static GitLocationProcessor gitLocs;

	private static final String CSV_NAME = "RESULTS";
	private static final String PREFIX = "[MAIN] ";
	private static boolean debugging = true;
	private static boolean useDateDirs = false;
	private static PrintStream console;
	private static PrintStream errors;
	private static PrintStream processLog;
	private static String processedProjectsLoc = "";
	private static final long  MEGABYTE = 1024L * 1024L;
	private static boolean printTimestamp = false;
	private static int memoryUpdateFreq = 10;

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		printStartup();
		// keep local references to current printout streams (console in dev environment)
		console = System.out;
		errors = System.err;
		Properties config = null;
		if (args[0] != null) {
			config = Settings.getConfig(args[0]);
		} else {
			config = Settings.getConfig();
		}
		DebuggingLogger.getInstance();
		createLocations(config);
		printTimestamp = propertyToBoolean("console.timestamp", config);
		useDateDirs = propertyToBoolean("locations.data.useDateSubDirs", config);
		boolean filterEnabled = config.containsKey("locations.data.input.filter");

		PrintStream out = new PrintStream(new FileOutputStream(
				FileHelper.stampedFileName(config.getProperty("locations.log.out"), "out", "log")));
		PrintStream err = new PrintStream(new FileOutputStream(
				FileHelper.stampedFileName(config.getProperty("locations.log.error"), "err", "log")));
		System.setOut(out);
		System.setErr(err);
		
		Register register = setupRegister();
		setupGitLocations(config);

		
		printMain("Fetching projects...");
		// Only projects in the filtered list are processed. If filtered list exists.
		List<String> projects = fetchFilteredProjects(config, filterEnabled);
		if(filterEnabled) {
			printMain("Using filtered list with " + projects.size() + " projects.");
		}
		
		printMain("Processing projects...");
		File projectsFolder = new File(config.getProperty("locations.data.input"));
		boolean processLogging = propertyToBoolean("processing.keeplog", config);
		boolean forceReprocess = propertyToBoolean("processing.reprocess", config);
		boolean skipProcessed = propertyToBoolean("processing.skip", config);
		
		long totalProjects = Arrays.asList(projectsFolder.listFiles()).parallelStream().filter((f) -> f.isDirectory())
				.count();
		processedProjectsLoc = config.getProperty("locations.data.outputProjects");

		if(filterEnabled) {
			totalProjects = projects.size();
		}
		long projectNum = 0;
		long loopCounter = 0;
		List<String> processedProjects = fetchProcessedProjects(config);
		if(processedProjects.size() > 0 ) {
			printMain("Found: " + processedProjects.size() + " preprocessed projects.");
		}
		
		printMain("Processing projects...");
		for (File file : projectsFolder.listFiles()) {
			if (file.isDirectory() && (!filterEnabled || projects.contains(file.getAbsolutePath()))) {
				long startProject = System.currentTimeMillis();
				loopCounter++;
				out.flush();
				err.flush();
				//print memory updates every X projects
				if (loopCounter % memoryUpdateFreq == 0) {
					printHeapStatus();
				}
				// If project has already been processed and reprocessing is disabled.
				if (processedProjects.contains(file.getPath()) && !forceReprocess) {
					if(skipProcessed) {
						projectNum++;
						printMain("Processed " + projectNum + " out of " + totalProjects + " projects.");
						printMain("Skipped project: " + file.getName());
						continue;
					}
					// deserialize project from storage
					try {
						printMain("Fetching preprocessed project from disk.");
						String projectName = file.getName();
						File serFile = new File(processedProjectsLoc + "/" + projectName + ".ser");
						if (serFile.exists()) {		
							reprocessProject(register, deserializeProject(projectName));
							projectNum++;
							printMain("Processed " + projectNum + " out of " + totalProjects + " projects.");
							printMain("Completed: " + file.getName() + " in " + printExecutionTime(startProject));
							continue;
						} else {
							printMain("Serialized File could not be located. Processing normally...");
						}
					} catch (ClassNotFoundException cnf) {
						printMain("Processed project object could not be restored. Reprocessing...");
						DebuggingLogger.getInstance().debug(cnf);
					}
				}
				printMain("Starting processing of: " + file.getName());
				processProject(register, file);
				if (processLogging) {
					recordProgress(file, config);
				}
				projectNum++;
				printMain("Processed " + projectNum + " out of " + totalProjects + " projects.");
				printMain("Completed: "	+ file.getName() + " in " + printExecutionTime(startProject));
			}
		}
		printMain("Finished processing projects.");

		CsvCreator csvCreator = new CsvCreator(config.getProperty("locations.data.results"));
		csvCreator.createStream(CSV_NAME, "Project", "Url", "Location", "Defect");
		register.finish(gitLocs, csvCreator);
		String endTime = printExecutionTime(startTime);
		printMain("Finished program in : " + endTime);

		exit(out, err);
	}

	/**
	 * Load git locations.
	 * @param config
	 */
	private static void setupGitLocations(Properties config) {
		printMain("Reading Git Location data");
		// TODO gitlocs seems to be broken
		gitLocs = new GitLocationProcessor(config.getProperty("locations.data.input.disklocations"));
		gitLocs.readData();
		printMain("Finished reading Git Location data");
	}

	/**
	 * @return register with all detectors registered. 
	 * @throws IOException
	 */
	private static Register setupRegister() throws IOException {
		printMain("Registering detectors...");
		Register register = new Register();
		registerDetectors(register);
		printMain("Registered detectors.");
		return register;
	}

	private static void printStartup() {
		printMain("Starting program...");
		printMain("Starting with JVM max heap size: " +  (Runtime.getRuntime().maxMemory() / MEGABYTE / 1024) + " GB");
	}

	/**
	 * Returns a Project object from a serialized file.
	 * @param projectName
	 * @return Project object from file. 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static Project deserializeProject(String projectName)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(
				processedProjectsLoc + "/" + projectName + ".ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Project project = (Project) ois.readObject();
		ois.close();
		return project;
	}

	/**
	 * Final method. close all open printstreams and exit program. 
	 */
	private static void exit(PrintStream out, PrintStream err) {
		err.flush();
		out.flush();
		err.close();
		out.close();
		if (processLog != null) {
			processLog.flush();
			processLog.close();
		}
	}

	private static void printHeapStatus() {
		// stackoverflow provides
		// Get current size of heap in bytes && convert to MB.
		long heapSize = Runtime.getRuntime().totalMemory() / MEGABYTE; 
		// Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
		long heapMaxSize = Runtime.getRuntime().maxMemory() / MEGABYTE;
		 // Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
		long heapFreeSize = Runtime.getRuntime().freeMemory() / MEGABYTE; 		
		printMain("<------------------------------------------------------------------------------>");
		printMain("Current memory use: " + (heapSize - heapFreeSize) + " MB Max size: " + heapMaxSize + " MB");
		printMain("<------------------------------------------------------------------------------>");

	}

	private static void recordProgress(File file, Properties config) throws FileNotFoundException {
		if(processLog == null) {
			processLog = new PrintStream(
					new FileOutputStream(config.getProperty("locations.data.input.processlog"), true));
		}
		processLog.append(file.getPath());
		processLog.append('\n');
	}

	/**
	 * Wrapper for boolean inference from String values. If key doesn't exist assume false.
	 * 
	 * @param key
	 * @param config
	 * @return
	 */
	private static boolean propertyToBoolean(String key, Properties config) {
		if (config.containsKey(key)) {
			return config.getProperty(key).equalsIgnoreCase("true");			
		} 
		return false;
	}

	/**
	 * Reprocess a project that has been marked as processed. 
	 * @param register
	 * @param project
	 * @param skipProcessed 
	 * @throws FileNotFoundException
	 */
	private static void reprocessProject(Register register, Project project) throws FileNotFoundException {
		register.check(project, true);
		runGarbageCollection();
	}

	private static void printMain(String msg) {
		String timeStamp = "";
		if(printTimestamp) {
			timeStamp = new SimpleDateFormat("[HH:mm:ss]").format(new Date());
		}
		
		System.out.println(timeStamp + PREFIX + msg);
		if (debugging && console != null) {
			console.println(timeStamp + PREFIX + msg);
		}
	}

	/**
	 * Prints the execution time from the parameter starts's time to now.
	 * @param start time in milliseconds 
	 * @return formatted time string between start and now. 
	 */
	private static String printExecutionTime(long start) {
		long duration = System.currentTimeMillis() - start;
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		long hours = TimeUnit.MILLISECONDS.toHours(duration) % 24;
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration) % 60;
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)	- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
		
		return (String.format("%d days, %d hours, %d min, %d sec", days, hours, minutes, seconds));
	}

	/**
	 * Replaces the projects list with a new List of projects if filtering is
	 * enabled.
	 * 
	 * @param config
	 * @param boolean to enable or disable filtering.
	 * @return list of projects for processing.
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
	 * Fetch projects from process log file.
	 * 
	 * @param config
	 * @return List of processed projects.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static List<String> fetchProcessedProjects(Properties config) throws FileNotFoundException, IOException {
		List<String> projects = Collections.emptyList();
		String path = config.getProperty("locations.data.input.processlog");
		if (path == null) {
			return projects;
		}
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
		Project project = createProject(file);
		storeProject(project, file);
		register.check(project, false);
		runGarbageCollection();
	}

	private static void runGarbageCollection() {
		long preGC = Runtime.getRuntime().totalMemory() / MEGABYTE;
		System.gc();
		long postGC = Runtime.getRuntime().totalMemory() / MEGABYTE; 	
		long current = postGC - (Runtime.getRuntime().freeMemory() / MEGABYTE);
		if (preGC > postGC) {
			printMain("[GC] Freed up " + (preGC - postGC) + " MB after GC. Current memory usage: " + current + " MB");
		}
	}

	/**
	 * Serialize Project object to file.
	 * 
	 * @param project
	 * @param file
	 * @throws IOException
	 */
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
		 * Add detectors. 
		 * 
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
		FileHelper.createLocation(config.getProperty("locations.log.out"), useDateDirs);
		FileHelper.createLocation(config.getProperty("locations.log.error"), useDateDirs);
		FileHelper.createLocation(config.getProperty("locations.data.input"), false);
		FileHelper.createLocation(config.getProperty("locations.data.output"), useDateDirs);
		FileHelper.createLocation(config.getProperty("locations.data.results"), useDateDirs);
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
		List<String> allFiles = FileHelper.getPythonFilePaths(projectFolder);
		Map<String, Module> trees = File2Tree.getAsts(allFiles);
		ModelBuilder mb = new ModelBuilder(projectFolder, trees.values());
		return mb.getProject();
	}

}
