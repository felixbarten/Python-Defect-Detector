package analysis;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import analysis.detector.DataStore;
import analysis.storage.PrimitiveIntMap;
import analysis.storage.SetStrMap;
import model.ContentContainer;
import model.ContentContainerVisitor;
import model.Project;
import model.Subroutine;
import model.Variable;

/**
 * Created by Nik on 04-11-2015
 */
public class Metrics {

	private final Collector collector;
	// Variable to keep track of when the metrics are finished collecting. 
	private boolean finishedCollecting;

	private final Map<Metric, IntMetricVals> intMetrics;
	private final Map<Metric, FloatMetricVals> floatMetrics;
	private final Map<Metric, SetStrMap> strMetrics;
	private DataStore globalDataStore;
	
	private Map<Project, Integer> projectStore;
	private Map<model.Class, Integer> classStore;
	private Project project;
	
	
	public Metrics() throws IOException {
		this.collector = new Collector();
		this.finishedCollecting = false;

		this.projectStore = new HashMap<>();
		this.classStore = new HashMap<>();
		this.globalDataStore = DataStore.getInstance();
		
		this.intMetrics = new HashMap<>();
		this.floatMetrics = new HashMap<>();
		this.strMetrics = new HashMap<>();
		this.intMetrics.put(Metric.CLASS_LOC, new IntMetricVals(Metric.CLASS_LOC.toString()));
		this.intMetrics.put(Metric.CLASS_SUPERCLASSES, new IntMetricVals(Metric.CLASS_SUPERCLASSES.toString()));
		this.intMetrics.put(Metric.CLASS_METHODS, new IntMetricVals(Metric.CLASS_METHODS.toString()));
		this.intMetrics.put(Metric.CLASS_METHODS_AND_VARS, new IntMetricVals(Metric.CLASS_METHODS_AND_VARS.toString()));
		this.intMetrics.put(Metric.CLASS_ACCESSORS, new IntMetricVals(Metric.CLASS_ACCESSORS.toString()));
		this.intMetrics.put(Metric.CLASS_LCOM, new IntMetricVals(Metric.CLASS_LCOM.toString()));
		this.intMetrics.put(Metric.CLASS_METHODS_NO_PARAMS, new IntMetricVals(Metric.CLASS_METHODS_NO_PARAMS.toString()));
		this.intMetrics.put(Metric.CLASS_PUBLIC_FIELDS, new IntMetricVals(Metric.CLASS_PUBLIC_FIELDS.toString()));
		this.intMetrics.put(Metric.CLASS_PRIVATE_FIELDS, new IntMetricVals(Metric.CLASS_PRIVATE_FIELDS.toString()));
		this.intMetrics.put(Metric.SUBROUTINE_LOC, new IntMetricVals(Metric.SUBROUTINE_LOC.toString()));
		this.intMetrics.put(Metric.SUBROUTINE_PARAMS, new IntMetricVals(Metric.SUBROUTINE_PARAMS.toString()));
		this.intMetrics.put(Metric.SUBROUTINE_AID, new IntMetricVals(Metric.SUBROUTINE_AID.toString()));
		this.intMetrics.put(Metric.SUBROUTINE_AVG_CC, new IntMetricVals(Metric.SUBROUTINE_AVG_CC.toString()));		

		this.intMetrics.put(Metric.CLASS_WMC, new IntMetricVals(Metric.CLASS_WMC.toString()));
		this.floatMetrics.put(Metric.CLASS_AMW, new FloatMetricVals(Metric.CLASS_AMW.toString())); // just need to store some floats.
		this.intMetrics.put(Metric.CLASS_AVG_CC, new IntMetricVals(Metric.CLASS_AVG_CC.toString()));

		
		this.intMetrics.put(Metric.SUBROUTINE_CC, new IntMetricVals(Metric.SUBROUTINE_CC.toString()));
		this.intMetrics.put(Metric.PROJECT_CC, new IntMetricVals(Metric.PROJECT_CC.toString()));
		
		this.intMetrics.put(Metric.PROJECT_LOC, new IntMetricVals(Metric.PROJECT_LOC.toString()));
		this.intMetrics.put(Metric.PROJECT_GLOBAL_CC, new IntMetricVals(Metric.PROJECT_GLOBAL_CC.toString()));
		this.floatMetrics.put(Metric.PROJECT_AVG_AMW, new FloatMetricVals(Metric.PROJECT_AVG_AMW.toString()));
		this.intMetrics.put(Metric.PROJECT_AVG_LOC, new IntMetricVals(Metric.PROJECT_AVG_LOC.toString()));

	}

