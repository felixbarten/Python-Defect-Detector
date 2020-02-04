package analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import util.FileHelper;
import util.Settings;

/**
 * Modified IntMetricVals. 
 * @author felix
 *
 */
public class FloatMetricVals {
	private final static String METRIC_VALS_EXTENSION = "metrics";

	private final boolean existing;

	private boolean sorted;
	private boolean insufficientValues;

	private final String valuesFileName;

	private PrintStream valueStream;
	private List<Float> values;
	private final Map<Integer, Float> percentageLimits;

	private Float sum;
	private Integer amountOfValues;
	private Double average;
	private Double median;
	private Double standardDeviation;
	private Double q1;
	private Double q3;

	public FloatMetricVals(String type) throws IOException {
		this.valuesFileName = getValuesFileName(type);

		File file = new File(this.valuesFileName);
		this.existing = file.exists();
		if (!this.existing) {
			try {
				this.valueStream = new PrintStream(new FileOutputStream(this.valuesFileName));
			}
			catch (FileNotFoundException e) {
				System.err.println("Cannot create metrics file. Switched to using a list for storage.");
				e.printStackTrace();
			}
		}
		this.sorted = false;
		this.insufficientValues = false;
		this.values = new ArrayList<>();
		this.percentageLimits = new HashMap<>();
	}

	public void add(Float item) {
		if (!this.existing) {
			if (this.sorted) {
				throw new IllegalStateException();
			}
			if (this.valueStream != null) {
				this.valueStream.println(item);
				this.values.add(item);
			}
			else {
				this.values.add(item);
			}
		}
	}

	public boolean isInTop(Integer percentage, Integer value) {
		if (!this.sorted) {
			throw new IllegalStateException();
		}
		if (this.insufficientValues) {
			return false;
		}
		return value >= this.percentageLimits.get(100 - percentage);
	}

	public boolean isInBottom(Integer percentage, Integer value) {
		if (!this.sorted) {
			throw new IllegalStateException();
		}
		if (this.insufficientValues) {
			return false;
		}
		return value <= this.percentageLimits.get(percentage);
	}

	public boolean isMildOutlier(Integer val) {
		return this.isOutlier(val, 1.5);
	}

	public boolean isExtremeOutlier(Integer val) {
		return this.isOutlier(val, 3.0);
	}

	private boolean isOutlier(Integer val, Double iqrMultiplicand) {
		if (!this.sorted) {
			throw new IllegalStateException();
		}
		if (this.insufficientValues) {
			return false;
		}
		Double iqr = this.q3 - this.q1;
		return val < this.q1 - iqrMultiplicand * iqr || val > this.q3 + iqrMultiplicand * iqr;
	}
	
	/**
	 * Calculate the average for the integers in data set
	 * @return int average 
	 */
	public int average() {
		return (int) Math.round(average);
	}

	public void sortAndCalculateStats(Set<Integer> requiredPercentages) throws IOException {
		if (this.sorted) {
			throw new IllegalStateException();
		}
		this.sorted = true;

		if (this.valueStream != null || existing) {
			this.loadValuesAndHandleFile();
		}
		Collections.sort(this.values);

		if (this.values.size() == 0) {
			this.insufficientValues = true;
			return;
		}

		this.amountOfValues = this.values.size();
		this.sum = (float) 0;
		this.values.forEach(v -> this.sum += v);

		this.average = this.sum.doubleValue() / this.amountOfValues;
		this.median = this.median(this.values);
		this.standardDeviation = this.standardDeviation();

		if (this.amountOfValues == 1) {
			this.q1 = this.values.get(0).doubleValue();
			this.q3 = this.values.get(0).doubleValue();
		}
		else if (this.amountOfValues == 2) {
			this.q1 = this.values.get(0).doubleValue();
			this.q3 = this.values.get(1).doubleValue();
		}
		else {
			boolean even = this.amountOfValues % 2 == 0;
			Integer q1Index = even ? (this.amountOfValues - 2) / 2 : this.amountOfValues / 2;
			Integer q3Index = even ? q1Index + 2 : q1Index + 1;
			q1Index = this.applyBoundaries(q1Index, this.amountOfValues - 1);
			q3Index = this.applyBoundaries(q3Index, this.amountOfValues - 1);

			this.q1 = this.median(this.values.subList(0, q1Index));
			this.q3 = this.median(this.values.subList(q3Index, this.amountOfValues));
		}

		for (Integer percentage : requiredPercentages) {
			this.percentageLimits.put(percentage, this.valueAtXPercent(percentage));
		}
		this.values = Collections.emptyList();
	}

	/**
	 * Load existing values from disk and store them internally. 
	 * @throws IOException
	 */
	private void loadValuesAndHandleFile() throws IOException {
		if (!this.existing) {
			this.valueStream.close();
		}

		BufferedReader br = new BufferedReader(new FileReader(this.valuesFileName));
		this.values = br.lines().map(Float::parseFloat).collect(Collectors.toList());
		br.close();
	}

	private Double median(List<Float> sortedVals) {
		int valSize = sortedVals.size();
		if (valSize % 2 == 0) {
			int i = valSize / 2;
			i = this.applyBoundaries(i, valSize - 2);
			return (sortedVals.get(i).doubleValue() + sortedVals.get(i + 1)) / 2.0;
		}
		int i = (valSize / 2) + 1;
		i = this.applyBoundaries(i, valSize - 1);
		return sortedVals.get(i).doubleValue();
	}

	private Double standardDeviation() {
		Double sumOfIndividualDevSquares = 0.0;
		for (Float value : this.values) {
			sumOfIndividualDevSquares += Math.pow(value - this.average, 2);
		}
		return Math.sqrt(sumOfIndividualDevSquares / this.amountOfValues);
	}

	private Float valueAtXPercent(Integer percentage) {
		Double d = this.amountOfValues / 100.0 * percentage;
		Long l = Math.round(d);
		return this.values.get(l.intValue());
	}

	private Integer applyBoundaries(Integer index, Integer maxSize) {
		index = Math.min(index, maxSize);
		index = Math.max(index, 0);
		return index;
	}
	
	/**
	 * Checks if metrics configuration exists, retrieves filename if it is configured. 
	 * Returns filename for storing/retrieving metrics.
	 * @param String type
	 * @return String filename
	 * @throws IOException
	 */
	private String getValuesFileName(String type) throws IOException {
		Properties metricsConfig = Settings.getMetricsConfig();
		boolean exists = metricsConfig.containsKey(type);
		Properties config = Settings.getConfig();
		
		String folder = config.getProperty("locations.data.output");
		
		String filePath = "";
		if (config.containsKey("locations.data.useDateSubDirs") && config.getProperty("locations.data.useDateSubDirs").equalsIgnoreCase("true")) {
			FileHelper.stampedFileName(folder, type, METRIC_VALS_EXTENSION);
		} else {
			filePath = FileHelper.regularFileName(folder, type, METRIC_VALS_EXTENSION);
		}		
		return exists ? metricsConfig.getProperty(type) : filePath;
	}
}
