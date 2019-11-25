package tests;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import model.Class;
import model.Variable;

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
	
}
