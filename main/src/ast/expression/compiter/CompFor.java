package ast.expression.compiter;

import java.util.List;

import ast.Visitor;
import ast.expression.Expr;
import ast.expression.ExprList;

/**
 * Created by Nik on 17-06-2015
 */
public class CompFor extends CompIter {

	private final ExprList targets;
	private final List<Expr> source;

	public CompFor( Integer locInfo, CompIter nextLink,  ExprList targets,  List<Expr> source) {
		super(locInfo, nextLink);
		this.targets = targets;
		this.source = source;
	}

	public ExprList getTargets() {
		return this.targets;
	}

	public List<Expr> getSource() {
		return this.source;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
