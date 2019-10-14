package analysis.detector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import analysis.storage.PrimitiveFloatMap;
import analysis.storage.PrimitiveIntMap;
import model.Class;
import util.Settings;
import util.Debugging;

/**
 * Detector for Refused Bequest
 * Using the metrics described in Lanza & Marinescu's Object Oriented Programming Metrics in Practice. 
 * Created by felixb on 9-4-2018
 */
public class RefusedBequestDetector extends Detector {


	private final static String OVERRIDES = "OVERRIDES";
	// aren't CLOC and class_loc the same? 
	private final static String CLOC = "CLOC";
	// Cyclomatic complexity stored per class.
	private final static String CLASS_WMC = "CLASS_WMC";
	private final static String CLASS_AMW = "CLASS_AMW";
	// loc per class
	private final static String CLASS_LOC = "CLASS_LOC";
	
	// total loc stored per project
	private final static String PROJECT_LOC = "PROJECT_LOC";
	// total cyclomatic complexity for project.
	private final static String PROJECT_CC = "PROJECT_CC";
	
	// average class LOC stored per project
	// TODO are these two redundant if you have number of classes in project and total LOC you can derive these values?
	private final static String CLASS_AVG_LOC = "CLASS_AVG_LOC";
	// average class cyclomatic complexity (stored per project?)
	private final static String CLASS_AVG_CC  = "CLASS_AVG_CC";
	
	
	private final static String PROJECT_AVG_SUBROUTINE_CC = "PROJECT_AVG_SUBROUTINE_CC"; // average cyclomatic per subroutine in project
	private final static String PROJECT_AVG_AMW = "PROJECT_AVG_AMW";
	private final static String PROJECT_AVG_LOC = "PROJECT_AVG_LOC";
	private final static String SUBROUTINE_AVG_CC = "SUBROUTINE_AVG_CC";
	// stores the NOM (number of methods) per project. 
	private final static String GLOBAL_AVG_NOM = "GLOBAL_AVG_NOM";
	
	private final static String PARENT_PROTECTED_MEMBERS = "PARENT_PROTECTED_MEMBERS";
	private static final String CLASS_PARENTS = "CLASS_PARENTS";
	private static final String CLASS_REF_VAR_COUNT = "CLASS_REF_VAR_COUNT";
	private static final String CLASS_REF_CLS_COUNT = "CLASS_REF_CLS_COUNT";
	
	private static final String CLASS_REF_METHODS = "CLASS_DEF_METHODS";	
	private static final String CLASS_DEF_METHODS = "CLASS_DEF_METHODS";	

	
	
	private Debugging debug;
	
	private int memberThreshold = 0;
	private int overrideThreshold = 0;

	public RefusedBequestDetector() throws IOException {
		super();
		this.debug = Debugging.getInstance();
		// get from settings
		try {
			this.overrideThreshold = Integer.parseInt(Settings.getConfig().getProperty("detectors.rb.overridethreshold"));
			this.memberThreshold = Integer.parseInt(Settings.getConfig().getProperty("detectors.rb.memberthreshold"));
		} catch(NumberFormatException e) {
			setDefaultThresholds();
		}
		if(memberThreshold == 0 || overrideThreshold == 0) setDefaultThresholds();
		System.out.println("[RB] Initialized Detector with thresholds: " + this.memberThreshold + " and " + this.overrideThreshold);
	}

	@Override
	public void addDataStores() throws IOException {
		//prevents initialization issues
			
		this.addDataStore(CLOC, new PrimitiveIntMap(this.getDataStoreFilePath(CLOC)));
		this.addDataStore(OVERRIDES, new PrimitiveIntMap(this.getDataStoreFilePath(OVERRIDES)));
		this.addDataStore(CLASS_WMC, new PrimitiveIntMap(this.getDataStoreFilePath(CLASS_WMC)));
		this.addDataStore(CLASS_AMW, new PrimitiveFloatMap(this.getDataStoreFilePath(CLASS_AMW)));
		this.addDataStore(PROJECT_LOC, new PrimitiveIntMap(this.getDataStoreFilePath(PROJECT_LOC)));
		this.addDataStore(PROJECT_CC,  new PrimitiveIntMap(this.getDataStoreFilePath(PROJECT_CC)));
		this.addDataStore(CLASS_LOC, new PrimitiveIntMap(this.getDataStoreFilePath(CLASS_LOC)));
		this.addDataStore(CLASS_AVG_CC, new PrimitiveIntMap(this.getDataStoreFilePath(CLASS_AVG_CC)));
		this.addDataStore(PROJECT_AVG_LOC, new PrimitiveIntMap(this.getDataStoreFilePath(PROJECT_AVG_LOC)));
		this.addDataStore(SUBROUTINE_AVG_CC, new PrimitiveIntMap(this.getDataStoreFilePath(SUBROUTINE_AVG_CC)));
		
		
		this.addDataStore(PROJECT_AVG_AMW, new PrimitiveFloatMap(this.getDataStoreFilePath(PROJECT_AVG_AMW)));
		this.addDataStore(PROJECT_AVG_SUBROUTINE_CC, new PrimitiveIntMap(this.getDataStoreFilePath(PROJECT_AVG_SUBROUTINE_CC)));
		this.addDataStore(GLOBAL_AVG_NOM, new PrimitiveIntMap(this.getDataStoreFilePath(GLOBAL_AVG_NOM)));
		

	}

