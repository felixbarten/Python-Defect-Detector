package ast.argument;

import ast.Visitor;
import ast.expression.Expr;

/**
 * Created by Nik on 09-10-2015
 */
public class Kwarg extends Argument {

	public Kwarg(Integer locInfo,  Expr value) {
		super(locInfo, value);
	}

	@Override
	public <T> T accept(ArgumentVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
