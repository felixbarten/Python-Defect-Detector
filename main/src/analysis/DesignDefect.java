package analysis;

/**
 * Created by Nik on 05-11-2015
 */
public class DesignDefect {

	private final String fullPath;
	private final String defect;

	public DesignDefect(String fullPath, String defect) {
		this.fullPath = fullPath;
		this.defect = defect;
	}

	public String getFullPath() {
		return this.fullPath;
	}

	public String getDefect() {
		return this.defect;
	}

	/**
	 * Check if object o is a design defect and if it is if it is the same object as 'this'. 
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof DesignDefect)) {
			return false;
		}

		DesignDefect that = (DesignDefect) o;

		if (!this.getFullPath().equals(that.getFullPath())) {
			return false;
		}
		return this.getDefect().equals(that.getDefect());

	}
}