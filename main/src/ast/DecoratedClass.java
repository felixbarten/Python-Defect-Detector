package ast;

import ast.arg.Args;
import ast.expression.atom.Identifier;
import ast.statement.Statement;

import java.util.List;

/**
 * Created by Nik on 15-06-2015
 */
public class DecoratedClass extends ClassDef {

	private final List<Decorator> decorators;

	public DecoratedClass(LocInfo locInfo, List<Decorator> decorators, Identifier name, Args inheritance, List<Statement> body) {
		super(locInfo, name, inheritance, body);
		this.decorators = decorators;
	}

	public List<Decorator> getDecorators() {
		return this.decorators;
	}
}