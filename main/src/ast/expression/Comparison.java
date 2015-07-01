package ast.expression;

import ast.LocInfo;
import ast.expression.logical.Logical;
import org.antlr.v4.runtime.misc.NotNull;
import thesis.Visitor;

import java.util.List;

/**
 * Created by Nik on 25-05-2015
 */
public class Comparison extends Logical {

	private final List<Expr> operands;
	private final List<String> operators;

	public Comparison(LocInfo locInfo, @NotNull List<Expr> operands, @NotNull List<String> operators) {
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