	@Override
	protected Boolean isPreliminarilyDefective(Class cls) {
		Set<Class> parents = cls.getParentsSet();
		
		// why is this here
		//this.getPrimitiveMapStore(CLASS_CC).add(cls.getFullPath(), cls.getCC());
		
		// try to satisfy precondition of parent class must be direct ancestor and not some library. 
		// libraries don't get added to the superclass set so precondition is met as the classes can't be iterated if they're not in the Set. 		
		
		boolean hasParent = hasParent(cls);
		
		
		// debug
		boolean fewProtected = fewProtectedMembers(cls.getFullPath());
		// why does this print but not the others. 
		if(hasParent && fewProtected) {
			debug.debug(cls.getShortName() + " is preliminary defective");
		}
		return hasParent; 
		//return hasParent(cls) && fewProtectedMembers(cls);
	}

	@Override
	protected Boolean confirmDefect(String fullPath) {
		System.out.println(fullPath);
		
		// debugging 
		boolean bequest = cls_ignores_bequest(fullPath);
		boolean complex = clsComplex(fullPath);
		
		
		return complex && bequest;
	}

	@Override
	protected String getName() {
		return "Refused (Parent) Bequest";
	}
	
	private boolean cls_ignores_bequest(String path) {
		boolean prot = fewProtectedMembers(path);
		boolean refused = refusedBequest(path);
		boolean overrides = overridesMethods(path);
		
	//	debug.debug(cls.getParentsSet());
		debug.debug("prot: " + prot + " refused: " + refused + " overrides: " + overrides);
		//return (fewProtectedMembers(cls) && refusedBequest(cls)) || overridesMethods() ;
		return (prot && refused) || overrides;
	}
	
	
	/**
	 * NProtM > FEW
	 * @param cls
	 * @return
	 */
	private boolean fewProtectedMembers(String path) {
		// this one is weird in Python as a class can have more than one parent. so the threshold may need to be higher than in Java. 
		//Integer memberCount = cls.getProtectedParentVars().getAsSet().size();
		Integer parentMember = this.getPrimitiveMapStore(PARENT_PROTECTED_MEMBERS).get(path);
		boolean condition = parentMember > memberThreshold;
		
		return condition;
	}

	
	/**
	 * BUR < A THIRD
	 * @param cls
	 * @return
	 */
	private boolean refusedBequest(String path) {
		System.out.println("Detecting RB"); 
		// roadblock. Needs additional information from the AST about method calls. which is not currently available. 
		// collect call data 
		// check if parent data is called. 
		int parentMembers = 0;
		int usage = 0; 
		
	/*&Map<Class, Integer> classRefs = cls.getReferencedClassesCount();
	/Map<String, Integer> varRefs = cls.getReferencedVariableCount();
		
		//Set<Class> parents = cls.getParentsSet();
		// if parents don't exist why did we even come here because the precond should have failed. 
		if(parents.size() > 0 ) 
			debug.debug("We have " + parents.size() + " parents");
				
		for (Class c : parents) { 
			classRefs.computeIfPresent(c, (k,v) -> parentMembers + v);
		}
		debug.debug("clsRefs: " + classRefs);

		debug.debug("Parent members: " + parentMembers);
		
		debug.debug("varRefs: " + varRefs);
		
		for (String s : varRefs.keySet()) { 
			varRefs.computeIfPresent(s, (k,v) -> parentMembers + v);
		}
		*/
		
		Integer classRefs = this.getPrimitiveMapStore(CLASS_REF_CLS_COUNT).get(path);
		Integer varRefs = this.getPrimitiveMapStore(CLASS_REF_VAR_COUNT).get(path);
		Integer parents = this.getPrimitiveMapStore(CLASS_PARENTS).get(path);
		
		
		debug.debug("Parent members: " + parentMembers);
		
		return false;
	}

	
	/**
	 * "Overriding methods are rare in child" 
	 * This implementation checks all parent classes for methods, adds them to a set of method names and then compares the methods in the parent with the methods in the child.
	 * If the sets intersect there are overrides present in the child class. 
	 * BOvR < A THIRD
	 * 
	 * In Python an override is assumed if the deriving class has a method of the same name. 
	 * Therefore if we compare the set of subroutines in the parent with the set of subroutines in the child an intersection would show the overrides. 
	 * @return boolean whether it has more or fewer overriding methods than the threshold. 
	 */
	private boolean overridesMethods(String path) {	
		// get parents 
		
		//foreach parent lookup set of subroutine names 
		// add all to a set
		// compare set to current class set of subroutines. 
		
		Set<String> parentSubRoutines = new HashSet<>();
		Set<String> superClasses = this.getPrimitiveStringMapStore(CLASS_PARENTS).get(path);
		
		for(String parent : superClasses) {
			Set<String> subroutines = this.getPrimitiveStringMapStore(CLASS_DEF_METHODS).get(parent);
			parentSubRoutines.addAll(subroutines);
		}
		
		debug.debug(parentSubRoutines);
		Set<String> intersection = new HashSet<String>(this.getPrimitiveStringMapStore(CLASS_DEF_METHODS).get(path));
		//debug
		debug.debug("Intersection is: " + intersection);
		intersection.retainAll(parentSubRoutines);
		
		return intersection.size() > overrideThreshold;
	}

