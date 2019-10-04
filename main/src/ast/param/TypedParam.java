package ast.param;

import ast.Visitor;
import ast.expression.Expr;
import ast.expression.nocond.atom.Identifier;

/**
 * Created by Nik on 23-06-2015
 */
public class TypedParam extends SimpleParam {
	private final Expr returnVal;

	public TypedParam( Integer locInfo,  Identifier id,  Expr returnVal) {
		super(locInfo, id);
		this.returnVal = returnVal;
	}

	public Boolean hasReturnVal() {
		return this.returnVal != null;
	}

	public Expr getReturnVal() {
		return this.returnVal;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
