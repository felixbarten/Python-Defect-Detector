package analysis.detector;

import analysis.Metric;
import analysis.storage.PrimitiveIntMap;
import model.Subroutine;
import model.Class;

import java.io.IOException;

/**
 * Detector for Refused Bequest
 * Using the metrics described in Lanza & Marinescu's Object Oriented Programming Metrics in Practice. 
 * Created by felixb on 9-4-2018
 */
public class RefusedBequestDetector extends Detector {


	private final static String OVERRIDES = "OVERRIDES";
	// aren't CLOC and class_loc the same? 
	private final static String CLOC = "CLOC";
	// Cyclomatic complexitry stored per class.
	private final static String CLASS_CC = "CLASS_CC";
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
	
	// stores the NOM (number of methods) per project. 
	private final static String GLOBAL_AVG_NOM = "GLOBAL_AVG_NOM";
	
	private DataStore global;
	
	private Class cls;

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
		global.addDataStore(PROJECT_LOC, new PrimitiveIntMap(this.getDataStoreFilePath(PROJECT_LOC)));
		global.addDataStore(PROJECT_CC,  new PrimitiveIntMap(this.getDataStoreFilePath(PROJECT_CC)));
		global.addDataStore(CLASS_LOC, new PrimitiveIntMap(this.getDataStoreFilePath(CLASS_LOC)));
		global.addDataStore(CLASS_AVG_CC, new PrimitiveIntMap(this.getDataStoreFilePath(CLASS_AVG_CC)));
	
		global.addDataStore(PROJECT_AVG_SUBROUTINE_CC, new PrimitiveIntMap(this.getDataStoreFilePath(PROJECT_AVG_SUBROUTINE_CC)));
		global.addDataStore(GLOBAL_AVG_NOM, new PrimitiveIntMap(this.getDataStoreFilePath(GLOBAL_AVG_NOM)));


	}

	@Override
	protected Boolean isPreliminarilyDefective(model.Class cls) {
		this.cls = cls;
		global.getPrimitiveMapStore(CLASS_CC).add(cls.getFullPath(), cls.getCC());
		

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
		
		//return (fewProtectedMembers(cls) && refusedBequest(cls)) || overridesMethods() ;
		return true;
	}
	
	/**
	 * BUR < A THIRD
	 * @param cls
	 * @return
	 */
	private boolean refusedBequest(Class cls) {
		// TODO Auto-generated method stub
		return true;
	}

	
	/**
	 * "Overriding methods are rare in child" 
	 * BOvR < A THIRD
	 * @return
	 */
	private boolean overridesMethods() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * NProtM > FEW
	 * @param cls
	 * @return
	 */
	private boolean fewProtectedMembers(Class cls) {
		// What is few members? 3-5?
		return cls.getPrivateParentVars().getAsSet().size() > 3;

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
		boolean sizeAboveAvg =  cls.getNOM() >= global.getPrimitiveMapStore(GLOBAL_AVG_NOM).get(cls.getProject().getPath());
		
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
		Integer globalAMW = 0;
		// Check if class actually contains methods 
		if (cls.getNOM() > 0) {
			amw = cls.getCC() / cls.getNOM();
		}

		// prevent divide by zero
		int totalNOM = global.getPrimitiveMapStore(GLOBAL_AVG_NOM).get(path);
		if (totalNOM > 0) {
			globalAMW = global.getPrimitiveMapStore(CLASS_AVG_CC).get(path) / totalNOM;
		}
		return amw >= globalAMW;
	}

	/**
	 * Calculates Weighted Method Count.
	 * WMC = CYCLOMATIC COMPLEXITY OF CLASS (including all methods) 
	 * WMC > avg
	 * @param cls
	 * @return
	 */
	private boolean clsCCAboveAvg(Class cls) {
		// get functional CC for project
		Integer avgCC = global.getPrimitiveMapStore(CLASS_AVG_CC).get(cls.getProject().getPath());

		return cls.getCC() >= avgCC;
	}
	
}
