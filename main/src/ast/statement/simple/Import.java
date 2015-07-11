package ast.statement.simple;

import ast.LocInfo;
import ast.Path;
import ast.statement.Statement;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

/**
 * Created by Nik on 08-07-2015
 */
public abstract class Import extends Statement {
	private final List<Path> paths;

	public Import(@NotNull LocInfo locInfo, @NotNull List<Path> paths) {
		super(locInfo);
		this.paths = paths;
	}

	public List<Path> getPaths() {
		return this.paths;
	}
}
