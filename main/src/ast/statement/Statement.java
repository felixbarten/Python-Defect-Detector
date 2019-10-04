package ast.statement;

import ast.AstNode;

/**
 * Created by Nik on 25-05-2015
 */
public abstract class Statement extends AstNode {
	public Statement( Integer locInfo) {
		super(locInfo);
	}
}
