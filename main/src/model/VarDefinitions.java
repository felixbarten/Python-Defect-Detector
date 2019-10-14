package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class stores the Variable instances assigned to a class or method. 
 * Created by Nik on 02-11-2015
 */
public class VarDefinitions implements Unlinkable {

	/**
	 * To facilitate the addition of variables in diffent scopes such as class and instance. The datatype is a map of sets of Variables. 
	 */
	private final Map<String, Set<Variable>> vars;

	public VarDefinitions() {
		this.vars = new HashMap<>();
	}

	//overload
	public void add(Variable var) {
		this.add(var.getName(), var);
	}
	
	//overload
	public void add(String alias, Variable var) {
		this.add(alias, var, false);
	}

	// what is unrestricted? The name or if it's already in the map????
	/**
	 * 
	 * @param var
	 */
	public void addUnrestricted(Variable var) {
		this.addUnrestricted(var.getName(), var);
	}

	/**
	 * 
	 * @param alias
	 * @param var
	 */
	public void addUnrestricted(String alias, Variable var) {
		this.add(alias, var, true);
	}

	/**
	 * 
	 * @param definitions
	 */
	public void addAllEnforceRestriction(VarDefinitions definitions) {
		this.removeVarsWithSameNameAndType(definitions);
		for (String varName : definitions.vars.keySet()) {
			for (Variable var : definitions.vars.get(varName)) {
				this.addUnrestricted(varName, var);
			}
		}
	}

	/**
	 * Remove overriden var duplicates 
	 * @param definitions
	 */
	private void removeVarsWithSameNameAndType(VarDefinitions definitions) {
		for (String name : this.vars.keySet()) {
			Set<Variable> nameVars = new HashSet<>();
			for (Variable v : this.vars.get(name)) {
				if (!this.containsVarOfType(definitions.vars, name, v.getVarType())) {
					nameVars.add(v);
				}
			}
			this.vars.put(name, nameVars);
		}
	}

	/**
	 * Loops through another map and adds all the contained variables to the current map. 
	 * @param definitions
	 */
	public void addAllUnrestricted(VarDefinitions definitions) {
		for (String name : definitions.vars.keySet()) {
			for (Variable v : definitions.vars.get(name)) {
				this.addUnrestricted(name, v);
			}
		}
	}

	/**
	 * Returns the Variable instances as a HashSet
	 * @return hashset of vars. 
	 */
	public Set<Variable> getAsSet() {
		Set<Variable> defVars = new HashSet<>();
		this.vars.values().forEach(defVars::addAll);
		return defVars;
	}
	
	public Map<String, Set<Variable>> getVars() {
		return vars;
	}

	/**
	 * Returns a filtered set of Type varType
	 * @param varType Type to be returned.
	 * @return HashSet of Variables with type varType. 
	 */
	public Set<Variable> getAsSetOfType(VarType varType) {
		return this.getAsSet().stream()
				.filter(var -> var.getVarType().equals(varType))
				.collect(Collectors.toSet());
	}

	public Set<String> getNames() {
		return this.vars.keySet();
	}

	/**
	 * Returns set with vars with a certain name. 
	 * @param name name to match vars on
	 * @return HashSet with vars with a name like name.
	 */
	public Set<Variable> getVarsWithName(String name) {
		assert this.vars.containsKey(name);
		return this.vars.get(name);
	}

	@Override
	public void unlink() {
		for (Set<Variable> vars : this.vars.values()) {
			vars.forEach(Variable::unlink);
		}
		this.vars.clear();
	}

	/**
	 * Adds a variable to the Map. 
	 * @param alias 
	 * @param var
	 * @param unrestricted
	 */
	private void add(String alias, Variable var, boolean unrestricted) {
		// create key if it doesn't exist yet. 
		if (!this.vars.containsKey(alias)) {
			this.vars.put(alias, new HashSet<>());
		}
		// if unrestricted = true OR a definedVar of type of var does not exist  add it to the Set<Variable> 
		if (unrestricted || !this.definedVarOfTypeExists(alias, var.getVarType())) {
			this.vars.get(alias).add(var);
		}
	}

	private boolean definedVarOfTypeExists(String name, VarType varType) {
		return this.containsVarOfType(this.vars, name, varType);
	}

	/**
	 * Loop through map to check if the subsets contain a variable of type with name like name.
	 * @param data Map to check 
	 * @param name name of variable
	 * @param varType type of variable 
	 * @return
	 */
	private boolean containsVarOfType(Map<String, Set<Variable>> data, String name, VarType varType) {
		if (data.containsKey(name)) {
			Set<Variable> sameNameVars = data.get(name);
			for (Variable sameNameVar : sameNameVars) {
				if (sameNameVar.getVarType() == varType) {
					return true;
				}
			}
		}
		return false;
	}
}
