package ast.statement.flow;

import ast.Visitor;
import ast.statement.Statement;

/**
 * Created by Nik on 25-05-2015
 */
public class Break extends Statement {
	public Break( Integer locInfo) {
		super(locInfo);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
