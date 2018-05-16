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

	private final static String GLOBAL_CC_AVG = "GLOBAL_CC_AVG";
	private final static String CLOC = "CLOC";
	private final static String OVERRIDES = "OVERRIDES";
	private final static String CLASS_CC = "CLASS_CC";
	private final static String GLOBAL_LOC = "GLOBAL_LOC";

	
	
	private Class cls;

	public RefusedBequestDetector() throws IOException {
		super();
	}

	@Override
	public void addDataStores() throws IOException {
		this.addDataStore(GLOBAL_CC_AVG, new PrimitiveIntMap(this.getDataStoreFilePath(GLOBAL_CC_AVG)));
		this.addDataStore(CLOC, new PrimitiveIntMap(this.getDataStoreFilePath(CLOC)));
		this.addDataStore(OVERRIDES, new PrimitiveIntMap(this.getDataStoreFilePath(OVERRIDES)));
		this.addDataStore(CLASS_CC, new PrimitiveIntMap(this.getDataStoreFilePath(CLASS_CC)));
		this.addDataStore(GLOBAL_LOC, new PrimitiveIntMap(this.getDataStoreFilePath(GLOBAL_LOC)));
	}

	@Override
	protected Boolean isPreliminarilyDefective(model.Class cls) {
		this.cls = cls;
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
	
	private boolean refusedBequest(Class cls) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean overridesMethods() {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean fewProtectedMembers(Class cls) {
		return cls.getPrivateParentVars().getAsSet().size() > 5;

	}
	
	private boolean clsComplex(Class cls) {
		return (funcCCAboveAvg(cls) || clsCCAboveAvg(cls)) && clsSizeAboveAvg(cls);
	}

	private boolean clsSizeAboveAvg(Class cls) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean funcCCAboveAvg(Class cls) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean clsCCAboveAvg(Class cls) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
