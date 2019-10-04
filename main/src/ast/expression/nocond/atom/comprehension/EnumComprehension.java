package ast.expression.nocond.atom.comprehension;

import java.util.List;

import ast.Visitor;
import ast.expression.Expr;

/**
 * Created by Nik on 23-06-2015
 */
public class EnumComprehension extends Comprehension {

	private final List<Expr> values;

	public EnumComprehension( Integer locInfo,  List<Expr> values) {
		super(locInfo);
		this.values = values;
	}

	public List<Expr> getValues() {
		return this.values;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
