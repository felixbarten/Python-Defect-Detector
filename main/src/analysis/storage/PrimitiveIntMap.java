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
			try { 
				/* 
				 * some data actually had a comma (the delimiter) in the file name (parts[0]). 
				 * Fix this by checking if the last element of the list is castable. If it is reassemble the key. 
				 */
				List<String> parts = StringHelper.explode(line, DELIMITER);

				if (parts.size() == 2) {
				this.map.put(parts.get(0), Math.round(Float.parseFloat(parts.get(1))));
			} else if (parts.size() > 2) {
				// DELIMITER found in file path. 
				int size = parts.size(); 
				Integer tmp = Integer.valueOf(parts.get((size - 1)));
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
