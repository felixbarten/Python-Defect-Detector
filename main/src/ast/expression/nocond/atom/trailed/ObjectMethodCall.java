package ast.expression.nocond.atom.trailed;

import ast.Visitor;
import ast.expression.nocond.atom.Atom;

/**
 * Created by Nik on 08-07-2015
 */
public class ObjectMethodCall extends TrailedAtom {

	private final Call call;

	public ObjectMethodCall( Integer locInfo,  Atom base,  Call call) {
		super(locInfo, base);
		this.call = call;
	}

	public Call getCall() {
		return this.call;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
