package ast.expression.nocond.logical;

import ast.Visitor;
import ast.expression.Expr;

/**
 * Created by Nik on 09-06-2015
 */
public class Not extends Logical {

	private final Expr expression;

	public Not( Integer locInfo,  Expr expression) {
		super(locInfo);
		this.expression = expression;
	}

	public Expr getExpression() {
		return this.expression;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
