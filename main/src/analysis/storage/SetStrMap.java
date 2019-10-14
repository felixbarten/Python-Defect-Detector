package analysis.storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import util.StringHelper;

/**
 * Created by Nik on 28-11-2015
 */
public class SetStrMap extends Map<Set<String>> {

	private PrintStream valueStream;
	
	public SetStrMap(String type) throws IOException {
		super(type);
	}

	public void loadValues(String type) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(type));

		String line = br.readLine();
		while (line != null) {
			List<String> parts = StringHelper.explode(line, DELIMITER);
			String key = parts.get(0);
			if (!this.map.containsKey(key)) {
				this.map.put(key, new HashSet<>());
			}
			this.map.get(key).add(parts.get(1));
			line = br.readLine();
		}
	}
	
	@Override
	public void deserialize(BufferedReader dataReader) throws IOException {
		this.map = new HashMap<>();

		String line = dataReader.readLine();
		while (line != null) {
			List<String> parts = StringHelper.explode(line, DELIMITER);
			String key = parts.get(0);
			if (!this.map.containsKey(key)) {
				this.map.put(key, new HashSet<>());
			}
			this.map.get(key).add(parts.get(1));
			line = dataReader.readLine();
		}
	}
}
