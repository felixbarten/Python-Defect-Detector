package ast.statement.simple;

import org.antlr.v4.runtime.misc.NotNull;

import ast.Visitor;
import ast.expression.nocond.trailer.ArgList;
import ast.statement.MethodCallStmt;
import ast.statement.Statement;
import ast.statement.compound.Function;

/**
 * 
 * @author felix
 *
 * Super statement
 *
 */
public class SuperStmt extends Statement {

	private final Function caller; 
	private final ArgList superArgs;
	private final MethodCallStmt methodCalled;
	
	public SuperStmt(@NotNull Integer locInfo, ArgList superArg) {
		this(locInfo, superArg, null, null);
	}
	
	public SuperStmt(@NotNull Integer locInfo, ArgList superArg, Function f, MethodCallStmt chain) {
		super(locInfo);
		caller = f;
		superArgs = superArg;
		methodCalled = chain;
	}
	

	public ArgList getSuperArgs() {
		return superArgs;
	}

	public boolean hasSuperArgs() {
		return superArgs != null;
	}
	
	public boolean hasCaller() {
		return caller != null;
	}
	
	public MethodCallStmt getChainedMethod() {
		return methodCalled;
	}
	
	public boolean hasChain() {
		return methodCalled != null;
	}
	
	public String nameOfCalledMethod() {
		return hasChain() ? methodCalled.getName().toString() : null;
	}
	
	public Function getCaller() {
		return caller;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
