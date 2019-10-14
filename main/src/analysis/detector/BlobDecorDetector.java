package analysis.detector;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import analysis.Metric;
import analysis.storage.PrimitiveIntMap;
import analysis.storage.SetIntMap;
import model.Class;
import model.Subroutine;
import util.LexicalHelper;

/**
 * Created by Nik on 05-11-2015
 */
public class BlobDecorDetector extends Detector {

	private final static int RAC_COUNT = 3;

	private final static String RAC = "RelAccessors";
	private final static String METVARS = "MetVars";
	private final static String LCOM = "LCOM";

	public BlobDecorDetector() throws IOException {
		super();
	}

	@Override
	protected void addRequiredPercentages() {
		this.addRequiredPercentage(Metric.CLASS_ACCESSORS, 85);
	}

	@Override
	public void addDataStores() throws IOException {
		this.addDataStore(RAC, new SetIntMap(this.getDataStoreFilePath(RAC)));
		this.addDataStore(METVARS, new PrimitiveIntMap(this.getDataStoreFilePath(METVARS)));
		this.addDataStore(LCOM, new PrimitiveIntMap(this.getDataStoreFilePath(LCOM)));
	}

	@Override
	protected Boolean isPreliminarilyDefective(Class cls) {

		Set<Integer> relatedAccessorCounts = cls.getReferencedClassesSet().stream()
				.map(Class::accessorCount)
				.collect(Collectors.toSet());

		boolean seemsDefective = (this.hasControllerName(cls.getName()) || this.hasControllerMethods(cls)) && relatedAccessorCounts.size() >= RAC_COUNT;

		if (seemsDefective) {
			relatedAccessorCounts.forEach(v -> this.getSetMapStore(RAC).add(cls.getFullPath(), v));
			this.getPrimitiveMapStore(METVARS).add(cls.getFullPath(), cls.getDefinedSubroutinesSet().size() + cls.getDefinedVarsInclParentsVars().getAsSet().size());
			this.getPrimitiveMapStore(LCOM).add(cls.getFullPath(), cls.getLcom());
		}

		return seemsDefective;
	}

	@Override
	protected Boolean confirmDefect(String clsFullPath, String projectPath) {
		return (this.isLargeClass(clsFullPath) || this.hasLowCohesion(clsFullPath)) && this.relatedDataClassesCount(clsFullPath) >= RAC_COUNT;
	}

	@Override
	protected String getName() {
		return "Blob (DECOR)";
	}

	private boolean hasControllerMethods(Class cls) {
		for (Subroutine m : cls.getDefinedSubroutinesSet()) {
			if (this.isController(m)) {
				return true;
			}
		}
		return false;
	}

	private boolean isController(Subroutine m) {
		return this.hasControllerName(m.getName());
	}

	private boolean hasControllerName(String name) {
		return LexicalHelper.isControllerName(name);
	}

	private boolean isLargeClass(String clsFullPath) {
		return this.metrics.isMildOutlier(Metric.CLASS_METHODS_AND_VARS, this.getPrimitiveMapStore(METVARS).get(clsFullPath));
//		return this.metrics.isInTop(Metric.CLASS_LOC, 15, this.loc.get(clsFullPath));
	}

	private boolean hasLowCohesion(String clsFullPath) {
		return this.metrics.isMildOutlier(Metric.CLASS_LCOM, this.getPrimitiveMapStore(LCOM).get(clsFullPath));
//		return this.metrics.isInTop(Metric.CLASS_LCOM, 15, this.lcom.get(clsFullPath));
	}

	private long relatedDataClassesCount(String clsFullPath) {
		return this.getSetMapStore(RAC).get(clsFullPath).stream()
//				.filter(v -> this.metrics.isMildOutlier(Metric.CLASS_ACCESSORS, v))
				.filter(v -> this.metrics.isInTop(Metric.CLASS_ACCESSORS, 15, v))
				.count();
	}
}
;