package analysis.detector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import analysis.storage.PrimitiveFloatMap;
import analysis.storage.PrimitiveIntMap;
import model.Class;

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
	private final static String CLASS_CC = "CLASS_CC";
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
	
	
	private final static String GLOBAL_CC_AVG = "GLOBAL_CC_AVG";
	private final static String PROJECT_AVG_SUBROUTINE_CC = "PROJECT_AVG_SUBROUTINE_CC"; // average cyclomatic per subroutine in project
	private final static String PROJECT_AVG_AMW = "PROJECT_AVG_AMW";
	private final static String PROJECT_AVG_LOC = "PROJECT_AVG_LOC";

	// stores the NOM (number of methods) per project. 
	private final static String GLOBAL_AVG_NOM = "GLOBAL_AVG_NOM";
	
	private DataStore global;
	
	private Class cls;
	private Set<Class> parents;
	private int memberThreshold;
	private int overrideThreshold;

	public RefusedBequestDetector() throws IOException {
		super();
		this.global = DataStore.getInstance();
	}

	@Override
	public void addDataStores() throws IOException {
		//prevents initialization issues
		this.global = DataStore.getInstance();
			
		global.addDataStore(GLOBAL_CC_AVG, new PrimitiveIntMap(this.getDataStoreFilePath(GLOBAL_CC_AVG)));
		global.addDataStore(CLOC, new PrimitiveIntMap(this.getDataStoreFilePath(CLOC)));
		global.addDataStore(OVERRIDES, new PrimitiveIntMap(this.getDataStoreFilePath(OVERRIDES)));
		global.addDataStore(CLASS_CC, new PrimitiveIntMap(this.getDataStoreFilePath(CLASS_CC)));
		global.addDataStore(CLASS_WMC, new PrimitiveIntMap(this.getDataStoreFilePath(CLASS_WMC)));
		global.addDataStore(CLASS_AMW, new PrimitiveFloatMap(this.getDataStoreFilePath(CLASS_AMW)));
		global.addDataStore(PROJECT_LOC, new PrimitiveIntMap(this.getDataStoreFilePath(PROJECT_LOC)));
		global.addDataStore(PROJECT_CC,  new PrimitiveIntMap(this.getDataStoreFilePath(PROJECT_CC)));
		global.addDataStore(CLASS_LOC, new PrimitiveIntMap(this.getDataStoreFilePath(CLASS_LOC)));
		global.addDataStore(CLASS_AVG_CC, new PrimitiveIntMap(this.getDataStoreFilePath(CLASS_AVG_CC)));
		global.addDataStore(PROJECT_AVG_LOC, new PrimitiveIntMap(this.getDataStoreFilePath(PROJECT_AVG_LOC)));

		global.addDataStore(PROJECT_AVG_AMW, new PrimitiveFloatMap(this.getDataStoreFilePath(PROJECT_AVG_AMW)));
		global.addDataStore(PROJECT_AVG_SUBROUTINE_CC, new PrimitiveIntMap(this.getDataStoreFilePath(PROJECT_AVG_SUBROUTINE_CC)));
		global.addDataStore(GLOBAL_AVG_NOM, new PrimitiveIntMap(this.getDataStoreFilePath(GLOBAL_AVG_NOM)));


	}

	@Override
	protected Boolean isPreliminarilyDefective(model.Class cls) {
		this.cls = cls;
		this.parents = cls.getParentsSet();
		// get from settings later
		this.overrideThreshold = 3;
		this.memberThreshold = 3;
		
		global.getPrimitiveMapStore(CLASS_CC).add(cls.getFullPath(), cls.getCC());
		// try to satisfy precondition of parent class must be direct ancestor and not some library. 
		// libraries don't get added to the superclass set so precondition is met as the cclasses can't be iterated if they're not in the Set. 		

		return fewProtectedMembers(cls);
	}

	@Override
	protected Boolean confirmDefect(String fullPath) {
		
		return (cls_ignores_bequest(cls) && clsComplex(cls));
	}

	@Override
	protected String getName() {
		return "Refused (Parent) Bequest";
	}
	
	private boolean cls_ignores_bequest(Class cls) {
		
		boolean suspicious = true;
		
		return (fewProtectedMembers(cls) && refusedBequest(cls)) || overridesMethods() ;
	}
	
	
	/**
	 * NProtM > FEW
	 * @param cls
	 * @return
	 */
	private boolean fewProtectedMembers(Class cls) {
		// this one is weird in Python as a class can have more than one parent. so the threshold may need to be higher than in Java. 
		
		return cls.getProtectedParentVars().getAsSet().size() > memberThreshold;
	}

	
	/**
	 * BUR < A THIRD
	 * @param cls
	 * @return
	 */
	private boolean refusedBequest(Class cls) {
		System.out.println("Detecting RB"); 
		// roadblock. Needs additional information from the AST about method calls. which is not currently available. 
		
		
		// TODO Auto-generated method stub
		return true;
	}

	
	/**
	 * "Overriding methods are rare in child" 
	 * This implementation checks all parent classes for methods, adds them to a set of method names and then compares the methods in the parent with the methods in the child.
	 * If the sets intersect there are overrides present in the child class. 
	 * BOvR < A THIRD
	 * @return
	 */
	private boolean overridesMethods() {		
		Set<String> parentSubNames = new HashSet<String>();
		for(Class parent : cls.getParentsSet()) {
			parentSubNames.addAll(parent.getSubroutineNames());
		}
		Set<String> intersection = new HashSet<String>(cls.getSubroutineNames());
		intersection.retainAll(parentSubNames);
		
		return intersection.size() > overrideThreshold;
	}


	/**
	 * Calculates if the class is not small and not simple.
	 * (AMW > avg) || (WMC > avg) && (NOM > avg)
	 * @param cls
	 * @return
	 */
	private boolean clsComplex(Class cls) {
		return (funcComplexityAboveAvg(cls) || clsCCAboveAvg(cls)) && clsSizeAboveAvg(cls);
	}
	
	/**
	 * Number of Methods > more than average (of the classes in the project).
	 * @param cls
	 * @return
	 */
	private boolean clsSizeAboveAvg(Class cls) {
		boolean sizeAboveAvg =  cls.getLoc() >= global.getPrimitiveMapStore(PROJECT_AVG_LOC).get(cls.getProject().getPath());
		System.out.println("Above avg");
		return sizeAboveAvg;
	}

	/**
	 * Calculates the Average Method Weight
	 * AMW > avg
	 * WMC / NOM = AMW 
	 * @param cls
	 * @return
	 */
	private boolean funcComplexityAboveAvg(Class cls) {
		// get functional CC for project
		String path = cls.getProject().getPath();
		Integer amw = 0;
		// Check if class actually contains methods 
		if (cls.getNOM() > 0) {
			amw = cls.getCC() / cls.getNOM();
		}
		
		return amw > global.getPrimitiveMapStore(PROJECT_AVG_AMW).get(path);
	}

	/**
	 * Calculates Weighted Method Count.
	 * WMC = CYCLOMATIC COMPLEXITY OF CLASS (including all methods) 
	 * WMC > avg
	 * @param cls
	 * @return true if class is more complex than average
	 */
	private boolean clsCCAboveAvg(Class cls) {
		// get functional CC for project
		Integer avgWMC = global.getPrimitiveMapStore(CLASS_AVG_CC).get(cls.getProject().getPath());

		return cls.getWMC() > avgWMC;
	}
	
}
