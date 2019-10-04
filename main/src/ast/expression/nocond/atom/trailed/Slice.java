package ast.expression.nocond.atom.trailed;

import ast.Visitor;
import ast.expression.nocond.atom.Atom;
import ast.expression.nocond.trailer.SubscriptSliceList;

/**
 * Created by Nik on 08-07-2015
 */
public class Slice extends TrailedAtom {

	private final SubscriptSliceList bound;

	public Slice( Integer locInfo,  Atom base,  SubscriptSliceList bound) {
		super(locInfo, base);
		this.bound = bound;
	}

	public SubscriptSliceList getBounds() {
		return this.bound;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
