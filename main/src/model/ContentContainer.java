package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Nik on 20-10-2015
 */
public abstract class ContentContainer extends ContentDefinitions {

	protected final List<String> calledSubroutineNamesList;
	protected final Set<String> calledSubroutineNames;
	protected final Map<String, Subroutine> calledSubroutines;

	protected final Set<String> referencedVarNames;
	protected final VarDefinitions referencedVars;
	protected final List<String> referencedVarNamesList;
	
	protected final Map<String, Class> referencedClasses;
	protected final Map<String, MethodCall> invokedMethods;

	protected final List<Assign> assigns;

	protected final String name;
	protected final Integer loc;

	public ContentContainer(String name, Integer loc) {
		super();
		this.name = name;

		this.referencedVars = new VarDefinitions();
		this.referencedVarNames = new HashSet<>();
		this.referencedVarNamesList = new ArrayList<String>();

		this.calledSubroutines = new HashMap<>();
		this.calledSubroutineNames = new HashSet<>();
		this.calledSubroutineNamesList = new ArrayList<String>();

		this.referencedClasses = new HashMap<>();
		this.invokedMethods = new HashMap<>();

		this.assigns = new ArrayList<>();
		this.loc = loc;
	}

	//-----------------------------------------------------------------------------------------------------\\
	//---------------------------------------------- GETTERS ----------------------------------------------\\
	//-----------------------------------------------------------------------------------------------------\\

	public String getName() {
		return this.name;
	}

	public Set<Variable> getReferencedVariablesSet() {
		Set<Variable> refVars = new HashSet<>();
		refVars.addAll(this.referencedVars.getAsSet());
		this.getChildren().forEach(c -> refVars.addAll(c.getReferencedVariablesSet()));
		return refVars;
	}

/*
	public Map<Variable, Integer> getReferencedVariableCount() {
		Map<String, Set<Variable>>  classrefs = this.referencedVars.getVars();
		
		Map<Variable, Integer> refCount = new HashMap<>();
		
		for(Variable key: classrefs) {
			if (refCount.containsKey(key)) {
				refCount.computeIfPresent(key, (k, v) -> v + 1);
			} else {
				refCount.putIfAbsent(key, 1);
			}
		}
		return refCount;
	}*/
	
	public Map<String, Integer> getReferencedVariableCount() {
		Map<String, Integer> varRefs = new HashMap<>();
				
		for(String key: this.referencedVarNamesList) {
			if (varRefs.containsKey(key)) {
				varRefs.computeIfPresent(key, (k, v) -> v + 1);
			} else {
				varRefs.putIfAbsent(key, 1);
			}
		}
		return varRefs;		
	}
	
	public Set<Variable> getReferencedGlobalsSet() {
		return this.getReferencedVariablesSet().stream()
				.filter(v -> v.getVarType() == VarType.GLOBAL || (v.getVarType() == VarType.LOCAL && !v.definedInParentOf(this)))
				.collect(Collectors.toSet());
	}

	public Set<Class> getReferencedClassesSet() {
		Set<Class> classes = this.referencedClasses.values().stream().collect(Collectors.toSet());
		this.getChildren().forEach(c -> classes.addAll(c.getReferencedClassesSet()));
		return classes;
	}
	
	public Map<Class, Integer> getReferencedClassesCount() {
		List<Class> classrefs = this.referencedClasses.values().parallelStream().collect(Collectors.toList());
		Map<Class, Integer> refCount = new HashMap<>();
		for(Class key: classrefs) {
			if (refCount.containsKey(key)) {
				refCount.computeIfPresent(key, (k, v) -> v + 1);
			} else {
				refCount.putIfAbsent(key, 1);
			}
		}
		return refCount;
	}

	public Integer subroutinesWithNoParamsCount() {
		Long count = this.definedSubroutines.values().stream()
				.filter(m -> m.paramCount() == 0)
				.count();
		return count.intValue();
	}

	public Map<String, Subroutine> getCalledSubroutines() {
		return calledSubroutines;
	}
	
	public Set<String> getCalledSubroutineNames() {
		return calledSubroutineNames;
	}
	
	public List<String> getCalledSubroutineNamesList() {
		return calledSubroutineNamesList;
	}
	
	//-----------------------------------------------------------------------------------------------------\\
	//---------------------------------------------- ADDERS -----------------------------------------------\\
	//-----------------------------------------------------------------------------------------------------\\
	
	/**
	 * Add varName to the list and set of referenced variables. 
	 * @param varName
	 */
	public void addVariableReference(String varName) {
		this.referencedVarNames.add(varName);
		this.referencedVarNamesList.add(varName);
	}

	public void addSubroutineDefinition(Subroutine subroutine) {
		this.definedSubroutines.put(subroutine.getName(), subroutine);
	}

	public void addSubroutineCall(String subroutineName) {
		this.calledSubroutineNames.add(subroutineName);
		this.calledSubroutineNamesList.add(subroutineName);
	}

	public void addClassDefinition(Class cls) {
		this.definedClasses.put(cls.getName(), cls);
	}

