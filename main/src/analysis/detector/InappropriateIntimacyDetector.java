package analysis.detector;

import java.io.IOException;

import analysis.Metric;
import analysis.storage.PrimitiveIntMap;
import model.Subroutine;

/**
 * Created by felixb on 9-4-2018
 */
public class InappropriateIntimacyDetector extends Detector {

	private final static String PARAMS = "PARAMS";

	public InappropriateIntimacyDetector() throws IOException {
		super();
	}

	@Override
	public void addDataStores() throws IOException {
		this.addDataStore(PARAMS, new PrimitiveIntMap(this.getDataStoreFilePath(PARAMS)));
	}

	@Override
	protected Boolean isPreliminarilyDefective(Subroutine subroutine) {
		this.getPrimitiveMapStore(PARAMS).add(subroutine.getFullPath(), subroutine.paramCount());
		return true;
	}

	@Override
	protected Boolean confirmDefect(String fullPath) {
		return this.metrics.isExtremeOutlier(Metric.SUBROUTINE_PARAMS, this.getPrimitiveMapStore(PARAMS).get(fullPath));
	}

	@Override
	protected String getName() {
		return "Inappropriate Intimacy";
	}
}
