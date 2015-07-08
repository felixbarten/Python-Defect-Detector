package ast.statement.simple;

import ast.LocInfo;
import ast.expression.atom.Identifier;
import ast.statement.Statement;
import org.antlr.v4.runtime.misc.NotNull;
import thesis.Visitor;

import java.util.List;

/**
 * Created by Nik on 25-05-2015
 */
public class Nonlocal extends Statement {

	private final List<Identifier> identifiers;

	public Nonlocal(@NotNull LocInfo locInfo, @NotNull List<Identifier> identifiers) {
		super(locInfo);
		this.identifiers = identifiers;
	}

	public List<Identifier> getIdentifiers() {
		return this.identifiers;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
