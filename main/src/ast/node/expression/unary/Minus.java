package ast.node.expression.unary;

import ast.node.LocInfo;
import ast.node.expression.Expr;
import thesis.Py3TreeVisitor;

/**
 * Created by Nik on 10-06-2015
 */
public class Minus extends Unary {
	public Minus(LocInfo locInfo, Expr value) {
		super(locInfo, value);
	}

	@Override
	public <T> T accept(Py3TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}