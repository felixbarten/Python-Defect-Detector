package ast.expression.nocond.bitwise;

import java.util.List;

import ast.Visitor;
import ast.expression.Expr;

/**
 * Created by Nik on 10-06-2015
 */
public class Shift extends Bitwise {

	private final List<String> operators;

	public Shift( Integer locInfo,  List<Expr> operands,  List<String> operators) {
		super(locInfo, operands);
		this.operators = operators;
	}

	public List<String> getOperators() {
		return this.operators;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
