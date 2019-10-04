package ast.expression.nocond.bitwise;

import java.util.List;

import ast.expression.Expr;
import ast.expression.nocond.NonConditional;

/**
 * Created by Nik on 10-06-2015
 */
public abstract class Bitwise extends NonConditional {

	protected final List<Expr> operands;

	public Bitwise(Integer locInfo, List<Expr> operands) {
		super(locInfo);
		this.operands = operands;
	}

	public List<Expr> getOperands() {
		return this.operands;
	}
}