	public void register(ContentContainer contentContainer) {
		if (this.finishedCollecting) {
			throw new IllegalStateException();
		}
		this.collector.collect(contentContainer);
	}

	public void terminateCollecting(Map<Metric, Set<Integer>> requiredMetricPercentages) throws IOException {
		this.collector.finishCollection();
		this.finishedCollecting = true;
		for (Metric metric : this.intMetrics.keySet()) {
			IntMetricVals counter = this.intMetrics.get(metric);
			counter.sortAndCalculateStats(requiredMetricPercentages.containsKey(metric) ? requiredMetricPercentages.get(metric) : Collections.emptySet());
		}
		
		for (Metric metric : this.floatMetrics.keySet()) {
			FloatMetricVals counter = this.floatMetrics.get(metric);
			counter.sortAndCalculateStats(requiredMetricPercentages.containsKey(metric) ? requiredMetricPercentages.get(metric) : Collections.emptySet());
		}
	}

	public boolean isExtremeOutlier(Metric metric, Integer value) {
		return this.getCounter(metric).isExtremeOutlier(value);
	}

	public boolean isMildOutlier(Metric metric, Integer value) {
		return this.getCounter(metric).isMildOutlier(value);
	}

	public boolean isInTop(Metric metric, Integer percentage, Integer value) {
		IntMetricVals counter = this.getCounter(metric);
		return counter.isInTop(percentage, value);
	}
	public boolean isInBottom(Metric metric, Integer percentage, Integer value) {
		IntMetricVals counter = this.getCounter(metric);
		return counter.isInBottom(percentage, value);
	}

	private IntMetricVals getCounter(Metric metric) {
		return this.intMetrics.get(metric);
	}
	
	private FloatMetricVals getFloatCounter(Metric metric) {
		return this.floatMetrics.get(metric);
	}
	
	public Collector getCollector() {
		return collector;
	}
	
	public DataStore getGlobalData() {
		return globalDataStore;
	}

	private class Collector implements ContentContainerVisitor<Void> {
		
		public int projectLOC = 0;
		public int projectCC = 0;
		public int classLOC = 0;
		public float projectAMW = 0.0f;
		// sub cc is used for subroutines outside of classes(imperative style files). 
		public int projectSubCC = 0;
		
		private int classCount = 0;
		private int subroutineCount = 0;
		private int classCC = 0;
		private int moduleCount = 0; 
		private model.Class currentCls = null;
		
		
		
		private void reset() {
			projectLOC 		= 0;
			projectCC 		= 0;
			projectAMW  	= 0.0f;
			classCC 		= 0;
			classLOC 		= 0;
			
			subroutineCount	= 0;
			classCount 		= 0;
			moduleCount 	= 0;
		}
		/**
		 * This Method is ran at the end of the data collection process not on each project. 
		 */
		public void finishCollection() {
			getCounter(Metric.PROJECT_GLOBAL_CC).add(projectSubCC);	
		}
		
		public void collect(ContentContainer contentContainer) {
			contentContainer.accept(this);
		}
		
		// never used.
		@Override
		public Void visit(Project m) { 
			project = m;
			return null;
		}
		
		@Override
		public Void visit(model.Module m) {
			projectLOC += m.getLoc();
			moduleCount++;
			currentCls = null;
			return null;
		}
		
