package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Properties;

import util.FileHelper;
import util.Settings;
import util.StringHelper;

/**
 * This small program takes input from StatsCSVCreator and runs all the programs through a filter to check if they are within filter parameters. 
 * The output can be used directly by enabling filtering in the config file.
 * 
 * @author felix
 *
 */
public class AggregateCSVData {

	private static String STORAGE = "aggregate";
	private static String STORAGESTATS = "aggregatedata";

	private static String TOTALS = "totalStats";
	private static String EXTENSION = "txt";
	private static final String delimiter = ";";
	
	/**
	 * args[0] config name
	 * args[1] path to stats file. 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		Properties config = null;

		long moduleCount = 0, locCount = 0, classCount = 0;
		if (args[0] != null) {
			config = Settings.getConfig(args[0]);
		} else {
			config = Settings.getConfig();
		}
		// set logging. 
		PrintStream err = new PrintStream(new FileOutputStream(FileHelper.stampedFileName(config.getProperty("locations.log.error"), "err", "log")));
		System.setErr(err);
		
		// supply path to project_stats.csv 
		
		String path = null;
		if(args[1] != null) {
			path = args[1];
		} else {
			System.out.println("No stats file supplied.");
			System.exit(0);
		}

		File resultsStorage = new File(FileHelper.stampedFileName(config.getProperty("locations.data.results"), STORAGE, EXTENSION));
		if(!resultsStorage.exists()) {
			resultsStorage.createNewFile();
		}
		
		File resultsStatsStorage = new File(FileHelper.stampedFileName(config.getProperty("locations.data.results"), STORAGESTATS, EXTENSION));
		if(!resultsStatsStorage.exists()) {
			resultsStatsStorage.createNewFile();
		}
		PrintStream results = new PrintStream(resultsStorage);
		PrintStream resultsStats = new PrintStream(resultsStatsStorage);
		int projectCount = 0, accepted = 0, rejected = 0;		
		// layout of stats file: project;git link;modules;LOC;classes;parse ratio
		File statsCSV = new File(path);
		if (statsCSV.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(statsCSV));
			String line;
			br.readLine();
			Long loc = 0L;
			String currentProject = "";
			while((line = br.readLine()) != null) {
				projectCount++;
				String[] data = line.split(";");
				// filter desirable projects and write to file the projects to be kept. 	
				String project = data[0];
				Integer clsLOC = Integer.parseInt(data[8]);
				if (currentProject == "") {
					currentProject = project;
				}
				
				if(!project.equals(currentProject)) {
					results.println(currentProject + ";" + loc);
					resultsStats.println(loc);
					currentProject = project;
					loc = 0L;
				}
				loc += clsLOC; 

			}
			results.println("Project: " + currentProject + "CLSLOC: " + loc);
		}
		results.close();
		resultsStats.close();
		File totalsStorage = new File(FileHelper.stampedFileName(config.getProperty("locations.data.results"), TOTALS, EXTENSION));
		if (!totalsStorage.exists()) {
			totalsStorage.createNewFile();
		}
		PrintStream totals = new PrintStream(totalsStorage);
		totals.println("modules;LOC;classes");
		totals.println(moduleCount + ";" + locCount + ";" + classCount);
		totals.close();
		System.out.println("Finished Filtering.\nProjects: " + projectCount + ". " + accepted + " accepted. " + rejected +" rejected");
	}
	
	private static void printRejection(String reason) {
		System.out.println("Rejected due to: " + reason);
	}
}
