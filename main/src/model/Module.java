package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Model for Python modules Created by Nik on 21-07-2015
 */
public class Module extends ContentContainer {

	private final Map<String, Class> classImports;
	private final Map<String, Module> moduleImports;
	private final Map<String, String> aliases;

	private final String filePath;
	private final String error;

	public Module(String name, Integer loc, String filePath, String error) {
		super(name, loc);

		this.filePath = filePath;
		this.error = error;

		this.classImports = new HashMap<>();
		this.moduleImports = new HashMap<>();
		this.aliases = new HashMap<>(); 
	}

	public void addImport(Module m, String name) {
		this.moduleImports.put(name, m);
	}

	public void addImport(Class c, String name) {
		this.classImports.put(name, c);
	}

	public void resolveInheritance() {
		Scope scope = this.buildScope();
		this.definedClasses.values().forEach(c -> c.resolveInheritance(scope));
	}

	public void resolveInheritedItems() {
		this.definedClasses.values().forEach(Class::copyParentVars);
	}

	public void resolveDependencies() {
		Scope scope = this.buildScope();
		this.getChildren().forEach(c -> c.resolveDependencies(scope));
	}

	private Scope buildScope() {
		Scope scope = new Scope();
		scope.addToScope("", this, true);
		for (String clsAlias : this.classImports.keySet()) {
			scope.addClassToScope("", clsAlias, this.classImports.get(clsAlias));
		}
		for (String moduleAlias : this.moduleImports.keySet()) {
			scope.addToScope(moduleAlias, this.moduleImports.get(moduleAlias), false);
		}
		return scope;
	}

	public boolean containsClass(String name) {
		return this.getDefinedClassesInclSubclassesByName().containsKey(name);
	}

	public Class getClass(String name) {
		assert (this.getDefinedClassesInclSubclassesByName().containsKey(name));

		return this.getDefinedClassesInclSubclassesByName().get(name);
	}

	public String getFilePath() {
		return this.filePath;
	}

	public boolean hasError() {
		return !this.error.equals("");
	}

	public String getError() {
		return this.error;
	}

	@Override
	public void unlink() {
		super.unlink();
		this.classImports.clear();
		this.moduleImports.clear();
	}

	@Override
	public void resolveDependencies(Scope scope) {
	}

	@Override
	public boolean isInParentLine(ContentContainer container) {
		return this.equals(container);
	}

	@Override
	public String getFullPath() {
		return this.filePath;
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
		if (!(o instanceof Module)) {
			return false;
		}

		Module module = (Module) o;

		return this.getFilePath().equals(module.getFilePath());

	}

	@Override
	public int hashCode() {
		return this.getFilePath().hashCode();
	}

	public final Map<String, Class> getClassImports() {
		return classImports;
	}

	public final Map<String, Module> getModuleImports() {
		return moduleImports;
	}

	public void addAlias(String alias, String className) {
		this.aliases.put(alias, className);
	}
	
	public String getImportAlias(String alias) {
		return this.aliases.get(alias);
	}

}
