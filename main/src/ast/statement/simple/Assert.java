package ast.statement.simple;

import ast.Visitor;
import ast.expression.Expr;
import ast.statement.Statement;

/**
 * Created by Nik on 17-06-2015
 */
public class Assert extends Statement {

	private final Expr assertion;
	private final Expr assertionError;

	public Assert( Integer locInfo,  Expr assertion) {
		this(locInfo, assertion, null);
	}

	public Assert( Integer locInfo,  Expr assertion, Expr assertionError) {
		super(locInfo);
		this.assertion = assertion;
		this.assertionError = assertionError;
	}

	public Expr getAssertion() {
		return this.assertion;
	}

	public Expr getAssertionError() {
		return this.assertionError;
	}

	public Boolean hasAssertionError() {
		return this.assertionError != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
