package ast.param;

import java.util.ArrayList;
import java.util.List;

import ast.expression.nocond.atom.Identifier;

/**
 * Created by Nik on 01-09-2015
 */
public abstract class SimpleParam extends Param {

	private final Identifier id;

	public SimpleParam( Integer locInfo, Identifier id) {
		super(locInfo);
		this.id = id;
	}

	public Identifier getId() {
		return this.id;
	}

	@Override
	public boolean isSelf() {
		return this.id.isSelf();
	}

	@Override
	public List<String> getNames() {
		List<String> names = new ArrayList<>();
		names.add(this.id.getValue());
		return names;
	}
}
