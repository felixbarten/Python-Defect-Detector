package model;

import java.util.List;

public class MethodCall implements Unlinkable {

	private final Variable instance; 
	private final ContentContainer parent;
	private final List<Variable> callerArgs;
	private final MethodCall chain;
	
	
	

	public MethodCall(Variable obj, List<Variable> vars, ContentContainer parent, MethodCall chain) {
		this.instance = obj;
		this.parent = parent;
		this.callerArgs = vars;
		this.chain = chain;
	}
	
	
	public Variable getInstance() {
		return instance;
	}

	public ContentContainer getParent() {
		return parent;
	}

	public List<Variable> getCallerArgs() {
		return callerArgs;
	}
	
	public MethodCall getChain() {
		return chain;
	}

	public Boolean isEndOfChain() {
		return chain == null;
	}
	
	
	@Override
	public void unlink() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	

}
