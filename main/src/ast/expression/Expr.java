package ast.expression;

import ast.AstNode;

/**
 * Created by Nik on 25-05-15
 */
public abstract class Expr extends AstNode {
	public Expr( Integer locInfo) {
		super(locInfo);
	}
}
