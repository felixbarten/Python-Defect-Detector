package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import model.Subroutine;
import model.VarDefinitions;
import model.Variable;

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
	
	public void debug(model.Class c) {
		
		debugStream.println("\nClass: " + c.getShortName());
		debugStream.println("CC: " + c.getCC());
		debugStream.println("LOC: " + c.getLoc());
		debugStream.println("Superclasses: " + c.getSuperclassNames());
		debugStream.println("Super classes added: " + printChildren(c.getSuperclasses()));
		debugStream.println("Variables: " + c.getVariableNames());
		debugStream.println("Methods: " + printChildren(c.getDefinedSubroutinesSet()));
		debugStream.println("Inherited vars: " + c.getInheritedVarNames());
		debugStream.println("protected parent vars: " + c.getProtectedParentVars().getNames());
		debugStream.println("private parent vars: " + c.getPrivateParentVars().getNames());
		debugStream.println("referenced class names: " + c.getReferencedClassNames());
		debugStream.println("referenced var names: " + c.getReferencedVariableNames());
		debugStream.println("\n");
		debugFile(c);
	}

	private void debugFile(Object o) {
		if(debugFileStream != null)
			debugFileStream.println(o);
	}
	
	private void debugFile(model.Class c) {
		if(debugFileStream == null)
			return;
		debugFileStream.println("\nClass filepath: " + c.getFullPath());
		debugFileStream.println("Class: " + c.getShortName());
		debugFileStream.println("CC: " + c.getCC());
		debugFileStream.println("LOC: " + c.getLoc());
		debugFileStream.println("Superclasses: " + c.getSuperclassNames());
		debugFileStream.println("Super classes added: " + printChildren(c.getSuperclasses()));
		debugFileStream.println("Variables: " + c.getVariableNames());
		debugFileStream.println("Methods: " + printChildren(c.getDefinedSubroutinesSet()));
		debugFileStream.println("Inherited vars: " + c.getInheritedVarNames());
		debugFileStream.println("protected parent vars: " + c.getProtectedParentVars().getNames());
		debugFileStream.println("private parent vars: " + c.getPrivateParentVars().getNames());
		debugFileStream.println("referenced class names: " + c.getReferencedClassNames());
		debugFileStream.println("referenced var names: " + c.getReferencedVariableNames());
		debugFileStream.println("\n");
	}
	
	private String printChildren(Map<String, model.Class> classes) { 
		String message = "[";
		for (model.Class c : classes.values()) {
			message += c.getShortName() + ", ";
		}
		message += "]";
		return message;
	}
	private String printChildren(VarDefinitions vd) {
		String message = "[";
		for (Variable v : vd.getAsSet()) {
			message += v.getName() + ", ";
		}
		message += "]";
		return message;	}
	
	private String printChildren(Set<Subroutine> subs) {
		String message = "[";
		for (Subroutine sr : subs) {
			message += sr.getName() + ", ";
		}
		message += "]";
		return message;	
		}
}
