package analysis.storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import util.StringHelper;

/**
 * Created by Nik on 26-11-2015
 */
public class PrimitiveIntMap extends Map<Integer> {

	public PrimitiveIntMap(String type) throws IOException {
		super(type);
	}

	@Override
	public void deserialize(BufferedReader dataReader) throws IOException {
		this.map = new HashMap<>();

		String line = dataReader.readLine();
		while (line != null) {
			List<String> parts = StringHelper.explode(line, DELIMITER);
			this.map.put(parts.get(0), Math.round(Float.parseFloat(parts.get(1))));
			line = dataReader.readLine();
		}
	}
}
