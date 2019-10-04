package ast.statement.flow;

import ast.Visitor;
import ast.expression.ExprList;

/**
 * Created by Nik on 15-06-2015
 */
public class Return extends ast.statement.Statement {

	private final ExprList values;

	public Return( Integer locInfo) {
		this(locInfo, null);
	}

	public Return( Integer locInfo, ExprList values) {
		super(locInfo);
		this.values = values;
	}

	public ExprList getValues() {
		return this.values;
	}

	public Boolean hasSingleReturnValue() {
		return this.hasValues() && this.values.size() == 1;
	}

	public Boolean hasValues() {
		return this.values != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
