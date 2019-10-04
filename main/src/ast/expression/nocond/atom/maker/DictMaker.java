package ast.expression.nocond.atom.maker;

import java.util.List;

import ast.Visitor;
import ast.expression.Expr;
import ast.expression.compiter.CompFor;

/**
 * Created by Nik on 15-06-2015
 */
public class DictMaker extends Maker {

	private final CompFor comprehension;
	private final List<Expr> keys;
	private final List<Expr> values;

	public DictMaker( Integer locInfo, CompFor comprehension,  List<Expr> keys,  List<Expr> values) {
		super(locInfo);

		this.comprehension = comprehension;
		this.keys = keys;
		this.values = values;
	}

	public CompFor getComprehension() {
		return this.comprehension;
	}

	public List<Expr> getKeys() {
		return this.keys;
	}

	public List<Expr> getValues() {
		return this.values;
	}

	public Boolean hasComprehension() {
		return this.comprehension != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
