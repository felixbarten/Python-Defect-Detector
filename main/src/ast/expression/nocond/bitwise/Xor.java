package ast.expression.nocond.bitwise;

import java.util.List;

import ast.Visitor;
import ast.expression.Expr;

/**
 * Created by Nik on 10-06-2015
 */
public class Xor extends Bitwise {

	public Xor( Integer locInfo,  List<Expr> operands) {
		super(locInfo, operands);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
