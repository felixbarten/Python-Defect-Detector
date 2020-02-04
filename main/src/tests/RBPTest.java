package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

import analysis.Register;
import analysis.detector.InappropriateIntimacyDetector;
import analysis.detector.RefusedBequestDetector;
import main.CsvCreator;
import model.Class;
import model.Project;
import model.Variable;
import util.Settings;

public class RBPTest {
	
	@Test 
	public void protectedMemberTest() {
		Map<String, Class> classes = TestHelper.getClasses("main/src/tests/samples/parents");

		Class parent = classes.get("BaseCls");
		Class cls = classes.get("SubCls");
		Class subCls2 = classes.get("SubCls2");
		Class subCls3 = classes.get("SubCls3");

		Set<Variable> vd = parent.getProtectedVars().getAsSet();
		displayVars(vd, parent.getName());
		displayVars(cls.getProtectedVars().getAsSet(), cls.getName());
		System.out.println(subCls3.getSuperclassNames());
		
		
		for(Class par : subCls2.getParentsSet()) {
			String path = par.getFullPath();
			System.out.println(path);
		}
		
		
		for(Class par : subCls3.getParentsSet()) {
			String path = par.getFullPath();
			System.out.println(path);
		}
		
		
		// double scoping increases the protected member count too much
		assert(vd.size() == 6);
		assert(cls.getProtectedVars().getAsSet().size() == 2);
	}
	
	private void displayVars(Set<Variable> vd, String name) {
		System.out.println("Variables for class name: " + name);
		for(Variable v : vd) {
			System.out.println("Prot var: " + v.getName() + " " + v.getVarType().toString());
		}
	}
	
	/**
	 * Disclaimer: This method will run like a regular project which has caveats. 
	 * Unless your data folder in \temp contains data for these files it will not find defects. 
	 * 
	 * If you would like your data files not to affect testing data create another config file and run with different launch parameters.
	 */
	@Test
	public void testRPBProject() {
		Project testProject = TestHelper.getProject("main/src/tests/samples/parents");		
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
			
		} catch (FileNotFoundException fof) {
			fof.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
}
