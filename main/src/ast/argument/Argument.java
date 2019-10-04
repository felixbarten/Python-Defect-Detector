package ast.argument;

import ast.AstNode;
import ast.expression.Expr;

/**
 * Created by Nik on 23-06-2015
 */
public abstract class Argument extends AstNode {

	private final Expr value;

	public Argument(Integer locInfo,  Expr value) {
		super(locInfo);
		this.value = value;
	}

	public Expr getValue() {
		return this.value;
	}

	public abstract <T> T accept(ArgumentVisitor<T> visitor);
}
