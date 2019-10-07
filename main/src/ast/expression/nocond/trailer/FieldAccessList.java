package ast.expression.nocond.trailer;

import java.util.List;

import ast.AstNode;
import ast.Visitor;

public class FieldAccessList extends AstNode {

	private final List<FieldAccess> fields;
	
	public FieldAccessList(Integer locInfo, List<FieldAccess> list) {
		
		super(locInfo);
		this.fields = list;
	}
	
	
	public List<FieldAccess> getFields() {
		return fields;
	}


	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
