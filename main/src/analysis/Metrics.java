package analysis;

import model.*;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import analysis.detector.DataStore;
import analysis.storage.PrimitiveIntMap;

/**
 * Created by Nik on 04-11-2015
 */
public class Metrics {

	private final Collector collector;
	// Variable to keep track of when the metrics are finished collecting. 
	private boolean finishedCollecting;

	private final Map<Metric, IntMetricVals> intMetrics;
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
		
		this.intMetrics.put(Metric.CLASS_CC, new IntMetricVals(Metric.CLASS_CC.toString()));
		this.intMetrics.put(Metric.SUBROUTINE_CC, new IntMetricVals(Metric.SUBROUTINE_CC.toString()));
		this.intMetrics.put(Metric.PROJECT_CC, new IntMetricVals(Metric.PROJECT_CC.toString()));
		this.intMetrics.put(Metric.PROJECT_LOC, new IntMetricVals(Metric.PROJECT_LOC.toString()));
		this.intMetrics.put(Metric.PROJECT_GLOBAL_CC, new IntMetricVals(Metric.PROJECT_GLOBAL_CC.toString()));
		this.intMetrics.put(Metric.AVG_CLASS_CC, new IntMetricVals(Metric.AVG_CLASS_CC.toString()));
		this.intMetrics.put(Metric.AVG_SUBROUTINE_CC, new IntMetricVals(Metric.AVG_SUBROUTINE_CC.toString()));		

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
		// sub cc is used for subroutines outside of classes(imperative style files). 
		public int projectSubCC = 0;
		
		private int classCount = 0;
		private int subroutineCount = 0;
		private int classCC = 0;
		private model.Class currentCls = null;
		
		
		
		private void reset() {
			projectLOC 		= 0;
			projectCC 		= 0;

			classCC 		= 0;
			classLOC 		= 0;
			
			subroutineCount	= 0;
			classCount 		= 0;
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
		public Void visit(Module m) {
			projectLOC += m.getLoc();
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
			getCounter(Metric.CLASS_CC).add(m.getCC());
			projectCC += m.getCC();
			classLOC += m.getLoc();
			classCC +=m.getCC();
			currentCls = m;
			
			classStore.put(m, m.getLoc());
			globalDataStore.getPrimitiveMapStore("CLASS_LOC").add(m.getFullPath(), m.getLoc());
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
	/*
	 * Called upon when the modules of a project have all been checked. 
	 */
	public void getProjectData(Project project) {
		
		String path = project.getPath();

		//getCounter(Metric.PROJECT_LOC).add(this.collector.projectLOC);
		//getCounter(Metric.PROJECT_CC).add(this.collector.projectCC);
		
		//projectStore.put(project, this.collector.projectCC); 
		
		globalDataStore.getPrimitiveMapStore("PROJECT_LOC").add(path, this.collector.projectLOC);
		globalDataStore.getPrimitiveMapStore("PROJECT_CC").add(path, this.collector.projectCC);
		globalDataStore.getPrimitiveMapStore("CLASS_AVG_CC").add(path, getClassCCAVG());
		globalDataStore.getPrimitiveMapStore("PROJECT_AVG_SUBROUTINE_CC").add(path, getSubRoutineCCAVG());
		globalDataStore.getPrimitiveMapStore("GLOBAL_AVG_NOM").add(path, getNOM());
		
		getCounter(Metric.AVG_CLASS_CC).add(getClassCCAVG());
		getCounter(Metric.AVG_SUBROUTINE_CC).add(getSubRoutineCCAVG());
		
		PrimitiveIntMap map = globalDataStore.getPrimitiveMapStore("CLASS_AVG_CC");
		
		
		/*
		System.err.println(globalDataStore != null);
		System.err.println(globalDataStore.getPrimitiveMapStore("CLASS_AVG_CC"));
		System.err.println(map == globalDataStore.getPrimitiveMapStore("CLASS_AVG_CC"));
		
		try {
			System.err.println(globalDataStore.getPrimitiveMapStore("CLASS_LOC").getNextKey());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//project.getModules().stream()

		
		//System.err.println(map.getNextKey());

		//map.get(path);
		/*
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
				
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
