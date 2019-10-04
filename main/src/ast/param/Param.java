package ast.param;

import java.util.List;

import ast.AstNode;
import ast.expression.Expr;

/**
 * Created by Nik on 08-07-2015
 */
public abstract class Param extends AstNode {

	private Expr defaultVal;

	public Param( Integer locInfo) {
		super(locInfo);
	}

	public Expr getDefaultVal() {
		return this.defaultVal;
	}

	public void setDefaultVal( Expr defaultVal) {
		this.defaultVal = defaultVal;
	}

	public Boolean hasDefaultVal() {
		return this.defaultVal != null;
	}

	public boolean isSelf() {
		return false;
	}

	public abstract List<String> getNames();
}
