package tests;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Class;
import model.ModelBuilder;
import model.Project;
import model.SuperCall;
import process.File2Tree;
import util.FileHelper;


/**
 * Created by Nik on 08-07-2015
 */
public class TestHelper {

	public static Map<String, Class> getClasses(String fileName) {
		Project project = TestHelper.getProject(fileName);
		return TestHelper.getClasses(project);
	}

	public static Map<String, Class> getClasses(Project project) {
		Map<String, Class> classMap = new HashMap<>();
		project.getModules().forEach(m -> classMap.putAll(m.getDefinedClassesInclSubclassesByName()));
		return classMap;
	}
	
	public static Map<String, SuperCall> getSuperStatements(String fileName) {
		ModelBuilder mb = TestHelper.getModelBuilder(fileName);
		Map<String, SuperCall> statementMap = new HashMap<>();

		mb.getStatements();
		return null;
	}

	public static Project getProject(String fileName) {
		File file = new File(fileName);
		String projectFolder = file.isDirectory() ? file.getAbsolutePath() : file.getParent();

		List<String> filePaths = new ArrayList<>();
		if (file.isDirectory()) {
			filePaths.addAll(FileHelper.getPythonFilePaths(file));
		}
		else {
			filePaths.add(fileName);
		}

		return TestHelper.getProject(projectFolder, filePaths);
	}


	private static Project getProject(String parent, List<String> fileNames) {
		Map<String, ast.Module> trees = File2Tree.getAsts(fileNames);
		ModelBuilder modelBuilder = new ModelBuilder(new File(parent), trees.values());
		return modelBuilder.getProject();
	}
	
	public static ModelBuilder getModelBuilder(String fileName) {
		File file = new File(fileName);
		String projectFolder = file.isDirectory() ? file.getAbsolutePath() : file.getParent();

		List<String> filePaths = new ArrayList<>();
		if (file.isDirectory()) {
			filePaths.addAll(FileHelper.getPythonFilePaths(file));
		}
		else {
			filePaths.add(fileName);
		}

		return TestHelper.getModelBuilder(projectFolder, filePaths);
	}


	private static ModelBuilder getModelBuilder(String parent, List<String> fileNames) {
		Map<String, ast.Module> trees = File2Tree.getAsts(fileNames);
		ModelBuilder modelBuilder = new ModelBuilder(new File(parent), trees.values());
		return modelBuilder;
	}
	
}