	protected void addVariableReference(String name, Variable var) {
		this.referencedVars.addUnrestricted(name, var);
	}

	public void addAssign(Assign assign) {
		this.assigns.add(assign);
	}

	public Integer getLoc() {
		return this.loc;
	}

	//-----------------------------------------------------------------------------------------------------\\
	//----------------------------------------------- OTHER -----------------------------------------------\\
	//-----------------------------------------------------------------------------------------------------\\
	public void resolveDependencies(Scope scope) {
		this.resolveDependencies("", scope);

		Scope classScope = scope.copy();
		classScope.addToScope(this.name, this, false);
		for (Class cls : this.definedClasses.values()) {
			if (!cls.equals(this)) {
				cls.resolveDependencies(classScope);
			}
		}

		Scope methodScope = scope.copy();
		methodScope.addToScope("", this, true);
		for (Subroutine m : this.definedSubroutines.values()) {
			if (!m.equals(this)) {
				m.resolveDependencies(methodScope);
			}
		}
	}

	public void resolveInheritance(Scope scope) {
		this.getChildren().forEach(c -> c.resolveInheritance(scope));
	}

	/**
	 *
	 *
	 */
	public void copyParentVars() {
		this.getChildren().forEach(ContentContainer::copyParentVars);
	}

	private void resolveDependencies(String prefix, ContentDefinitions scopePart) {
		if (scopePart.equals(this)) {
			return;
		}
		this.resolveClassDependenciesAndReferences(prefix, scopePart);
		this.resolveSubroutineDependenciesAndReferences(prefix, scopePart);
		this.resolveVarReferences(prefix, scopePart);
	}

	private void resolveClassDependenciesAndReferences(String prefix, ContentDefinitions scopePart) {
		for (String alias : scopePart.definedClasses.keySet()) {
			String prefixedAlias = this.prefix(alias, prefix);
			Class cls = scopePart.definedClasses.get(alias);

			if (this.calledSubroutineNames.contains(prefixedAlias)) {
				this.referencedClasses.put(prefixedAlias, cls);
				this.resolveInstanceDependencies(prefixedAlias, cls);
			}
			this.resolveDependencies(prefixedAlias, cls);
		}
	}

	private void resolveSubroutineDependenciesAndReferences(String prefix, ContentDefinitions scopePart) {
		for (String alias : scopePart.definedSubroutines.keySet()) {
			String prefixedAlias = this.prefix(alias, prefix);
			Subroutine subroutine = scopePart.definedSubroutines.get(alias);

			if (this.calledSubroutineNames.contains(prefixedAlias)) {
				this.calledSubroutines.put(prefixedAlias, subroutine);
			}
			this.resolveDependencies(prefixedAlias, subroutine);
		}
	}

	/**
	 * 
	 * @param prefix
	 * @param scopePart
	 */
	private void resolveVarReferences(String prefix, ContentDefinitions scopePart) {
		Set<String> names  = scopePart.getDefinedVarsInclParentsVars().getNames();
		for (String alias : names) {
			String prefixedAlias = this.prefix(alias, prefix);
			if (this.referencedVarNames.contains(prefixedAlias)) {
				for (Variable var : scopePart.getDefinedVarsInclParentsVars().getVarsWithName(alias)) {
					this.addVariableReference(prefixedAlias, var);
				}
			}
		}
	}

	private void resolveInstanceDependencies(String prefixedAlias, Class cls) {
		for (Assign assign : this.assigns) {
			if (assign.getValue().equals(prefixedAlias)) {
				this.resolveDependencies(assign.getName(), cls);
			}
		}
	}

	private String prefix(String str, String prefix) {
		return prefix.equals("") ? str : prefix + "." + str;
	}

	@Override
	public void unlink() {
		super.unlink();
		this.calledSubroutines.clear();
		this.referencedClasses.clear();
		this.referencedVars.unlink();
		this.definedVars.unlink();
		this.assigns.clear();
	}
	
	public final Set<String> getReferencedVarNamesNotIncludedInVars() {
		HashSet<String> excludedNames = new HashSet<>(referencedVarNames);
		for(Variable v : referencedVars.getAsSet()) {
			if (referencedVarNames.contains(v.getName())) {
				excludedNames.remove(v.getName());
			}
		}
		
		return excludedNames;
	}
	
	public final List<String> getReferencedVarNamesNotIncludedInVarsList() {
		List<String> exludedNameList = new ArrayList<String>(referencedVarNamesList);
		for(Variable v : referencedVars.getAsSet()) {
			while(true) {
				if (exludedNameList.contains(v.getName())) {
					exludedNameList.remove(v.getName());
				} else {
					break;
				}
			}
		}
		
		return exludedNameList;
	}

	public final List<String> getReferencedVarNamesList() {
		return referencedVarNamesList;
	}
	
	public final List<Assign> getAssignList() {
		return assigns;
	}
	
	public abstract boolean isInParentLine(ContentContainer container);
	public abstract String getFullPath();
	public abstract <T> T accept(ContentContainerVisitor<T> visitor);
}
