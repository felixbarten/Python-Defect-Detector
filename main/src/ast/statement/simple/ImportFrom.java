package ast.statement.simple;

import java.util.List;

import ast.Visitor;
import ast.path.Path;

/**
 * Created by Nik on 25-05-15
 */
public class ImportFrom extends Import {

	private final Path module;

	public ImportFrom( Integer locInfo,  List<Path> paths,  Path module) {
		super(locInfo, paths);
		this.module = module;
	}

	public Path getModule() {
		return this.module;
	}

	public Boolean hasModule() {
		return this.module != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
