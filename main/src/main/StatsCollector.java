package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Properties;

import util.FileHelper;
import util.Settings;

/**
 * Created by Nik on 08-10-2015
 */
public class StatsCollector {

	/**
	 * Aggregates stats from projects
	 * @param args
	 * @throws IOException
	 */
	//args[0] = the location of the projects
	//args[1] = the CSV file which contains project disk location, github link
	public static void main(String[] args) throws IOException {
		Properties config = null;
		if (args[0] != null) {
			config = Settings.getConfig(args[0]);
		} else {
			config = Settings.getConfig();
		}
		
		PrintStream out = new PrintStream(new FileOutputStream(FileHelper.stampedFileName(config.getProperty("locations.log.out"), "out", "log")));
		PrintStream err = new PrintStream(new FileOutputStream(FileHelper.stampedFileName(config.getProperty("locations.log.error"), "err", "log")));
		//System.setOut(out);
		System.setErr(err);

		File sourceFolder = new File(config.getProperty("locations.data.input"));
		List<File> subfolders = FileHelper.getSubfolders(sourceFolder);
		StatsCsvCreator statsCsvCreator = new StatsCsvCreator(subfolders, config);
		statsCsvCreator.createStatsCsv();
		statsCsvCreator.close();
	}

	private static void handleException(Exception ex) {
		System.err.println("EXCEPTION: " + ex.getMessage());
		ex.printStackTrace();
	}
}
