package ast.expression.nocond.atom.comprehension;

import ast.Visitor;
import ast.expression.Expr;
import ast.expression.compiter.CompFor;

/**
 * Created by Nik on 23-06-2015
 */
public class CondComprehension extends Comprehension {

	private final Expr expression;
	private final CompFor compFor;

	public CondComprehension( Integer locInfo,  Expr expression,  CompFor compFor) {
		super(locInfo);
		this.expression = expression;
		this.compFor = compFor;
	}

	public Expr getExpression() {
		return this.expression;
	}

	public CompFor getCompFor() {
		return this.compFor;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
