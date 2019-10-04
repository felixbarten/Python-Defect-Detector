package ast.expression.nocond.atom.yield;


import ast.Visitor;
import ast.expression.ExprList;

/**
 * Created by Nik on 25-05-2015
 */
public class YieldValues extends Yield {

	private final ExprList values;

	public YieldValues( Integer locInfo) {
		this(locInfo, null);
	}

	public YieldValues( Integer locInfo, ExprList values) {
		super(locInfo);
		this.values = values;
	}

	public ExprList getValues() {
		return this.values;
	}

	public Boolean hasValues() {
		return this.values != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
