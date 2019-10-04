package ast.param;

import java.util.ArrayList;
import java.util.List;

import ast.Visitor;

/**
 * Created by Nik on 01-09-2015
 */
public class ListParam extends Param {

	private final List<Param> params;

	public ListParam( Integer locInfo,  List<Param> params) {
		super(locInfo);
		this.params = params;
	}

	public List<Param> getParams() {
		return this.params;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public List<String> getNames() {
		List<String> names = new ArrayList<>();
		this.params.forEach(p -> names.addAll(p.getNames()));
		return names;
	}
}
