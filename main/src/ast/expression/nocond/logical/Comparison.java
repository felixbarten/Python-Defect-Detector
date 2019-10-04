package ast.expression.nocond.logical;

import java.util.List;

import ast.Visitor;
import ast.expression.Expr;

/**
 * Created by Nik on 25-05-2015
 */
public class Comparison extends Logical {

	private final List<Expr> operands;
	private final List<String> operators;

	public Comparison( Integer locInfo,  List<Expr> operands,  List<String> operators) {
		super(locInfo);

		assert operands.size() - 1 == operators.size();

		this.operands = operands;
		this.operators = operators;
	}

	public List<Expr> getOperands() {
		return this.operands;
	}

	public List<String> getOperators() {
		return this.operators;
	}

	public Integer getArity() {
		return this.operands.size();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