		@Override
		public Void visit(model.Class m) {
			getCounter(Metric.CLASS_LOC).add(m.getLoc());
			getCounter(Metric.CLASS_SUPERCLASSES).add(m.superclassCount());
			getCounter(Metric.CLASS_METHODS).add(m.getDefinedSubroutinesSet().size());
			getCounter(Metric.CLASS_METHODS_AND_VARS).add(m.getDefinedSubroutinesSet().size() + m.getDefinedVarsInclParentsVars().getAsSet().size());
			getCounter(Metric.CLASS_ACCESSORS).add(m.accessorCount());
			getCounter(Metric.CLASS_LCOM).add(m.getLcom());
			getCounter(Metric.CLASS_METHODS_NO_PARAMS).add(m.subroutinesWithNoParamsCount());
			Long publicFields = m.getDefinedVarsInclParentsVars().getAsSet().stream().filter(Variable::isPublic).count();
			getCounter(Metric.CLASS_PUBLIC_FIELDS).add(publicFields.intValue());
			Long privateFields = m.getDefinedVarsInclParentsVars().getAsSet().stream().filter(Variable::isPrivate).count();
			getCounter(Metric.CLASS_PRIVATE_FIELDS).add(privateFields.intValue());
			getCounter(Metric.CLASS_WMC).add((int) m.getWMC());
			float amw = m.getWMC() / checkIfZero(m.getNOM());
			getFloatCounter(Metric.CLASS_AMW).add(amw);
			projectCC += m.getCC();
			classLOC += m.getLoc();
			classCC +=m.getCC();
			currentCls = m;
			projectAMW += amw;
			
			classStore.put(m, m.getLoc());
			//globalDataStore.getPrimitiveMapStore("CLASS_LOC").add(m.getFullPath(), m.getLoc());
			classCount++;
			return null;
		}

		@Override
		public Void visit(Subroutine m) {
			getCounter(Metric.SUBROUTINE_LOC).add(m.getLoc());
			getCounter(Metric.SUBROUTINE_PARAMS).add(m.paramCount());
			getCounter(Metric.SUBROUTINE_AID).add(m.getAccessOfImportData());
			getCounter(Metric.SUBROUTINE_CC).add(m.getCC());
			projectSubCC += m.getCC();
			
			if (m.isFunction()) {
				if (m.getParentClass() != null && currentCls != null && m.getParentClass() == currentCls) {
					currentCls.addSubroutine(m);
				}
			} else {
				currentCls = null;
			}
			subroutineCount++;
			return null;
		}
	}
	private int count = 1;

	/**
	 * Called when rest of the project has been processed 
	 * @param project
	 */
	public void getProjectData(Project project) {
		
		String path = project.getPath();

		//	globalDataStore.getPrimitiveMapStore(Metric.PROJECT_LOC.toString()).add(path, this.collector.projectLOC);
			//globalDataStore.getPrimitiveMapStore(Metric.PROJECT_CC.toString()).add(path, this.collector.projectCC);
		//	globalDataStore.getPrimitiveMapStore(Metric.CLASS_AVG_CC.toString()).add(path, getClassCCAVG());
			
			Float avgProjectAMW = (float)this.collector.projectAMW / this.collector.classCount; 
			//globalDataStore.getPrimitiveMapStore(Metric.SUBROUTINE_AVG_CC.toString()).add(path, getSubRoutineCCAVG());
			//globalDataStore.getPrimitiveMapStore(Metric.PROJECT_AVG_LOC.toString()).add(path, this.collector.projectLOC / checkIfZero(this.collector.moduleCount));
			//globalDataStore.getPrimitiveFloatMapStore(Metric.PROJECT_AVG_AMW.toString()).add(path, avgProjectAMW);
			
			getCounter(Metric.PROJECT_LOC).add(this.collector.projectLOC);
			getCounter(Metric.PROJECT_CC).add(this.collector.projectCC);
			getCounter(Metric.CLASS_AVG_CC).add(getClassCCAVG());
			getCounter(Metric.SUBROUTINE_AVG_CC).add(getSubRoutineCCAVG());
			getCounter(Metric.PROJECT_AVG_LOC).add(this.collector.projectLOC / checkIfZero(this.collector.moduleCount));
			if (!avgProjectAMW.isNaN()) 
				getFloatCounter(Metric.PROJECT_AVG_AMW).add(avgProjectAMW);

		
		this.collector.reset();
		System.out.println("Project data aggregation: " + count); 
		count++;
	}

	private Integer getClassCCAVG() {
		if(this.collector.classCount == 0) {
			return 1;
		}
		return Math.round(this.collector.classCC / this.collector.classCount);
	}
	
	private Integer getSubRoutineCCAVG() {
		if(this.collector.subroutineCount == 0) {
			return 1;
		}
		return  Math.round(this.collector.projectCC / this.collector.subroutineCount);
	}
	
	private Integer getNOM() {
		
		return Math.round(checkIfZero(this.collector.subroutineCount) / checkIfZero(this.collector.classCount));
	}
	
	private int checkIfZero(int n) {
		return n == 0 ? 1 : n;
	}
}
