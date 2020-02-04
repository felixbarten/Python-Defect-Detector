package analysis.detector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import analysis.Metric;
import analysis.storage.PrimitiveIntMap;
import analysis.storage.SetStrMap;
import model.Subroutine;
import util.DebuggingLogger;
import util.Settings;
import util.StringHelper;

/**
 * Inappropriate Intimacy Detector using Fowler's Code Smell definition.
 * Created by felixb on 9-4-2018
 */
public class InappropriateIntimacyDetector extends Detector {

	private final static String PARAMS = "PARAMS";
	private final static String CLASS_REF_CLS_COUNT = "CLASS_REF_CLS_COUNT";
	private final static String CLASS_REF_VAR_PATHS = "CLASS_REF_VAR_PATHS";
	private final static String CLASS_COUPLING = "CLASS_COUPLING";

	private DebuggingLogger debug;
	private DataStore global;

	private int couplingThreshold = 0;

	public InappropriateIntimacyDetector() throws IOException {
		super();

		debug = DebuggingLogger.getInstance();
		global = DataStore.getInstance();

		// get from settings
		try {
			this.couplingThreshold = Integer
					.parseInt(Settings.getConfig().getProperty("detectors.ii.couplingthreshold"));
		} catch (NumberFormatException e) {
			setDefaultThresholds();
		}

		if (couplingThreshold == 0) {
			setDefaultThresholds();
		}
		System.out.println("[II] Initialized Detector with threshold: " + this.couplingThreshold);
	}

	private void setDefaultThresholds() {
		this.couplingThreshold = 3;
	}

	@Override
	public void addDataStores() throws IOException {
		global = DataStore.getInstance();
		global.addDataStore(CLASS_REF_VAR_PATHS, new SetStrMap(this.getDataStoreFilePath(CLASS_REF_VAR_PATHS)));
		global.addDataStore(CLASS_COUPLING, new SetStrMap(this.getDataStoreFilePath(CLASS_COUPLING)));
	}

	@Override
	protected Boolean isPreliminarilyDefective(model.Class cls) {
		boolean preliminarilyDefective = hasImports(cls);
		if(preliminarilyDefective) {
			debug.debug("[II] Class: " + cls.getShortName() + " is preliminary defective: " + preliminarilyDefective);
		}
		/*
		 * normally testing whether a class has a referenced class would be enough. In
		 * my time testing this it has not worked well.... So instead of flagging every
		 * class true I've decided to see if there are imports present.
		 */
		return preliminarilyDefective;
	}

	private Boolean hasImports(model.Class cls) {
		model.Module module = cls.getParent();
		if (module != null && module instanceof model.Module) {
			return module.getClassImports().size() > 0 || module.getModuleImports().size() > 0;
			//return module.getClassImports().size() > 0 || module.getModuleImports().size() > 0 || module.getLibraryImports().size() > 0;
		}
		return false;
	}

	@Override
	protected Boolean confirmDefect(String fullPath, String projectPath) {
		// check referenced classes.
		// check if any of ref. classes has coupling with this class.
		// check if the amount of coupling is more or equal to the threshold.
		List<IIMatch> matches = new ArrayList<IIMatch>();
		List<IIMatch> positiveMatches = new ArrayList<IIMatch>();

		Map<String, Long> coupledClasses = getCouplingMap(fullPath);

		// This might be time intensive.
		for (String path : coupledClasses.keySet()) {
			Long result = checkForBidirectionalMapping(path, fullPath);
			if (result != null) {
				matches.add(new IIMatch(path, fullPath, coupledClasses.get(path), result));
			}
		}
		// validate matches. 
		matches.forEach((m) -> {
			if(m.validate(couplingThreshold)) positiveMatches.add(m);
		});
		
		printResults(positiveMatches);

		return positiveMatches.size() > 0 ;
	}

	private void printResults(List<IIMatch> positiveMatches) {
		for (IIMatch m : positiveMatches) {
			System.out.println("[II] Detected II between " + m.pathClsA + " and " + m.pathClsB);
			debug.debug(m);
		}
	}

	private Long checkForBidirectionalMapping(String path, String origPath) {
		Map<String, Long> map = getCouplingMap(path);

		for (String p : map.keySet()) {
			if (p.equals(origPath)) {
				return map.get(p);
			}
		}
		return null;
	}

	private Map<String, Long> getCouplingMap(String fullPath) {
		Set<String> couplingData = global.getStrSetMap(CLASS_COUPLING).get(fullPath);
		if (couplingData == null) {
			return Collections.<String, Long>emptyMap();
		}
		
		Map<String, Long> map = new HashMap<String, Long>();
		for (String data : couplingData) {
			String[] arr = data.split("&ref=");
			map.putIfAbsent(arr[0], Long.parseLong(arr[1]));
		}
		return map;
	}

	@Override
	protected String getName() {
		return "Inappropriate Intimacy";
	}

	public class IIMatch {
		private String pathClsA;
		private String pathClsB;
		private Long occurrencesAtoB;
		private Long occurrencesBtoA;

		IIMatch(String pathA, String pathB, Long occ1, Long occ2) {
			this.pathClsA = pathA;
			this.pathClsB = pathB;
			this.occurrencesAtoB = occ1;
			this.occurrencesBtoA = occ2;
		}

		public final String getPath1() {
			return pathClsA;
		}

		public final void setPath1(String path1) {
			this.pathClsA = path1;
		}

		public final String getPath2() {
			return pathClsB;
		}

		public final void setPath2(String path2) {
			this.pathClsB = path2;
		}

		public final Long getOccurrence1() {
			return occurrencesAtoB;
		}

		public final void setOccurrence1(Long occurrence1) {
			this.occurrencesAtoB = occurrence1;
		}

		public final Long getOccurrence2() {
			return occurrencesBtoA;
		}

		public final void setOccurrence2(Long occurrence2) {
			this.occurrencesBtoA = occurrence2;
		}

		public boolean validate(Integer threshold) { 
			return this.occurrencesAtoB != null && this.occurrencesBtoA != null && (this.occurrencesAtoB >= threshold && this.occurrencesBtoA >= threshold);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Class A: " + pathClsA);
			sb.append("\nClass B: " + pathClsB);
			sb.append("\nA to B: " + occurrencesAtoB); 
			sb.append("\nB to A: " + occurrencesBtoA);
			sb.append("\nValid: " + (occurrencesAtoB >= 3 && occurrencesBtoA >= 3));
			return sb.toString();
			
		}
		
	}

}
