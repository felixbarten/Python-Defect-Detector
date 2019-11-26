package analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import analysis.detector.DataStore;
import analysis.storage.PrimitiveIntMap;
import analysis.storage.SetStrMap;
import model.Assign;
import model.Class;
import model.ContentContainer;
import model.ContentContainerVisitor;
import model.Project;
import model.Subroutine;
import model.Variable;
import util.Debugging;
import util.StringHelper;

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
	private Debugging debug = Debugging.getInstance();

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
		this.intMetrics.put(Metric.CLASS_METHODS_NO_PARAMS,
				new IntMetricVals(Metric.CLASS_METHODS_NO_PARAMS.toString()));
		this.intMetrics.put(Metric.CLASS_PUBLIC_FIELDS, new IntMetricVals(Metric.CLASS_PUBLIC_FIELDS.toString()));
		this.intMetrics.put(Metric.CLASS_PRIVATE_FIELDS, new IntMetricVals(Metric.CLASS_PRIVATE_FIELDS.toString()));
		this.intMetrics.put(Metric.SUBROUTINE_LOC, new IntMetricVals(Metric.SUBROUTINE_LOC.toString()));
		this.intMetrics.put(Metric.SUBROUTINE_PARAMS, new IntMetricVals(Metric.SUBROUTINE_PARAMS.toString()));
		this.intMetrics.put(Metric.SUBROUTINE_AID, new IntMetricVals(Metric.SUBROUTINE_AID.toString()));
		this.intMetrics.put(Metric.SUBROUTINE_AVG_CC, new IntMetricVals(Metric.SUBROUTINE_AVG_CC.toString()));

		this.intMetrics.put(Metric.CLASS_WMC, new IntMetricVals(Metric.CLASS_WMC.toString()));
		this.intMetrics.put(Metric.CLASS_AVG_CC, new IntMetricVals(Metric.CLASS_AVG_CC.toString()));

		this.intMetrics.put(Metric.SUBROUTINE_CC, new IntMetricVals(Metric.SUBROUTINE_CC.toString()));
		this.intMetrics.put(Metric.PROJECT_CC, new IntMetricVals(Metric.PROJECT_CC.toString()));

		this.intMetrics.put(Metric.PROJECT_LOC, new IntMetricVals(Metric.PROJECT_LOC.toString()));
		this.intMetrics.put(Metric.PROJECT_GLOBAL_CC, new IntMetricVals(Metric.PROJECT_GLOBAL_CC.toString()));
		this.intMetrics.put(Metric.PROJECT_AVG_LOC, new IntMetricVals(Metric.PROJECT_AVG_LOC.toString()));

		this.floatMetrics.put(Metric.CLASS_AMW, new FloatMetricVals(Metric.CLASS_AMW.toString())); // just need to store
																									// some floats.
		this.floatMetrics.put(Metric.PROJECT_AVG_AMW, new FloatMetricVals(Metric.PROJECT_AVG_AMW.toString()));
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
			counter.sortAndCalculateStats(
					requiredMetricPercentages.containsKey(metric) ? requiredMetricPercentages.get(metric)
							: Collections.emptySet());
		}

		for (Metric metric : this.floatMetrics.keySet()) {
			FloatMetricVals counter = this.floatMetrics.get(metric);
			counter.sortAndCalculateStats(
					requiredMetricPercentages.containsKey(metric) ? requiredMetricPercentages.get(metric)
							: Collections.emptySet());
		}

		for (Metric metric : this.strMetrics.keySet()) {
			SetStrMap stringSets = this.strMetrics.get(metric);
			stringSets.loadValues(metric.toString());
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

	private SetStrMap getStringCounter(Metric metric) {
		return this.strMetrics.get(metric);
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
		private model.Module currentModule = null;

		private void reset() {
			projectLOC = 0;
			projectCC = 0;
			projectAMW = 0.0f;
			classCC = 0;
			classLOC = 0;
			projectSubCC = 0;

			subroutineCount = 0;
			classCount = 0;
			moduleCount = 0;
		}

		/**
		 * This Method is ran at the end of the data collection process not on each
		 * project.
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
			currentModule = m;
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
			getCounter(Metric.CLASS_METHODS_AND_VARS)
					.add(m.getDefinedSubroutinesSet().size() + m.getDefinedVarsInclParentsVars().getAsSet().size());
			getCounter(Metric.CLASS_ACCESSORS).add(m.accessorCount());
			getCounter(Metric.CLASS_LCOM).add(m.getLcom());
			getCounter(Metric.CLASS_METHODS_NO_PARAMS).add(m.subroutinesWithNoParamsCount());
			Long publicFields = m.getDefinedVarsInclParentsVars().getAsSet().stream().filter(Variable::isPublic)
					.count();
			getCounter(Metric.CLASS_PUBLIC_FIELDS).add(publicFields.intValue());
			Long privateFields = m.getDefinedVarsInclParentsVars().getAsSet().stream().filter(Variable::isPrivate)
					.count();

			getCounter(Metric.CLASS_PRIVATE_FIELDS).add(privateFields.intValue());
			getCounter(Metric.CLASS_WMC).add((int) m.getWMC());
			float amw = (float) m.getWMC() / checkIfZero(m.getNOM());
			getFloatCounter(Metric.CLASS_AMW).add(amw);
			Set<String> superclassPaths = new HashSet<>();

			for (model.Class c : m.getSuperclasses().values()) {
				superclassPaths.add(c.getFullPath());
			}
			globalDataStore.getStrSetMap(Metric.CLASS_PARENTS.toString()).add(m.getFullPath(), superclassPaths);
			globalDataStore.getStrSetMap(Metric.CLASS_DEF_METHODS.toString()).add(m.getFullPath(),
					m.getSubroutineNames());
			globalDataStore.getStrSetMap(Metric.CLASS_FIELDNAMES.toString()).add(m.getFullPath(), m.getVariableNames());
			globalDataStore.getStrSetMap(Metric.CLASS_REF_CLS_NAMES.toString()).add(m.getFullPath(),
					m.getReferencedClassNames());
			Set<String> calledMethods = m.getReferencedMethodsNames();
			globalDataStore.getStrSetMap(Metric.CLASS_REF_METHOD_NAMES.toString()).add(m.getFullPath(), calledMethods);
			Set<String> refVars = m.getReferencedVariableNames();
			globalDataStore.getStrSetMap(Metric.CLASS_REF_VAR_NAMES.toString()).add(m.getFullPath(), refVars);

			// loop through variables get an actual path that we can use maybe and write to
			// file.
			// this should save whether the Key class accessed a member of class B.
			Set<Variable> refVarInstances = m.getReferencedVariablesSet();
			Set<String> paths = new HashSet<String>();
			for (Variable v : refVarInstances) {
				// for our purposes we don't care about if a class references a variable from
				// itself.
				if (m.getName() != v.getParent().getName()) {
					paths.add(v.getParent().getName() + " > " + v.getName());
				}
			}

			globalDataStore.getStrSetMap(Metric.CLASS_REF_VAR_PATHS.toString()).add(m.getFullPath(), paths);

			globalDataStore.getStrSetMap(Metric.CLASS_REF_VAR_NAMES.toString()).add(m.getFullPath(), refVars);

			globalDataStore.getPrimitiveIntMapStore(Metric.CLASS_REF_CLS_COUNT.toString()).add(m.getFullPath(),
					m.getReferencedClassesCount().size());
			globalDataStore.getPrimitiveIntMapStore(Metric.CLASS_REF_VAR_COUNT.toString()).add(m.getFullPath(),
					m.getReferencedVariableCount().size());
			globalDataStore.getPrimitiveIntMapStore(Metric.CLASS_PROTECTED_FIELDS.toString()).add(m.getFullPath(),
					m.getProtectedVars().getAsSet().size());

			globalDataStore.getPrimitiveIntMapStore(Metric.CLASS_WMC.toString()).add(m.getFullPath(), m.getWMC());
			globalDataStore.getPrimitiveFloatMapStore(Metric.CLASS_AMW.toString()).add(m.getFullPath(), amw);
			globalDataStore.getPrimitiveIntMapStore(Metric.CLASS_LOC.toString()).add(m.getFullPath(), m.getLoc());
			globalDataStore.getPrimitiveIntMapStore(Metric.CLASS_METHODS.toString()).add(m.getFullPath(), m.getNOM());

			processIIData(m);

			projectCC += m.getCC();
			classLOC += m.getLoc();
			classCC += m.getCC();
			currentCls = m;
			projectAMW += amw;

			classStore.put(m, m.getLoc());
			classCount++;
			return null;
		}

		/**
		 * This method will do the heavy lifting for Inappropriate Intimacy detection.
		 * It loops through the class's subroutines and finds unresolved referenced
		 * variables. The method will attempt to resolve the origin of the unresolved
		 * variables. After resolving the the instance variables calls and attribute
		 * references can be examined. The counting of these variables will be useful to
		 * see how many links class A has with Class B.
		 * 
		 * @param cls
		 */
		private void processIIData(Class cls) {
			String clsName = cls.getName();

			List<Assign> subroutineAssigns = new ArrayList<>();
			Map<String, Long> occurrenceCount = new HashMap<>();

			List<String> refVarNamesList = new ArrayList<>();
			Set<String> refVarNamesSet = new HashSet<>();

			Set<String> calledSubRoutinesSet = new HashSet<>();
			Set<String> calledSubRoutinesList = new HashSet<>();

			cls.getDefinedSubroutinesSet().stream().forEach((sub) -> {
				refVarNamesSet.addAll(sub.getReferencedVarNamesNotIncludedInVars());
				refVarNamesList.addAll(sub.getReferencedVarNamesNotIncludedInVarsList());
				calledSubRoutinesSet.addAll(sub.getCalledSubroutineNames());
				calledSubRoutinesList.addAll(sub.getCalledSubroutineNamesList());
				subroutineAssigns.addAll(sub.getAssignList());
			});

			if (refVarNamesSet.isEmpty())
				return;

			// Set of unresolved variables that are not "self"
			Set<String> unknownTypeVars = new HashSet<>();
			for (String varName : refVarNamesSet) {
				if (varName.contains(".")) {
					List<String> parts = StringHelper.explode(varName, ".");
					if (parts.size() > 1 && !parts.get(0).equalsIgnoreCase("self")) {
						unknownTypeVars.add(parts.get(0));
					}
				}
			}

			if (unknownTypeVars.isEmpty())
				return;

			// Map of varname => Type(as String)
			Map<String, String> instanceVars = new HashMap<>();

			// iterate over Assigns to see if any have our variable's Type.
			for (Assign a : cls.getAssignList()) {
				if (unknownTypeVars.contains(a.getName())) {
					instanceVars.put(a.getName(), a.getValue());
				}
			}
			
			for(Assign a : subroutineAssigns) {
				if (unknownTypeVars.contains(a.getName())) {
					instanceVars.put(a.getName(), a.getValue());
				}
			}
			
			if(instanceVars.isEmpty()) return;
			
			Map<String, model.Class> importStringToClassMap = checkImports(instanceVars);
			// Map variable name => Type (of Class).
			Map<String, model.Class> typedVariables = new HashMap<>();
			// yet another loop. to combine data.
			for (Map.Entry<String, String> entry : instanceVars.entrySet()) {
				if (importStringToClassMap.get(entry.getValue()) != null) {
					typedVariables.put(entry.getKey(), importStringToClassMap.get(entry.getValue()));
				}
			}

			// Remove identified variables.
			unknownTypeVars.removeAll(typedVariables.keySet());

			// log unidentified variables.

			// TODO more permanent logging
			try {
				Debugging.getInstance().debug(unknownTypeVars);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Map<String, Long> occurrences = refVarNamesList.stream()
					.collect(Collectors.groupingBy(String::toString, Collectors.counting()));

			// now we finally have resolved our classes and instances. We can count
			// occurrences.
			for (String varName : typedVariables.keySet()) {
				for (String subroutine : calledSubRoutinesList) {
					if (subroutine.startsWith(varName) && subroutine.contains(".")) {
						if (!occurrenceCount.containsKey(varName)) {
							occurrenceCount.put(varName, (long) 1);
						} else {
							occurrenceCount.computeIfPresent(varName, (k, v) -> v + 1);
						}
					}
				}

				for (String refVar : refVarNamesSet) {
					if (refVar.startsWith(varName) && refVar.contains(".")) {
						if (!occurrenceCount.containsKey(varName)) {
							occurrenceCount.put(varName, (long) 1);
						} else {
							// imperfect workaround for double adding names to list.
							//occurrenceCount.computeIfPresent(varName, (k, v) -> v + 1);

							if (occurrences.containsKey(refVar) && occurrences.get(refVar) > 2) {
								long increment = occurrences.get(refVar) - 1;
								occurrenceCount.computeIfPresent(varName, (k, v) -> v + increment);
							} else {
								occurrenceCount.computeIfPresent(varName, (k, v) -> v + 1);
							}
						}
					}
				}

			}

			// Data storage.

			System.out.println();

		}

		/**
		 * Check the gathered Import types and attempt to match them with the module's
		 * imports.
		 * 
		 * @param module
		 * @param instanceVars
		 * @return
		 */
		private Map<String, Class> checkImports(Map<String, String> instanceVars) {
			if(currentModule == null) return null;
			model.Module module = currentModule; 
			
			Map<String, model.Class> typedInstanceVars = new HashMap<>();
			// Gather imports and defined Classes.
			Map<String, model.Class> clsImports = module.getClassImports();
			Map<String, model.Module> modImports = module.getModuleImports();

			// cls imports already handle Aliased imports.
			for (String key : clsImports.keySet()) {
				if (instanceVars.containsValue(key)) {
					typedInstanceVars.put(key, clsImports.get(key));
					continue;
				}
			}

			for (String key : modImports.keySet()) {
				model.Module impModule = modImports.get(key);

				if (instanceVars.containsValue(key)) {
					if (impModule.getClass(key) != null) {
						typedInstanceVars.put(key, impModule.getClass(key));
						continue;
					} else {
						String aliasedCls = module.getImportAlias(key);
						if (aliasedCls != null && impModule.getClass(aliasedCls) != null) {
							typedInstanceVars.put(key, impModule.getClass(aliasedCls));
							continue;
						}
					}
				}
			}

			return typedInstanceVars;
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
	 * 
	 * @param project
	 */
	public void getProjectData(Project project) {

		String projectPath = project.getPath();

		Float avgProjectAMW = (float) this.collector.projectAMW / checkIfZero(this.collector.classCount);
		getCounter(Metric.PROJECT_LOC).add(this.collector.projectLOC);
		globalDataStore.getPrimitiveIntMapStore(Metric.PROJECT_AVG_LOC.toString()).add(projectPath,
				this.collector.projectLOC / checkIfZero(this.collector.classCount));
		globalDataStore.getPrimitiveIntMapStore(Metric.CLASS_AVG_LOC.toString()).add(projectPath,
				this.collector.classLOC / checkIfZero(this.collector.classCount));

		getCounter(Metric.PROJECT_CC).add(this.collector.projectCC);
		globalDataStore.getPrimitiveFloatMapStore(Metric.CLASS_AVG_CC.toString()).add(projectPath, getClassCCAVG());
		getCounter(Metric.SUBROUTINE_AVG_CC).add(getSubRoutineCCAVG());

		getCounter(Metric.PROJECT_AVG_LOC).add(this.collector.projectLOC / checkIfZero(this.collector.classCount));
		if (!avgProjectAMW.isNaN()) {
			getFloatCounter(Metric.PROJECT_AVG_AMW).add(avgProjectAMW);
			globalDataStore.getPrimitiveFloatMapStore(Metric.PROJECT_AVG_AMW.toString()).add(projectPath,
					avgProjectAMW);
		}

		this.collector.reset();
		count++;
	}

	private Integer getClassCCAVG() {
		return Math.round(this.collector.classCC / checkIfZero(this.collector.classCount));
	}

	private Integer getSubRoutineCCAVG() {
		return Math.round(this.collector.projectCC / checkIfZero(this.collector.subroutineCount));
	}

	private Integer getNOM() {
		return Math.round(checkIfZero(this.collector.subroutineCount) / checkIfZero(this.collector.classCount));
	}

	private int checkIfZero(int n) {
		return n == 0 ? 1 : n;
	}
}
