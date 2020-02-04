package model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import util.DebuggingLogger;

/**
 * Model for project contains modules. 
 * Created by Nik on 03-08-2015
 */
public class Project implements Unlinkable, Serializable {

	private static final long serialVersionUID = -2643092858223935288L;
	private final Map<String, Module> modules;
	private final File folder;
	private boolean processed = false;

	public Project(File folder) {
		this.folder = folder;
		this.modules = new HashMap<>();
	}

	public File getFolder() {
		return this.folder;
	}

	public String getName() {
		return this.folder.getName();
	}

	public String getPath() {
		return this.folder.getAbsolutePath();
	}

	public void addModule(Module m) {
		String modulePath = m.getFilePath();
		this.modules.put(modulePath, m);
	}

	public boolean hasModule(String modulePath) {
		return this.modules.containsKey(modulePath);
	}

	public Module getModule(String modulePath) {
		assert (this.modules.containsKey(modulePath));

		return this.modules.get(modulePath);
	}

	public Set<Module> getModules() {
		return this.modules.values().stream().collect(Collectors.toSet());
	}

	public void processed() {
		this.processed = true;
	}
	
	/**
	 * method to allow the lovely Garbage Collector to do its job
	 */
	public void unlink() {
		this.modules.values().forEach(Module::unlink);
		this.modules.clear();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Project)) {
			return false;
		}

		Project project = (Project) o;

		return this.getFolder().equals(project.getFolder());
	}

	@Override 
	public void finalize() throws IOException {
		DebuggingLogger.getInstance().debug("Project: " + this.getName() + " cleaned by GC.");
	}
}

