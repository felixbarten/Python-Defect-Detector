package ast.path;

import ast.Visitor;

/**
 * Created by Nik on 23-06-2015
 */
public class SimplePath extends Path {

	private final String path;

	public SimplePath( Integer locInfo,  String path) {
		super(locInfo);
		this.path = path;
	}

	@Override
	public String getPath() {
		return this.path;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
