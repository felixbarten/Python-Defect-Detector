package ast.argument;

import ast.Visitor;
import ast.expression.Expr;
import ast.expression.nocond.atom.Identifier;

/**
 * Created by Nik on 23-06-2015
 */
public class DefValArgument extends Argument {

	private final Identifier name;

	public DefValArgument( Integer locInfo,  Expr value,  Identifier name) {
		super(locInfo, value);
		this.name = name;
	}

	public Identifier getName() {
		return this.name;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public <T> T accept(ArgumentVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
