package analysis.detector;

import java.io.IOException;
import java.util.Set;

import analysis.Metric;
import analysis.storage.PrimitiveIntMap;
import analysis.storage.SetStrMap;
import model.Subroutine;
import util.Debugging;
import util.Settings;

/**
 * Created by felixb on 9-4-2018
 */
public class InappropriateIntimacyDetector extends Detector {

	private final static String PARAMS = "PARAMS";	
	private final static String CLASS_REF_CLS_COUNT = "CLASS_REF_CLS_COUNT";
	private final static String CLASS_REF_VAR_PATHS = "CLASS_REF_VAR_PATHS";
	
	private Debugging debug;
	private DataStore global;
	
	private int couplingThreshold = 0;
	
	public InappropriateIntimacyDetector() throws IOException {
		super();
		
		debug = Debugging.getInstance();
		global = DataStore.getInstance(); 
		
		// get from settings
		try {
			this.couplingThreshold = Integer.parseInt(Settings.getConfig().getProperty("detectors.ii.couplingthreshold"));
		} catch(NumberFormatException e) {
			setDefaultThresholds();
		}
		if(couplingThreshold == 0) setDefaultThresholds();
		System.out.println("[II] Initialized Detector with threshold: " + this.couplingThreshold);
	}

	private void setDefaultThresholds() {
		this.couplingThreshold = 3;
	}

	@Override
	public void addDataStores() throws IOException {
		global = DataStore.getInstance();
		global.addDataStore(CLASS_REF_VAR_PATHS, new SetStrMap(this.getDataStoreFilePath(CLASS_REF_VAR_PATHS)));
		
	}

	@Override
	protected Boolean isPreliminarilyDefective(model.Class cls) {		
		boolean condition = hasImports(cls);
		debug.debug("[II] Class: " + cls.getShortName() + " is preliminary defective: " + condition);
		/*	normally testing whether a class has a referenced class would be enough. In my time testing this it has not worked well.... 
			So instead of flagging every class true I've decided to see if there are imports present. */
		return condition; 
	}

	private Boolean hasImports(model.Class cls) {
		model.Module module = cls.getParent();
		if (module != null && module instanceof model.Module) {
			return module.getClassImports().size() > 0 || module.getModuleImports().size() > 0;
		}
		return false;
	}

	@Override
	protected Boolean confirmDefect(String fullPath, String projectPath) {
		// check referenced classes. 
		// check if any of ref. classes has coupling with this class. 
		// check if the amount of coupling is more or equal to the threshold.
		Set<String> paths = global.getStrSetMap(CLASS_REF_VAR_PATHS).get(fullPath);
		
		
		return false;
	}

	@Override
	protected String getName() {
		return "Inappropriate Intimacy";
	}
}
