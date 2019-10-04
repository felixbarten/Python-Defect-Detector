package ast.statement.compound;

import ast.Visitor;
import ast.expression.Expr;
import ast.statement.Statement;

/**
 * Created by Nik on 25-06-2015
 */
public class WithItem extends Statement {

	private final Expr item;
	private final Expr alias;

	public WithItem( Integer locInfo,  Expr item, Expr alias) {
		super(locInfo);
		this.item = item;
		this.alias = alias;
	}

	public Expr getItem() {
		return this.item;
	}

	public Expr getAlias() {
		return this.alias;
	}

	public boolean hasAlias() {
		return this.alias != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
