package ast.expression.nocond.atom.trailed;

import ast.expression.nocond.atom.Atom;

/**
 * Created by Nik on 07-07-2015
 */
public abstract class TrailedAtom extends Atom {

	private Atom base;

	public TrailedAtom( Integer locInfo,  Atom base) {
		super(locInfo);
		this.base = base;
	}

	public Atom getBase() {
		return this.base;
	}

	public void setBase( Atom base) {
		this.base = base;
	}
}
