package ast.expression.nocond.atom.numeric;

import java.math.BigInteger;

import ast.Visitor;

/**
 * Created by Nik on 25-05-2015
 */
public class Int extends Numeric {

	private final BigInteger value;

	public Int( Integer locInfo,  BigInteger value) {
		super(locInfo);
		this.value = value;
	}

	public BigInteger getValue() {
		return this.value;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
