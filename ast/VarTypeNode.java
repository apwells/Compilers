package ast;

public class VarTypeNode extends Node{
	
	protected TypeNode type;
	protected String id;
	
	public VarTypeNode(TypeNode type, String id) {
		this.type = type;
		this.id = id;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
