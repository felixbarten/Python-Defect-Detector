package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

import analysis.Register;
import analysis.detector.InappropriateIntimacyDetector;
import analysis.detector.RefusedBequestDetector;
import main.CsvCreator;
import model.Class;
import model.Project;
import util.DebuggingLogger;
import util.Settings;

public class InappropriateIntimacyTest {

	
	@Test
	public void testIntensiveCoupling() {
		Map<String, Class> classes = TestHelper.getClasses("main/src/tests/samples/intensive_coupling");
		
		Class a = classes.get("A");
		Class b = classes.get("B");
		try {
			DebuggingLogger debug = DebuggingLogger.getInstance();
			
			for (Class c : a.getReferencedClassesCount().keySet()) {
				debug.debug(c);
			}
			
			Map<String, Integer> refVals = a.getReferencedVariableCount();
			for (String key : refVals.keySet()) {
				debug.debug("[A1] Key: " + key + " val: " + refVals.get(key));
			}
			
			
			debug.debug("\nClass B:\n");
			for (Class c : b.getReferencedClassesCount().keySet()) {
				debug.debug(c);
			}
						
		
			Map<String, Integer> refVals2 = b.getReferencedVariableCount();
			for (String key : refVals2.keySet()) {
				debug.debug("[B2] Key: " + key + " val: " + refVals2.get(key));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		assert(b.getReferencedClassNames().size() == 1);
		assert(a.getReferencedClassNames().size() == 1);
		
		

	}

	@Test
	public void testIntensiveCouplingTwo() {
		Project testProject = TestHelper.getProject("main/src/tests/samples/intensive_coupling_two");

		Map<String, Class> classes = TestHelper.getClasses(testProject);
		
		Class clsA = classes.get("A");
		Class clsB = classes.get("B");
		Class clsC = classes.get("C");
		Class clsD = classes.get("D");
		
		try {
			DebuggingLogger debug = DebuggingLogger.getInstance();
			
			for (Class c : clsA.getReferencedClassesCount().keySet()) {
				debug.debug(c);
			}
			
			Map<String, Integer> refVals = clsA.getReferencedVariableCount();
			for (String key : refVals.keySet()) {
				debug.debug("[A] Key: " + key + " val: " + refVals.get(key));
			}
			
			
			debug.debug("\nClass B references:\n");
			for (Class c : clsB.getReferencedClassesCount().keySet()) {
				debug.debug(c);
			}
						
		
			Map<String, Integer> refVals2 = clsB.getReferencedVariableCount();
			for (String key : refVals2.keySet()) {
				debug.debug("[B] Key: " + key + " val: " + refVals2.get(key));
			}
			//
			
			for (Class c : clsC.getReferencedClassesCount().keySet()) {
				debug.debug(c);
			}
			
			Map<String, Integer> refVals3 = clsC.getReferencedVariableCount();
			for (String key : refVals3.keySet()) {
				debug.debug("[C] Key: " + key + " val: " + refVals3.get(key));
			}
			
			
			debug.debug("\nClass C references:\n");
			for (Class c : clsC.getReferencedClassesCount().keySet()) {
				debug.debug(c);
			}
						
		
			Map<String, Integer> refVals4 = clsD.getReferencedVariableCount();
			for (String key : refVals4.keySet()) {
				debug.debug("[D] Key: " + key + " val: " + refVals4.get(key));
			}
			
			debug.debug("\nClass D references:\n");
			for (Class c : clsC.getReferencedClassesCount().keySet()) {
				debug.debug(c);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		assert(clsB.getReferencedClassNames().size() == 1);
		assert(clsA.getReferencedClassNames().size() == 1);
		assert(clsC.getReferencedClassNames().size() == 1);
		assert(clsD.getReferencedClassNames().size() == 2);

		

	}
	
	/**
	 * Disclaimer: This method will run like a regular project which has caveats. Unless your data folder in \temp contains data for these files it will not find defects. 
	 * 
	 */
	@Test
	public void testIntensiveCouplingProject() {
		Project testProject = TestHelper.getProject("main/src/tests/samples/intensive_coupling_two");
	
		Map<String, Class> classes = TestHelper.getClasses(testProject);
		
		try {
			// fetch default config. 
			Properties config = Settings.getConfig();			
			Register register = new Register();
			register.add(new RefusedBequestDetector());
			register.add(new InappropriateIntimacyDetector());

			register.check(testProject, false);
			
			
			CsvCreator csvCreator = new CsvCreator(config.getProperty("locations.data.results"));
			csvCreator.createStream("RESULTS", "Project", "Url", "Location", "Defect");
			register.finish(null, csvCreator);
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
