package ast;

public class VarTypeNode {
	
	protected TypeNode type;
	protected String id;
	
	public VarTypeNode(TypeNode type, String id) {
		this.type = type;
		this.id = id;
	}

}
