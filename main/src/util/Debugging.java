package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Debugging {

	private static Debugging instance;
	private PrintStream debugStream; 
	private PrintStream debugFileStream; 
	
	private Debugging() throws IOException {
		Properties config = Settings.getConfig();
		this.debugStream = System.out;
		this.debugFileStream = null;
		
		if(Boolean.parseBoolean(config.getProperty("debug"))) {			
			String path = FileHelper.stampedFileName(config.getProperty("locations.log.out"), "debug", "log");
			System.out.println("Creating debugging log file. In: " + path);

			File debugLog = new File(path);
			if (!debugLog.exists()) {
				debugLog.getParentFile().mkdirs();
				//debugLog.mkdirs();		
			}
			this.debugFileStream = new PrintStream(new FileOutputStream(path));
		} else {
			System.out.println("Not creating debugging file.");
		}
	}
	
	public static Debugging getInstance() throws IOException {
		if (instance == null) {
			instance = new Debugging();
		}
		return instance;
	}
	
	public void debug(String msg) {
		debugStream.println(msg);
		debugFile(msg);
	}
	
	public void debug(Object o) {
		debugStream.println(o);
		debugFile(o);
	}

	private void debugFile(Object o) {
		if(debugFileStream != null)
			debugFileStream.println(o);
	}
}
