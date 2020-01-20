package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import util.FileHelper;
import util.StringHelper;

/**
 * Created by Nik on 11-07-2015
 */
public class Linker {

	private static final String MODULE_DELIMITER = ".";
	private static final String FILE_DELIMITER = "\\";

	private final Project project;

	public Linker(Project project) {
		this.project = project;
	}

	/**
	 * Link all data together. 
	 */
	public void link() {
		// for all modules resolve inheritance. 
		this.project.getModules().forEach(model.Module::resolveInheritance);
		this.project.getModules().forEach(model.Module::resolveInheritedItems);
		this.project.getModules().forEach(model.Module::resolveDependencies);
	}

	public void addModuleImport(String source, String target, String alias) {
		if (!this.project.hasModule(source)) {
			return;
		}
		Module sourceModule = this.project.getModule(source);
		List<String> sourcePaths = this.getSourcePaths(sourceModule.getFilePath());
		for (String sourcePath : sourcePaths) {
			String fullPath = sourcePath + FILE_DELIMITER + this.getFilePath(target);
			String clsName = target;
			
			Boolean added = this.addModuleImport(sourceModule, fullPath, alias, clsName);
			if (added) {
				break;
			}
		}
	}

	public void addImportFrom(String source, String importPath, String target, String alias) {
		assert (this.project.hasModule(source));
		/*
		 * Why is there even an assert here? It doesn't serve a purpose. They will be removed by the compiler unless specified. 
		 * 
		 * If import * from blah then call addImportgAll if not addImportSpecific. 
		 */
		
		if (target.equals("*")) {
			this.addImportAll(source, importPath);
		}
		else {
			this.addImportSpecific(source, importPath, target, alias);
		}
	}

	private void addImportSpecific(String source, String importPath, String className, String alias) {
		Module sourceModule = this.project.getModule(source);
		List<String> sourcePaths = this.getSourcePaths(sourceModule.getFilePath());

		String pathMiddle = StringHelper.swapDelimiter(importPath, MODULE_DELIMITER, FILE_DELIMITER);

		String modulePathEnd = pathMiddle + FILE_DELIMITER + this.getFilePath(className);
		String classPathEnd = pathMiddle + FileHelper.PYTHON_EXTENSION;

		for (String path : sourcePaths) {
			String fullModulePath = path + FILE_DELIMITER + modulePathEnd;
			String fullClassPath = path + FILE_DELIMITER + classPathEnd;

			Boolean added = this.addModuleImport(sourceModule, fullModulePath, alias, className);
			if (added) {
				break;
			}
			added = this.addClassImport(sourceModule, fullClassPath, className, alias);
			if (added) {
				break;
			}
		}
	}

	private void addImportAll(String source, String importPath) {
		Module sourceModule = this.project.getModule(source);
		String path = this.getParentFolder(source);
		path += this.getFilePath(importPath);

		if (this.project.hasModule(path)) {
			Module importedModule = this.project.getModule(path);
			for (model.Class c : importedModule.getDefinedClassesInclSubclassesSet()) {
				sourceModule.addImport(c, c.getName());
			}
		}
	}


	private Boolean addModuleImport(Module source, String path, String alias, String className) {
		if (this.project.hasModule(path)) {
			Module importedModule = this.project.getModule(path);
			source.addImport(importedModule, alias);
			source.addAlias(alias, className);
			return true;
		} else {
			// Module is not contained inside the project. Therefore likely a library. 
			source.addLibraryImport(alias);
		}
		
		return false;
	}


	private List<String> getSourcePaths(String source) {
		String projectFolder = this.project.getPath();

		assert (source.startsWith(projectFolder));

		String sourceFolder = this.getParentFolder(source);

		List<String> paths = new ArrayList<>();
		while (!sourceFolder.equals(projectFolder)) {
			paths.add(sourceFolder);
			sourceFolder = this.getParentFolder(sourceFolder);
		}
		paths.add(projectFolder);

		return paths;
	}


	private Boolean addClassImport(Module source, String importModule, String className, String alias) {
		if (this.project.hasModule(importModule)) {
			Module m = this.project.getModule(importModule);
			if (m.containsClass(className)) {
				source.addImport(m.getClass(className), alias);
				if(className != alias)
					source.addAlias(alias, className);
				return true;
			}
		}
		return false;
	}

	private String getParentFolder(String source) {
		File f = new File(source);
		return f.getParent();
	}

	private String getFilePath(String module) {
		return StringHelper.swapDelimiter(module, MODULE_DELIMITER, FILE_DELIMITER) + FileHelper.PYTHON_EXTENSION;
	}

}