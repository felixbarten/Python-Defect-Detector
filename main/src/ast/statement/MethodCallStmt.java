package ast.statement;

import ast.Visitor;
import ast.expression.nocond.atom.Identifier;
import ast.expression.nocond.trailer.ArgList;
import ast.statement.compound.Function;

public class MethodCallStmt extends Statement {

	private final Identifier name;
	private final ArgList arguments;
	private final MethodCallStmt chained_method;
	private final Function parent; 

	public MethodCallStmt(Integer locInfo, Identifier name, ArgList arglist, Function parent, MethodCallStmt chain) {
		super(locInfo);
		this.name = name;
		this.arguments = arglist;
		this.parent = parent;
		this.chained_method = chain;
	}
	
	public Identifier getName() {
		return name;
	}

	public ArgList getArguments() {
		return arguments;
	}

	public MethodCallStmt getChained_method() {
		return chained_method;
	}

	public Function getParent() {
		return parent;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public Boolean hasArgList() {
		return this.arguments != null;
	}

	public boolean hasChain() {
		return chained_method != null;
	}
	/**
	 * Returns true if end of method chain is reached
	 * @return Boolean
	 */
	public boolean isEndOfChain() {
		return chained_method == null;
	}

}
