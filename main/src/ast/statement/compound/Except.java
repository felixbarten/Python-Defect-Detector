package ast.statement.compound;

import ast.Visitor;
import ast.expression.Expr;
import ast.statement.Statement;

/**
 * Created by Nik on 24-06-2015
 */
public class Except extends Statement {

	private final Expr exception;
	private final Expr alias;

	public Except( Integer locInfo, Expr exception, Expr alias) {
		super(locInfo);
		this.exception = exception;
		this.alias = alias;
	}

	public Expr getException() {
		return this.exception;
	}

	public Expr getAlias() {
		return this.alias;
	}

	public Boolean hasException() {
		return this.exception != null;
	}

	public Boolean hasAlias() {
		return this.alias != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
