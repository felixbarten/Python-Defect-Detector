package ast.expression;

import ast.Visitor;
import ast.param.Params;

/**
 * Created by Nik on 26-05-2015
 */
public class Lambda extends Expr {

	private final Params parameters;
	private final Expr expression;

	public Lambda( Integer locInfo,  Expr expression, Params parameters) {
		super(locInfo);
		this.expression = expression;
		this.parameters = parameters;
	}

	public Expr getExpression() {
		return this.expression;
	}

	public Params getParameters() {
		return this.parameters;
	}

	public Boolean hasParameters() {
		return this.parameters != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
