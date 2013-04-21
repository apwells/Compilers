package ast;

import java.util.List;

// Todo : Add getters/setter for params

public class ParamListNode extends Node {
	
	protected List<VarTypeNode> params;
	
	public ParamListNode (List<VarTypeNode> params) {
		this.params = params;
	}

}
