package model;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Nik on 11-07-2015
 */
public class Subroutine extends ContentContainer {

	private final SubroutineType subroutineType;
	private ContentContainer parent;
	private final Boolean isAccessor;
	private final List<String> params;
	protected final Integer complexity;
	private final Class parentCls;

	public Subroutine(String name, Integer loc, Integer cc, ContentContainer parent, SubroutineType subroutineType, List<String> params, Boolean isAccessor, Class cls) {
		super(name, loc);
		this.parent = parent;
		this.subroutineType = subroutineType;
		this.params = params;
		this.isAccessor = isAccessor;
		this.complexity = cc;
		this.parentCls = cls;
	}

	public Integer getAccessOfImportData() {
		//Number of data members accessed in a method directly or via accessor-methods, from which the definition-class of the method is not derived.
		Long outsideAccessorCalls = this.calledSubroutines.values().stream()
				.filter(Subroutine::isAccessor)
				.filter(s -> !this.parent.isInParentLine(s.parent))
				.count();
		return outsideAccessorCalls.intValue() + this.getReferencedOutsideVariables().size();
	}

	public Integer getAccessOfLocalData() {
		//Number of the data members accessed in the given method, which are local to the class where the method is defined.
		return this.getReferencedInsideVariables().size();
	}

	public Integer paramCount() {
		return this.params.size();
	}

	public Set<Variable> getReferencedInsideVariables() {
		return this.referencedVars.getAsSet().stream()
				.filter(v -> v.definedInParentOf(this))
				.collect(Collectors.toSet());
	}

	public Set<Variable> getReferencedOutsideVariables() {
		return this.referencedVars.getAsSet().stream()
				.filter(v -> !v.definedInParentOf(this))
				.collect(Collectors.toSet());
	}

	public Boolean isAccessor() {
		return this.isAccessor;
	}

	public SubroutineType getSubroutineType() {
		return this.subroutineType;
	}

	public Boolean hasVariableIntersection(Subroutine m) {
		return !Collections.disjoint(this.getReferencedInsideVariables(), m.getReferencedInsideVariables());
	}

	public Boolean isPrivate() {
		return this.name.startsWith("__") && !this.name.endsWith("__");
	}

	@Override
	public void unlink() {
		super.unlink();
		this.parent = null;
	}

	@Override
	public boolean isInParentLine(ContentContainer container) {
		if (this.equals(container)) {
			return true;
		}
		return this.parent.isInParentLine(container);
	}

	@Override
	public String getFullPath() {
		String type = this.subroutineType == SubroutineType.FUNCTION ? "function " : "method ";
		return this.parent.getFullPath() + " > " + type + this.name;
	}

	@Override
	public <T> T accept(ContentContainerVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Subroutine)) {
			return false;
		}

		Subroutine that = (Subroutine) o;

		if (!this.getName().equals(that.getName())) {
			return false;
		}
		if (this.getSubroutineType() != that.getSubroutineType()) {
			return false;
		}
		return this.parent.equals(that.parent);

	}

	@Override
	public int hashCode() {
		int result = this.getName().hashCode();
		result = 31 * result + this.getSubroutineType().hashCode();
		result = 31 * result + this.parent.hashCode();
		return result;
	}
	
	/**
	 * Returns parent class if set. 
	 * @return Class or null;
	 */
	public Class getParentClass() {
		return this.parentCls;
	}

	public Integer getCC() {
		return complexity;
	}

	public boolean isFunction() {
		return getSubroutineType() == SubroutineType.FUNCTION;
	}
}
