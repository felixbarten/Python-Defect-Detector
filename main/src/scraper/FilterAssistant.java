package scraper;

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
public class FilterAssistant {

	
	private static int locThreshold = 50;
	private static int classCountThreshold = 20;
	private static int parseRatioThreshold = 90;
	private static String STORAGE = "filtered";
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
		PrintStream results = new PrintStream(resultsStorage);
		int projectCount = 0, accepted = 0, rejected = 0;		
		// layout of stats file: project;git link;modules;LOC;classes;parse ratio
		File statsCSV = new File(path);
		if (statsCSV.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(statsCSV));
			String line;
			br.readLine();
			while((line = br.readLine()) != null) {
				projectCount++;
				String[] data = line.split(";");
				// filter desirable projects and write to file the projects to be kept. 	
				if (filter(data)) {
					accepted++;
					//results.println(StringHelper.implode(Arrays.asList(data), delimiter));
					results.println(data[0]);
					moduleCount += Long.parseLong(data[2]);
					classCount += Long.parseLong(data[4]);
					locCount += Long.parseLong(data[3]);
					results.flush();
				} else {
					rejected++;
					System.out.println("Rejected: " + data[0]);
					if(!parseRatioFilter(data)) {
						printRejection("Parse ratio");
					}
					if(!classCountFilter(data)) {
						printRejection("Low amount of classes");
					}
					if(!LOCFilter(data)) {
						printRejection("Low LOC");
					}
				}
			}
		}
		results.close();
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

	public static boolean filter(String[] data) {
		return parseRatioFilter(data) && classCountFilter(data) && LOCFilter(data);
	}
	
	public static boolean LOCFilter(String[] data) {
		return Integer.parseInt(data[3]) > locThreshold;
	}
	
	public static boolean parseRatioFilter(String[] data) {
		return Integer.parseInt(data[5]) >= parseRatioThreshold;
	}
	
	public static boolean classCountFilter(String[] data) {
		return Integer.parseInt(data[4]) >= classCountThreshold;
	}

}
