package ast.statement.compound;

import java.util.List;

import ast.Suite;
import ast.Visitor;
import ast.statement.Statement;

/**
 * Created by Nik on 25-06-2015
 */
public class With extends Statement {

	private final List<WithItem> items;
	private final Suite body;
	private Boolean async;

	public With( Integer locInfo,  List<WithItem> items,  Suite body) {
		super(locInfo);
		this.items = items;
		this.body = body;
		this.async = false;
	}

	public List<WithItem> getItems() {
		return this.items;
	}

	public Suite getBody() {
		return this.body;
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
