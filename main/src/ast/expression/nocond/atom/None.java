package ast.expression.nocond.atom;

import ast.Visitor;

/**
 * Created by Nik on 15-06-2015
 */
public class None extends Atom {
	public None( Integer locInfo) {
		super(locInfo);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
