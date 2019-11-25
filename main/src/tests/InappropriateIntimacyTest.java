package tests;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import model.Class;
import util.Debugging;

public class InappropriateIntimacyTest {

	
	@Test
	public void testIntensiveCoupling() {
		Map<String, Class> classes = TestHelper.getClasses("main/src/tests/samples/intensive_coupling");
		
		Class a = classes.get("A");
		Class b = classes.get("B");
		try {
			Debugging debug = Debugging.getInstance();
			
			for (Class c : a.getReferencedClassesCount().keySet()) {
				debug.debug(c);
			}
			
			Map<String, Integer> refVals = a.getReferencedVariableCount();
			for (String key : refVals.keySet()) {
				debug.debug("Key: " + key + " val: " + refVals.get(key));
			}
			
			
			debug.debug("\nClass B:\n");
			for (Class c : b.getReferencedClassesCount().keySet()) {
				debug.debug(c);
			}
						
		
			Map<String, Integer> refVals2 = b.getReferencedVariableCount();
			for (String key : refVals2.keySet()) {
				debug.debug("Key: " + key + " val: " + refVals2.get(key));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		assert(b.getReferencedClassNames().size() == 1);
		assert(a.getReferencedClassNames().size() == 1);
		
		

	}
	
}
