package ast.expression.nocond.arithmetic;

import ast.Visitor;
import ast.expression.Expr;
import ast.expression.nocond.NonConditional;
import ast.expression.nocond.atom.Atom;

/**
 * Created by Nik on 17-06-2015
 */
public class Power extends NonConditional {

	private final Atom base;
	private final Expr exponent;

	public Power(Integer locInfo,  Atom base,  Expr exponent) {
		super(locInfo);
		this.base = base;
		this.exponent = exponent;
	}

	public Atom getBase() {
		return this.base;
	}

	public Expr getExponent() {
		return this.exponent;
	}

	public Boolean hasExponent() {
		return this.exponent != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return this.base.toString() + (this.hasExponent() ? "**" + this.exponent.toString() : "");
	}
}
