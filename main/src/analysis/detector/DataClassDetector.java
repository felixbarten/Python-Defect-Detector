package analysis.detector;

import java.io.IOException;

import analysis.Metric;
import analysis.storage.PrimitiveIntMap;
import model.Class;
import model.Variable;

/**
 * Created by Nik on 10-11-2015
 */
public class DataClassDetector extends Detector {

	private final static String ACCESS = "ACCESS";
	private final static String PUBF = "PUBF";

	public DataClassDetector() throws IOException {
		super();
	}

	@Override
	public void addDataStores() throws IOException {
		this.addDataStore(ACCESS, new PrimitiveIntMap(this.getDataStoreFilePath(ACCESS)));
		this.addDataStore(PUBF, new PrimitiveIntMap(this.getDataStoreFilePath(PUBF)));
	}

	@Override
	protected Boolean isPreliminarilyDefective(Class cls) {
		Integer accessors = cls.accessorCount();
		Long publicFields = cls.getDefinedVarsInclParentsVars().getAsSet().stream().filter(Variable::isPublic).count();
		boolean check = accessors > 0 || publicFields > 0;

		if (check) {
			this.getPrimitiveMapStore(ACCESS).add(cls.getFullPath(), accessors);
			this.getPrimitiveMapStore(PUBF).add(cls.getFullPath(), publicFields.intValue());
		}

		return check;
	}

	@Override
	protected Boolean confirmDefect(String fullPath) {
		return this.metrics.isExtremeOutlier(Metric.CLASS_ACCESSORS, this.getPrimitiveMapStore(ACCESS).get(fullPath))
				|| this.metrics.isExtremeOutlier(Metric.CLASS_PUBLIC_FIELDS, this.getPrimitiveMapStore(PUBF).get(fullPath));
	}

	@Override
	protected String getName() {
		return "Data Class";
	}
}
