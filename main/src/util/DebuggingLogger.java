package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import analysis.detector.InappropriateIntimacyDetector.IIMatch;
import model.Subroutine;
import model.VarDefinitions;
import model.Variable;

public class DebuggingLogger {

	private static DebuggingLogger instance;
	private PrintStream debugStream; 
	private PrintWriter debugFileStream; 
	private String IIPath;
	
	
	private DebuggingLogger() throws IOException {
		Properties config = Settings.getConfig();
		this.debugStream = System.out;
		this.debugFileStream = null;
		
		if(Boolean.parseBoolean(config.getProperty("debugging.enabled"))) {			
			String path = FileHelper.stampedFileName(config.getProperty("locations.log.out"), "debug", "log");
			System.out.println("Creating debugging log file. In: " + path);

			File debugLog = new File(path);
			if (!debugLog.exists()) {
				debugLog.getParentFile().mkdirs();
			}
			// create stream with autoflush.
			this.debugFileStream = new PrintWriter(new FileOutputStream(path), true);
			
		} else {
			System.out.println("Not creating debugging file.");
		}
	}
	
	public static DebuggingLogger getInstance() throws IOException {
		if (instance == null) {
			instance = new DebuggingLogger();
		}
		return instance;
	}
	
	public void debug(String msg) {
		debugStream.println(msg);
		debugFile(msg);
	}
	
	public void debug(Object o) {
		debugStream.println(o.toString());
		debugFile(o.toString());
	}
	
	public void debug(IIMatch m) {
		String path1 = m.getPath1();
		String path2 = m.getPath2();
		try {
			String cls1 = path1.split(">")[1];
			String cls2 = path2.split(">")[1];
			
			debugStream.println("[II] II Found between class: " + cls1 + " " + cls2);
		} catch (IndexOutOfBoundsException e) {
			debugStream.println("[II] II found between: " + path1 + " " + path2);
		}
	}
		
	public void debug(Exception e) {
		e.printStackTrace(debugStream);
	}

	public void debug(Set<String> set) {
		debugStream.println("\nSet:");
		for(String s : set) {
			debugStream.println("\t" + s);
		}
	}
	
	private void debugFile(Object o) {
		if(debugFileStream != null)
			debugFileStream.println(o);
	}
	
	public void debugIISet(Set<String> unknownTypeVars, String clsName) throws IOException {
		if(this.IIPath == null) {
			Properties config = Settings.getConfig();
			this.IIPath =  FileHelper.stampedFileName(config.getProperty("locations.log.out"), "debugII", "log");
		}
		PrintStream IIDebugFileStream = new PrintStream(new FileOutputStream(IIPath, true));
		
		IIDebugFileStream.println("\nUnidentified II vars for: " + clsName);
		for(String s : unknownTypeVars) {
			IIDebugFileStream.append("\t" + s);
		}
		IIDebugFileStream.append("\n\n");
		
		IIDebugFileStream.flush();
		IIDebugFileStream.close();
	
	}
}
