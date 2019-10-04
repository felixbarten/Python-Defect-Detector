package ast.param;

import ast.Visitor;
import ast.expression.nocond.atom.Identifier;

/**
 * Created by Nik on 23-06-2015
 */
public class UntypedParam extends SimpleParam {

	public UntypedParam( Integer locInfo,  Identifier id) {
		super(locInfo, id);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
