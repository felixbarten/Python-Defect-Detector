package ast.statement.flow;

import ast.Visitor;
import ast.statement.Statement;

/**
 * Created by Nik on 03-11-2015
 */
public class Yield extends Statement {

	private final ast.expression.nocond.atom.yield.Yield yield;

	public Yield( Integer locInfo, ast.expression.nocond.atom.yield.Yield yield) {
		super(locInfo);
		this.yield = yield;
	}

	public ast.expression.nocond.atom.yield.Yield getYield() {
		return this.yield;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
