package model;

import java.util.List;

public class SuperCall implements Unlinkable {

	private Subroutine parent;
	private List<String> parameters; 
	private List<String> callerParams; 
	
	
	SuperCall(Subroutine parent, Subroutine callee) {
		
	}
	
	
	@Override
	public void unlink() {
		this.parent = null;
		this.parameters = null;
		this.callerParams = null;
	}
	
	private Class getParentClass() {
		return parent.getParentClass();
	}
	

}
