package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Nik on 30-06-2015
 */
public class Class extends ContentContainer {

	private ContentContainer parent;
	private final List<String> superclassNames;
	private final Map<String, Class> superclasses;
	private final Project project; 
	private List<Subroutine> subroutines;
	
	private final VarDefinitions inheritedVars;
	private Integer complexity;
	private float WMC;
	private float AMW;
	
	/**
	 * Class model constructor. 
	 * Complexity value is initialized lazily as defined subroutines get inserted after object creation.
	 * @param name
	 * @param loc
	 * @param parent
	 * @param superclassNames
	 * @param project 
	 */
	public Class(String name, Integer loc, ContentContainer parent, List<String> superclassNames, Project project) {
		super(name, loc);
		this.parent = parent;
		this.superclassNames = superclassNames;
		this.superclasses = new HashMap<>();
		this.project = project;
		this.subroutines = new LinkedList<Subroutine>();

		this.inheritedVars = new VarDefinitions();
	}

	public Integer getLcom() {
		return this.calculateLcom();
	}

	public Map<String, Class> getSuperclasses() {
		return this.superclasses;
	}

	public Set<Class> getParentsSet() {
		return this.superclasses.values().stream().collect(Collectors.toSet());
	}

	@Override
	public VarDefinitions getDefinedVarsInclParentsVars() {
		VarDefinitions vars = new VarDefinitions();
		this.superclasses.values().forEach(p -> vars.addAllUnrestricted(p.getDefinedVarsInclParentsVars()));
		vars.addAllEnforceRestriction(this.inheritedVars);
		vars.addAllEnforceRestriction(this.definedVars);
		return vars;
	}

	public List<String> getSuperclassNames() {
		return this.superclassNames;
	}

	public Integer superclassCount() {
		return this.superclassNames.size();
	}

	public Integer accessorCount() {
		Long l = this.definedSubroutines.values().stream().filter(Subroutine::isAccessor).count();
		return l.intValue();
	}

	private Boolean privateFieldsWithOnePublicMethod() {
		return //this.privateVariablesCount() > 10 &&
				this.getDefinedSubroutinesSet().stream().filter(s -> !s.isPrivate()).count() == 1;
	}

	private Integer calculateLcom() {
		int intersectDifference = 0; // = not intersecting amount - intersecting amount
		List<Subroutine> ms = this.definedSubroutines.values().stream().collect(Collectors.toList());
		for (int i = 0; i < ms.size(); i++) {
			for (int j = i + 1; j > i && j < ms.size(); j++) {
				intersectDifference += this.lcomIntersectDifference(ms.get(i), ms.get(j));
			}
		}
		return Math.max(0, intersectDifference);
	}

	private Integer lcomIntersectDifference(Subroutine a, Subroutine b) {
		return a.hasVariableIntersection(b) ? -1 : 1;
	}

	/**
	 * Resolve inheritance by looping through superclass names and see if they can be found in the scope. If not they are discarded. 
	 */
	@Override
	public void resolveInheritance(Scope scope) {
		super.resolveInheritance(scope);
		// loop through superclassnames
		for (String clsName : this.superclassNames) {
			// if superclsname is defined in the scope (how large is the scope?) 
			// Why does the scope not contain the right files? 
			if (scope.definedClasses.containsKey(clsName)) {
				//retrieve cls. object
				Class parentCls = scope.definedClasses.get(clsName);
				// check if parent cls is in inheritance line. 
				if (!parentCls.isInInheritanceLine(this)) {
					// add to maps. 
					this.superclasses.put(clsName, parentCls);
					this.referencedClasses.put(clsName, parentCls);
				}
			}
		}
	}

	@Override
	public void copyParentVars() {
		super.copyParentVars();
		// loop through parents 
		for (Class parent : this.superclasses.values()) {
			VarDefinitions parentVars = parent.getParentVars();

			for (String varName : parentVars.getNames()) {
				this.addInheritedVars(parentVars, varName);
			}
		}
	}

	private void addInheritedVars(VarDefinitions parentVars, String varName) {
		for (Variable var : parentVars.getVarsWithName(varName)) {
			Variable copy = new Variable(var.getName(), this, var.getVarType());
			this.inheritedVars.addUnrestricted(varName, copy);
		}
	}

	private VarDefinitions getParentVars() {
		VarDefinitions vars = new VarDefinitions();
		for (Class parent : this.superclasses.values()) {
			vars.addAllUnrestricted(parent.getParentVars());
		}
		vars.addAllUnrestricted(this.definedVars);
		return vars;
	}

