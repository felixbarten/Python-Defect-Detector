package ast.statement.simple;

import java.util.ArrayList;
import java.util.List;

import ast.Visitor;
import ast.expression.Expr;
import ast.expression.nocond.trailer.ArgList;
import ast.expression.nocond.trailer.Trailer;
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
	private final Trailer trail; 
	private final List<Expr> trailers;
	
	public SuperStmt( Integer locInfo, ArgList superArg) {
		this(locInfo, superArg, null, null);
	}
	
	public SuperStmt( Integer locInfo, ArgList superArg, Function f, MethodCallStmt chain) {
		super(locInfo);
		caller = f;
		superArgs = superArg;
		methodCalled = chain;
		this.trail = null;
		this.trailers = new ArrayList<Expr>();
	}
	

	public SuperStmt(Integer locInfo, Trailer trailer, List<Expr> exprs) {
		super(locInfo);
		this.trailers = exprs;
		this.trail = trailer;
		this.superArgs = null;
		this.methodCalled = null;
		this.caller = null;
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
