package ast;

public class TypeNode extends Node{
	
	protected String type;
	
	public TypeNode(String type) {
		this.type = type;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
