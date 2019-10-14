package analysis.detector;

import java.io.IOException;

import analysis.Metric;
import analysis.storage.PrimitiveIntMap;
import model.Subroutine;

/**
 * Created by Nik on 10-11-2015
 */
public class LongMethodDetector extends Detector {

	private final String LOC = "LOC";

	public LongMethodDetector() throws IOException {
		super();
	}

	@Override
	public void addDataStores() throws IOException {
		this.addDataStore(LOC, new PrimitiveIntMap(this.getDataStoreFilePath(LOC)));
	}

	@Override
	protected Boolean isPreliminarilyDefective(Subroutine subroutine) {
		this.getPrimitiveMapStore(LOC).add(subroutine.getFullPath(), subroutine.getLoc());
		return true;
	}

	@Override
	protected Boolean confirmDefect(String fullPath, String projectPath) {
		return this.metrics.isExtremeOutlier(Metric.SUBROUTINE_LOC, this.getPrimitiveMapStore(LOC).get(fullPath));
	}

	@Override
	protected String getName() {
		return "Long Method";
	}
}
