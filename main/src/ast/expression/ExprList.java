package ast.expression;

import java.util.List;

import ast.Visitor;

/**
 * Created by Nik on 29-06-2015
 */
public class ExprList extends ast.expression.Expr {

	private final List<Expr> values;

	public ExprList( Integer locInfo,  List<Expr> values) {
		super(locInfo);
		this.values = values;
	}

	public List<Expr> getValues() {
		return this.values;
	}

	public Integer size() {
		return this.values.size();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
