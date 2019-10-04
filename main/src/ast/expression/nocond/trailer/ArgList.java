package ast.expression.nocond.trailer;

import java.util.List;

import ast.Visitor;
import ast.argument.Argument;
import ast.expression.nocond.NonConditional;

/**
 * Created by Nik on 23-06-2015
 */
public class ArgList extends NonConditional implements Trailer {
	
	private final List<Argument> arguments;

	public ArgList( Integer locInfo,  List<Argument> arguments) {
		super(locInfo);
		this.arguments = arguments;
	}

	public List<Argument> getArguments() {
		return this.arguments;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public <T> T accept(TrailerVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
