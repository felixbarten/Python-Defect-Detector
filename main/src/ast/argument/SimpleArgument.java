package ast.argument;

import ast.Visitor;
import ast.expression.Expr;

/**
 * Created by Nik on 23-06-2015
 */
public class SimpleArgument extends Argument {

	public SimpleArgument(Integer locInfo, Expr value) {
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
