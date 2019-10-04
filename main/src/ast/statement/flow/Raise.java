package ast.statement.flow;

import ast.expression.Expr;
import ast.statement.Statement;

/**
 * Created by Nik on 01-09-2015
 */
public abstract class Raise extends Statement {

	protected final Expr type;

	public Raise( Integer locInfo, Expr type) {
		super(locInfo);
		this.type = type;
	}

	public Expr getType() {
		return this.type;
	}

	public Boolean hasType() {
		return this.type != null;
	}
}
