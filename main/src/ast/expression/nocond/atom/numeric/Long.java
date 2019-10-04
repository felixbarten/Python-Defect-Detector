package ast.expression.nocond.atom.numeric;

import ast.Visitor;

/**
 * Created by Nik on 02-09-2015
 */
public class Long extends Numeric {

	private final String value;

	public Long( Integer locInfo,  String value) {
		super(locInfo);
		this.value = value;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
