package ast.expression.nocond.atom.maker;

import java.util.Collections;
import java.util.List;

import ast.Visitor;
import ast.expression.Expr;
import ast.expression.compiter.CompFor;

/**
 * Created by Nik on 15-06-2015
 */
public class SetMaker extends Maker {

	private final CompFor comprehension;
	private final List<Expr> values;

	public SetMaker( Integer locInfo,  CompFor comprehension) {
		super(locInfo);

		this.comprehension = comprehension;
		this.values = Collections.emptyList();
	}

	public SetMaker( Integer locInfo,  List<Expr> values) {
		super(locInfo);

		this.values = values;
		this.comprehension = null;
	}

	public CompFor getComprehension() {
		return this.comprehension;
	}

	public List<Expr> getValues() {
		return this.values;
	}

	public Boolean hasComprehension() {
		return this.comprehension != null;
	}

	public Boolean hasValues() {
		return this.values != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
