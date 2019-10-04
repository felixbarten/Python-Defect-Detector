package ast.statement.compound;

import ast.Suite;
import ast.Visitor;
import ast.expression.ExprList;

/**
 * Created by Nik on 17-06-2015
 */
public class For extends ast.statement.Statement {

	private final ExprList iterator;
	private final ExprList source;
	private final Suite body;
	private final Suite elseBody;
	private Boolean async;

	public For( Integer locInfo,  ExprList iterator,  ExprList source,  Suite body, Suite elseBody) {
		super(locInfo);
		this.iterator = iterator;
		this.source = source;
		this.body = body;
		this.elseBody = elseBody;
		this.async = false;
	}

	public ExprList getIterator() {
		return this.iterator;
	}

	public ExprList getSource() {
		return this.source;
	}

	public Suite getBody() {
		return this.body;
	}

	public Suite getElseBody() {
		return this.elseBody;
	}

	public Boolean hasElseBody () {
		return this.elseBody != null;
	}

	public void markAsAsync() {
		this.async = true;
	}

	public Boolean isAsync() {
		return this.async;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
