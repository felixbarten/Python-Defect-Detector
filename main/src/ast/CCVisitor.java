package ast;

import ast.statement.compound.For;
import ast.statement.compound.If;
import ast.statement.compound.Try;
import ast.statement.compound.While;
import ast.statement.flow.Break;

/**
 * 
 * @author felixbarten
 *
 * Visitor for calculating Cyclomatic Complexity of program. 
 *
 * @param <T>
 */
public class CCVisitor extends DefaultVisitor<Void>{
	
	private int complexity = 1;
	
	public CCVisitor() {
	
	}
	
	@Override
	public Void visit(If n) {
		/*
		 *  count bodies to see branching code paths
		 *  
		 *  If else should be two bodies
		 *  if elseif elseif else, 4
		 */
		complexity += n.getBodies().size();
		this.visitChildren(n);
		return null;
	}
	
	@Override
	public Void visit(Try n) {
		// -1?
		int catchBlocks = n.getExceptBodies().size();
		complexity += catchBlocks + 1;
		this.visitChildren(n);

		return null;
	}
	
	@Override
	public Void visit(While n) {
		/*
		if(n.hasElseBody()){
			complexity += 2;
		} else {
			complexity += 1;
		}
		*/
		complexity += 1;
		
		this.visitChildren(n);

		return null;
	}
	
	@Override
	public Void visit(For n) {
		/*
		if(n.hasElseBody()){
			complexity += 1;
		}*/
		complexity += 1;
		
		n.getBody().accept(this);
		if (n.hasElseBody()) {
			n.getElseBody().accept(this);
		}
		n.getIterator().accept(this);
		n.getSource().accept(this);
		return null;
	}
	
	@Override
	public Void visit(Break n) {
		//complexity += 1;
		
		return null;
		
	}

	public void resetCC() {
		complexity = 1;
	}
	
	public int getComplexity() {
		return complexity;
	
	}
}
