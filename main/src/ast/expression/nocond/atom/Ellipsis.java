package ast.expression.nocond.atom;

import ast.Visitor;

/**
 * Created by Nik on 15-06-2015
 */
public class Ellipsis extends Atom {

	public Ellipsis( Integer locInfo) {
		super(locInfo);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
