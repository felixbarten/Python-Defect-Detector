package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nik on 06-05-2015
 */
public class FileHelper {

	public static final String PYTHON_EXTENSION = ".py";

	public static void createLocation(String path) {
		File file = new File(path);
		if (!file.isDirectory()) {
			createLocation(file.getParent());
		}
		if (file.isDirectory() && !file.exists()) {
			createLocation(file.getParent());
			file.mkdir();
		}
	}
	
	/**
	 * Creates files in a date subdirectory when enabled. 
	 * @param path
	 * @param useDateSubDirs
	 */
	public static void createLocation(String path, Boolean useDateSubDirs) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(now);
		
		File file;
		if (useDateSubDirs) {
			file = new File(path + "/" + date);
			file.mkdirs();
		}	else {
			file = new File(path);
		}
		
		if (!file.isDirectory()) {
			createLocation(file.getParent());
		}
		if (file.isDirectory() && !file.exists()) {
			createLocation(file.getParent());
			file.mkdir();
		}
	}

	/**
	 * Creates a datetime stamped file name
	 * @param fileName
	 * @param extension
	 * @return String filename
	 */
	public static String stampedFileName(String fileName, String extension) {
		Date now = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String datetime = timeFormat.format(now);
		return datetime + "_" + fileName + "." + extension;
	}

	/**
	 * Creates time stamped filenames in a date subdirectory.
	 * @param directory
	 * @param fileName
	 * @param extension
	 * @return
	 */
	public static String stampedFileName(String directory, String fileName, String extension) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(now);
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH-mm-SSS");
		String time = timeFormat.format(now);
		createDateDir(directory + "/" + date + "/");
		return directory + "/" + date + "/" + time + "_" + fileName + "." + extension;
	}
	
	private static void createDateDir(String path) {
		File file = new File(path);
		if(!file.exists() && file.isDirectory()) {
			file.mkdir();
		}
	}

	public static List<String> getPythonFilePaths(List<String> paths) {
		return paths.stream()
				.filter(FileHelper::isPythonFile)
				.collect(Collectors.toList());
	}

	public static List<String> getPythonFilePaths(File folder) {
		return FileHelper.getFilePaths(folder)
				.stream()
				.filter(FileHelper::isPythonFile)
				.collect(Collectors.toList());
	}

	public static List<File> getSubfolders(File folder) {
		List<File> subfolders = new ArrayList<>();
		for (File f : folder.listFiles()) {
			if (f.isDirectory()) {
				subfolders.add(f);
			}
		}
		return subfolders;
	}

	private static List<String> getFilePaths(File folder) {
		List<String> fileNames = new ArrayList<>();

		for (File f : folder.listFiles()) {
			if (f.isFile()) {
				fileNames.add(f.getAbsolutePath());
			}
			else if (f.isDirectory()) {
				fileNames.addAll(FileHelper.getFilePaths(f));
			}
		}

		return fileNames;
	}

	private static boolean isPythonFile(String filePath) {
		return filePath.endsWith(PYTHON_EXTENSION);
	}
}
