package ast.statement.compound;

import java.util.List;

import ast.Suite;
import ast.Visitor;
import ast.expression.Expr;
import ast.statement.Statement;

/**
 * Created by Nik on 17-06-2015
 */
public class If extends Statement {

	private final List<Expr> conditions;
	private final List<Suite> bodies;
	private final Suite elseBody;

	public If( Integer locInfo,  List<Expr> conditions,  List<Suite> condBodies, Suite elseBody) {
		super(locInfo);

		this.conditions = conditions;
		this.bodies = condBodies;
		this.elseBody = elseBody;
	}

	public List<Expr> getConditions() {
		return this.conditions;
	}

	public Suite getElseBody() {
		return this.elseBody;
	}

	public List<Suite> getBodies() {
		return this.bodies;
	}

	public Boolean hasElseBody() {
		return this.elseBody != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
