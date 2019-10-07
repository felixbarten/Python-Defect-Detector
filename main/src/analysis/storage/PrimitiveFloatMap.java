package analysis.storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import util.StringHelper;

/**
 * Float storage map. 
 * @author felix
 *
 */
public class PrimitiveFloatMap extends Map<Float> {

	public PrimitiveFloatMap(String type) throws IOException {
		super(type);
	}

	@Override
	public void deserialize(BufferedReader dataReader) throws IOException {
		this.map = new HashMap<>();

		String line = dataReader.readLine();
		while (line != null) {
			List<String> parts = StringHelper.explode(line, DELIMITER);
			this.map.put(parts.get(0), Float.valueOf(parts.get(1)));
			line = dataReader.readLine();
		}
	}
}
