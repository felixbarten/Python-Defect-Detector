package ast.expression.logical;

import ast.LocInfo;
import ast.expression.Expr;
import org.antlr.v4.runtime.misc.NotNull;
import thesis.Visitor;

/**
 * Created by Nik on 09-06-2015
 */
public class Not extends Logical {

	private final Expr expression;

	public Not(@NotNull LocInfo locInfo, @NotNull Expr expression) {
		super(locInfo);
		this.expression = expression;
	}

	public Expr getExpression() {
		return this.expression;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
