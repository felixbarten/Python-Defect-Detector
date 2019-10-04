package ast.statement.compound;

import ast.Suite;
import ast.Visitor;
import ast.expression.Expr;
import ast.statement.Statement;

/**
 * Created by Nik on 17-06-2015
 */
public class While extends Statement {

	private final Expr condition;
	private final Suite body;
	private final Suite elseBody;

	public While( Integer locInfo,  Expr condition,  Suite body, Suite elseBody) {
		super(locInfo);
		this.condition = condition;
		this.body = body;
		this.elseBody = elseBody;
	}

	public Expr getCondition() {
		return this.condition;
	}

	public Suite getBody() {
		return this.body;
	}

	public Suite getElseBody() {
		return this.elseBody;
	}

	public Boolean hasElseBody() {
		return this.elseBody != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
