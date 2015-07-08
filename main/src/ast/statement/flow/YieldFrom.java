package ast.statement.flow;

import ast.LocInfo;
import ast.expression.Expr;
import org.antlr.v4.runtime.misc.NotNull;
import thesis.Visitor;

/**
 * Created by Nik on 09-06-2015
 */
public class YieldFrom extends Yield {

	private final Expr from;

	public YieldFrom(@NotNull LocInfo locInfo, @NotNull Expr from) {
		super(locInfo);
		this.from = from;
	}

	public Expr getFrom() {
		return this.from;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
