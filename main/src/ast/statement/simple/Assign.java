package ast.statement.simple;

import java.util.List;

import ast.Visitor;
import ast.expression.ExprList;
import ast.expression.nocond.atom.yield.Yield;

/**
 * Created by Nik on 17-06-2015
 */
public class Assign extends ast.statement.Statement {

	private final List<Yield> yieldElements;
	private final String operator;
	private final List<ExprList> exprElements;

	public Assign( Integer locInfo,  String operator,  List<ExprList> exprElements,  List<Yield> yieldElements) {
		super(locInfo);
		this.operator = operator;
		this.exprElements = exprElements;
		this.yieldElements = yieldElements;
	}

	public String getOperator() {
		return this.operator;
	}

	public List<ExprList> getExprElements() {
		return this.exprElements;
	}

	public List<Yield> getYieldElements() {
		return this.yieldElements;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