	/**
	 * Calculates if the class is not small and not simple.
	 * (AMW > avg) || (WMC > avg) && (NOM > avg)
	 * @param cls
	 * @return
	 */
	private boolean clsComplex(String path) {
		boolean funcComplexityAvgAvg = funcComplexityAboveAvg(path);
		boolean clsCCAboveAvg = clsCCAboveAvg(path);
		boolean clsSizeAbvAvg = clsSizeAboveAvg(path);

		
		return (funcComplexityAvgAvg || clsCCAboveAvg ) && clsSizeAbvAvg;
		//return (funcComplexityAboveAvg(cls) || clsCCAboveAvg(cls)) && clsSizeAboveAvg(cls);
	}
	
	/**
	 * Number of Methods > more than average (of the classes in the project).
	 * @param cls
	 * @return
	 */
	private boolean clsSizeAboveAvg(String path) {
		boolean sizeAboveAvg =  cls.getLoc() >= this.getPrimitiveMapStore(PROJECT_AVG_LOC).get(cls.getProject().getPath());
		debug.debug(cls.getName() + " Above avg");
		return sizeAboveAvg;
	}

	/**
	 * Calculates the Average Method Weight
	 * AMW > avg
	 * WMC / NOM = AMW 
	 * @param cls
	 * @return
	 */
	private boolean funcComplexityAboveAvg(String path) {
		// get functional CC for project
		String path = cls.getProject().getPath();
		Integer amw = 0;
		// Check if class contains methods 
		if (cls.getNOM() > 0) {
			amw = cls.getCC() / cls.getNOM();
		}
		
		return amw > this.getPrimitiveFloatMapStore(PROJECT_AVG_AMW).get(path);
	}


	/**
	 * Calculates Weighted Method Count.
	 * WMC = CYCLOMATIC COMPLEXITY OF CLASS (including all methods) 
	 * WMC > avg
	 * @param cls
	 * @return true if class is more complex than average
	 */
	private boolean clsCCAboveAvg(String path) {
		// get functional CC for project
		//Integer avgWMC = this.getPrimitiveMapStore(CLASS_AVG_CC).get(cls.getProject().getPath());
		Integer avgWMC = this.getPrimitiveMapStore(CLASS_AVG_CC).get(cls.getProject().getPath());
		debug.debug(cls.getShortName() + " has CC above avg: " + cls.getWMC() + " > " + avgWMC);
		return cls.getWMC() > avgWMC;
	}
	
	/**
	 * precondition. Class must have a parent.
	 * @return
	 */
	private boolean hasParent(Class cls) {
		Map<String, Class> supers = cls.getSuperclasses();
		List<String> supernames = cls.getSuperclassNames();
		if(supers.size() > 0) {
			debug.debug(cls.getShortName() + " has parents:");
			for(Class c : supers.values()) {
				debug.debug("\t" + c.getShortName());
			}
		}
		if(supernames.size() > 0 && supers.size() == 0) 
			debug.debug(cls.getShortName() + " has parents but can't be resolved:" + supernames);
		// default has object as super. 
		return cls.getSuperclassNames().size() > 0;
	}
	
	private void setDefaultThresholds() {
		// set to default values if they can't be fetched from settings 
		this.overrideThreshold = 3;
		this.memberThreshold = 3; 
	}
	
}
