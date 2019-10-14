package analysis.detector;

import java.io.IOException;

import analysis.Metric;
import analysis.storage.PrimitiveIntMap;

/**
 * Created by Nik on 01-12-2015
 */
public class DataClassDecorDetector extends Detector {

	private final static String ACCESS = "ACCESS";

	public DataClassDecorDetector() throws IOException {
		super();
	}

	@Override
	public void addDataStores() throws IOException {
		this.addDataStore(ACCESS, new PrimitiveIntMap(this.getDataStoreFilePath(ACCESS)));
	}

	@Override
	protected Boolean isPreliminarilyDefective(model.Class cls) {
		Integer accessors = cls.accessorCount();
		boolean check = accessors > 0;

		if (check) {
			this.getPrimitiveMapStore(ACCESS).add(cls.getFullPath(), accessors);
		}

		return check;
	}

	@Override
	protected Boolean confirmDefect(String fullPath, String projectPath) {
		return this.metrics.isExtremeOutlier(Metric.CLASS_ACCESSORS, this.getPrimitiveMapStore(ACCESS).get(fullPath));
	}

	@Override
	protected String getName() {
		return "Data Class (DECOR)";
	}
}
