package analysis.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.StringHelper;

/**
 * Created by Nik on 26-11-2015
 */
public abstract class Map<T> {

	protected static final String DELIMITER = ",";

	protected java.util.Map<String, T> map;

	private final Boolean existing;

	private final String filePath;
	private PrintStream stream;
	private BufferedReader reader;

	protected String currentKey;
	protected String currentVal;

	/**
	 * Constructor for Map objects. If file already exists don't create a new one.
	 * @param filePath
	 * @throws IOException
	 */
	public Map(String filePath) throws IOException {
		this.filePath = filePath;
		File file = new File(this.filePath);
		this.existing = file.exists();
	
		this.stream = new PrintStream(new FileOutputStream(this.filePath, true));
		
	}

	public void add(String key, Integer element) {
		this.add(key, element.toString());
	}
	
	public void add(String key, Float value) {
		this.add(key, value.toString());
	}

	public void add(String key, String element) {
			if (this.stream == null) {
				throw new IllegalStateException("The stream has not been initialized");
			}
			String line = key + DELIMITER + element;
			this.stream.println(line);
		
	}

	public void add(String key, Set<String> elements) {
			if (this.stream == null) {
				throw new IllegalStateException("The stream has not been initialized");
			}
			for( String elem : elements) {
				String line = key + DELIMITER + elem;
				this.stream.println(line);
			}
		
	}
	
	public void add(String key, List<String> elements) {
			if (this.stream == null) {
				throw new IllegalStateException("The stream has not been initialized");
			}
			Set<String> elementsSet = new HashSet<String>(elements);
			this.add(key, elementsSet);
		
	}
	
	
	public Set<String> keySet() {
		return this.map.keySet();
	}

	public T get(String key) {
		if (map == null) 
			return null;
		return this.map.get(key);
	}

	/**
	 * Deserialize is a weird name as data is stored in cleartext. 
	 * @throws IOException
	 */
	public void deserialize() throws IOException, NumberFormatException {
		// read all data
		this.deserialize(true);
	}

	/**
	 * This method closes the printstream if it doesn't exist. 
	 * Opens a new reader for the filepath and if the argument is true reads all data into the map. 
	 * If it's false only the reader is initiated.
	 * 
	 * @param Boolean readData. If true reads all data from storage map. 
	 * @throws IOException
	 */
	public void deserialize(Boolean readData) throws IOException {
		this.stream.close();
		

		this.reader = new BufferedReader(new FileReader(this.filePath));
		if (readData) {
			this.deserialize(reader);
			reader.close();
		}
	}

	public String getNextKey() throws IOException {
		String line = this.reader.readLine();
		if (line == null) {
			this.currentKey = null;
			this.currentVal = null;
		}
		else {
			List<String> parts = StringHelper.explode(line, DELIMITER);
			this.currentKey = parts.get(0);
			this.currentVal = parts.get(1);
		}
		return this.currentKey;
	}

	public String getNextVal() {
		return this.currentVal;
	}
	
	public String getFilePath() {
		return this.filePath;
	}

	public void clean() {
		this.map = null;
	}

	protected abstract void deserialize(BufferedReader dataReader) throws IOException;
}
