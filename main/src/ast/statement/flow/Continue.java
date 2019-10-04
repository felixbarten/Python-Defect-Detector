package ast.statement.flow;

import ast.Visitor;
import ast.statement.Statement;

/**
 * Created by Nik on 15-06-2015
 */
public class Continue extends Statement {
	public Continue( Integer locInfo) {
		super(locInfo);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
