package ast.expression.nocond.atom.yield;

import ast.Visitor;
import ast.expression.Expr;

/**
 * Created by Nik on 09-06-2015
 */
public class YieldFrom extends Yield {

	private final Expr from;

	public YieldFrom( Integer locInfo,  Expr from) {
		super(locInfo);
		this.from = from;
	}

	public Expr getFrom() {
		return this.from;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
