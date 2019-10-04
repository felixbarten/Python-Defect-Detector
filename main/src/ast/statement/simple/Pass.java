package ast.statement.simple;

import ast.Visitor;
import ast.statement.Statement;

/**
 * Created by Nik on 25-05-2015
 */
public class Pass extends Statement {
	public Pass( Integer locInfo) {
		super(locInfo);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
