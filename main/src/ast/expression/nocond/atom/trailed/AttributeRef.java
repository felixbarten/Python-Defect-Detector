package ast.expression.nocond.atom.trailed;

import java.util.ArrayList;
import java.util.List;

import ast.Visitor;
import ast.expression.nocond.atom.Atom;
import ast.expression.nocond.atom.Identifier;

/**
 * Created by Nik on 07-07-2015
 */
public class AttributeRef extends TrailedAtom {

	private final List<Identifier> attributes;

	public AttributeRef( Integer locInfo,  AttributeRef base,  Identifier attribute) {
		super(locInfo, base.getBase());
		this.attributes = base.getAttributes();
		this.attributes.add(attribute);
	}

	public AttributeRef( Integer locInfo,  Atom base,  Identifier attribute) {
		super(locInfo, base);
		this.attributes = new ArrayList<>();
		this.attributes.add(attribute);
	}

	public List<Identifier> getAttributes() {
		return this.attributes;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		List<String> parts = new ArrayList<>();
		parts.add(this.getBase().toString());
		this.attributes.forEach(a -> parts.add(a.toString()));
		String objString = String.join(".", parts);
		return objString;
	}
}
