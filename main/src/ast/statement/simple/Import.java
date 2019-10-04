package ast.statement.simple;

import java.util.List;

import ast.path.Path;
import ast.statement.Statement;

/**
 * Created by Nik on 08-07-2015
 */
public abstract class Import extends Statement {

	protected final List<Path> paths;

	public Import( Integer locInfo,  List<Path> paths) {
		super(locInfo);
		this.paths = paths;
	}

	public List<Path> getPaths() {
		return this.paths;
	}
}
