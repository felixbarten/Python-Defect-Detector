package ast.statement.simple;

import java.util.List;

import ast.Visitor;
import ast.expression.nocond.atom.Identifier;
import ast.statement.Statement;

/**
 * Created by Nik on 25-05-2015
 */
public class Global extends Statement {

	private final List<Identifier> identifiers;

	public Global( Integer locInfo,  List<Identifier> identifiers) {
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
