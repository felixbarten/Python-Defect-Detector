package ast.expression.nocond.atom.numeric;

import ast.Visitor;

/**
 * Created by Nik on 12-06-2015
 */
public class Imaginary extends Numeric {

	private final Double value;

	public Imaginary( Integer locInfo,  Double value) {
		super(locInfo);
		this.value = value;
	}

	public Double getValue() {
		return this.value;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
