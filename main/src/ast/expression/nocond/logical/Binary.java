package ast.expression.nocond.logical;

import java.util.List;

import ast.Visitor;
import ast.expression.Expr;

/**
 * Created by Nik on 10-06-2015
 */
public class Binary extends Logical {

	private final List<Expr> operands;
	private final String operator;

	public Binary( Integer locInfo,  List<Expr> operands,  String operator) {
		super(locInfo);
		this.operands = operands;
		this.operator = operator;
	}

	public List<Expr> getOperands() {
		return this.operands;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