	/**
	 * If the container matches this container it's in the same inheritance line. Else loop through superclasses and see if any of the superclasses match the container.
	 * If that fails it's not in the inheritance line. 
	 * @param container
	 * @return
	 */
	private boolean isInInheritanceLine(ContentContainer container) {
		if (this.equals(container)) {
			return true;
		}
		for (Class parent : this.superclasses.values()) {
			if (parent.isInInheritanceLine(container)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void unlink() {
		super.unlink();
		this.parent = null;
		this.superclasses.clear();
		this.inheritedVars.unlink();
	}

	@Override
	public boolean isInParentLine(ContentContainer container) {
		if (this.equals(container)) {
			return true;
		}
		return this.parent.isInParentLine(container);
	}

	@Override
	public String getFullPath() {
		return this.parent.getFullPath() + " > class " + this.name;
	}

	@Override
	public <T> T accept(ContentContainerVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Class)) {
			return false;
		}

		Class aClass = (Class) o;

		if (!this.getName().equals(aClass.getName())) {
			return false;
		}
		return this.parent.equals(aClass.parent);

	}

	@Override
	public int hashCode() {
		int result = this.getName().hashCode();
		result = 31 * result + this.parent.hashCode();
		return result;
	}
	
	/**
	 * Returns a set of private modifier variables from parent
	 * @return
	 */
	public VarDefinitions getPrivateParentVars() {
		VarDefinitions privVars = new VarDefinitions();
		
		for( Variable v : inheritedVars.getAsSet()) {
			if (v.isPrivate()) privVars.add(v);
		}
		
		return privVars;
	}
	
	/**
	 * Returns a set of protected modifier variables from parent
	 * @return
	 */
	public VarDefinitions getProtectedParentVars() {
		VarDefinitions protVars = new VarDefinitions();
		
		for( Variable v : inheritedVars.getAsSet()) {
			if (v.isProtected()) protVars.add(v);
		}
		
		return protVars;
	}
	
	/**
	 * Returns list of protected members; 
	 * @return VarDefinitions protected members.
	 */
	public VarDefinitions getProtectedVars() {
		VarDefinitions protVars = new VarDefinitions();
		
		for( Variable v : definedVars.getAsSet()) {
			if (v.isProtected()) protVars.add(v);
		}
		
		return protVars;
	}
	
	/**
	 * Returns list of private members; 
	 * @return VarDefinitions protected members.
	 */
	public VarDefinitions getPrivateVars() {
		VarDefinitions privVars = new VarDefinitions();
		
		for( Variable v : definedVars.getAsSet()) {
			if (v.isPrivate()) privVars.add(v);
		}
		
		return privVars;
	}
	
	public Project getProject() {
		return project;
	}

	
	/**
	 * Get class Cyclomatic Complexity.
	 * @return Cyclomatic Complexity
	 */
	public Integer getCC() {
		if (complexity == null) {
			complexity = calculateCC();
		}
		return complexity;
	}
	
	public float getAMW() {
		if(definedSubroutines.size() > 0) {
			AMW  =  getWMC() / definedSubroutines.size();
		}
		return AMW;
	}
	
	public float getWMC() {
		return getCC();
	}
	
	public Set<String> getSubroutineNames() {
		Set<String> names = new HashSet<String>();
		for (Subroutine s : definedSubroutines.values()) {
			names.add(s.getName());
		}
		return names; 
	}
	
	public Set<String> getVariableNames() {
		return definedVars.getNames();
	}

	private Integer calculateCC() {
		int cc = 0; 
		List<Subroutine> ms = this.definedSubroutines.values().stream().collect(Collectors.toList());
		for (Subroutine s : ms) {
			cc += s.getCC();
		}
		return cc;
	}
	
	public void addSubroutine(Subroutine m) {
		if(!subroutines.contains(m)) {
			subroutines.add(m);
		}
	}
	
	/**
	 * Returns the NOM metric (number of methods per class) 
	 * @return int NOM
	 */
	public Integer getNOM() {
		return this.definedSubroutines.size();
	}

	public String getShortName() {
		String longName = this.name;
		String[] explode = longName.split(">");
		return explode.length > 1 ? explode[1]: longName;
	}

	public Set<String> getReferencedVariableNames() {
		Set<String> paths = new HashSet<>();
		getReferencedVariablesSet().stream().forEach((m) -> paths.add(m.getName()));
		return paths;
	}
		
	public Set<String> getReferencedClassPaths() {
		Set<String> paths = new HashSet<>();
		getReferencedClassesSet().stream().forEach((m) -> paths.add(m.getFullPath()));
		return paths;
	}
	
	public Set<String> getReferencedClassNames() {
		Set<String> paths = new HashSet<>();
		getReferencedClassesSet().stream().forEach((m) -> paths.add(m.getName()));
		return paths;
	}
	
	public Set<String> getReferencedMethodsNames() {
		return getCalledSubroutineNames();
	}

	public Set<String> getInheritedVarNames() {
		Set<String> inheritedVarNames = new HashSet<>();
		for (Variable v : inheritedVars.getAsSet()) {
			inheritedVarNames.add(v.getName());
		}
		return inheritedVarNames;
	}

	public model.Module getParent() {
		if(parent instanceof Module) {
			return (model.Module) parent; 
		}
		return null;
	}
	
}
