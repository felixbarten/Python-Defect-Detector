package ast.expression.nocond.trailer;

import java.util.List;

import ast.AstNode;
import ast.Visitor;
import ast.argument.SimpleArgument;
import ast.statement.MethodCallStmt;

/**
 * Field access in classes. 
 * 
 * member.method()
 * or member._member; 
 * @author felix
 *
 */
public class FieldAccess extends AstNode {

	private SimpleArgument member;
	private List<Trailer> trailers; 

	public FieldAccess(Integer locInfo, SimpleArgument caller, ArgList members, MethodCallStmt method) {
		super(locInfo);
		this.member  = caller;
	}

	public FieldAccess(Integer locInfo, SimpleArgument caller, List<Trailer> trailers) {
		super(locInfo);
		this.member = caller;
		this.trailers = trailers;
	}

	public final SimpleArgument getMember() {
		return member;
	}

	public final List<Trailer> getTrailers() {
		return trailers;
	}

	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	

}
