package ast.expression.nocond.arithmetic;

import java.util.List;

import ast.Visitor;
import ast.expression.Expr;
import ast.expression.nocond.NonConditional;

/**
 * Created by Nik on 10-06-2015
 */
public class Nnary extends NonConditional {

	private final List<Expr> operands;
	private final List<String> operators;

	public Nnary( Integer locInfo,  List<Expr> operands,  List<String> operators) {
		super(locInfo);

		this.operands = operands;
		this.operators = operators;
	}

	public List<Expr> getOperands() {
		return this.operands;
	}

	public List<String> getOperators() {
		return this.operators;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
