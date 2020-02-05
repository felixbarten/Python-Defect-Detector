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
			try {
				List<String> parts = StringHelper.explode(line, DELIMITER);
				if (parts.size() == 2) {
					this.map.put(parts.get(0), Float.valueOf(parts.get(1)));
					
				} else if (parts.size() > 2) {
					// DELIMITER found in file path. 
					int size = parts.size(); 
					Float tmp = Float.valueOf(parts.get((size - 1)));
					if (tmp != null) {
						String reassembledKey = "";
						parts.remove(size - 1);
						reassembledKey = String.join(",", parts);
						this.map.put(reassembledKey, tmp);
					}
				}
				line = dataReader.readLine();
			} catch (NumberFormatException e) {
				e.printStackTrace();
				e.printStackTrace(System.out);
				System.out.println("Number formatting failed for line: " + line);
				line = dataReader.readLine();
			}
		}
	}
}
