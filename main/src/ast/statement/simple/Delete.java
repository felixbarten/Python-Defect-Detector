package ast.statement.simple;

import ast.Visitor;
import ast.expression.ExprList;

/**
 * Created by Nik on 17-06-2015
 */
public class Delete extends ast.statement.Statement {

	private final ExprList items;

	public Delete( Integer locInfo,  ExprList items) {
		super(locInfo);
		this.items = items;
	}

	public ExprList getItems() {
		return this.items;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
