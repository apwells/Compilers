package ast;

public class VarDeclNode extends DeclNode{
	
	protected ExprListNode declarations;
	protected VarTypeNode id;
	
	public VarDeclNode (ExprListNode declarations, VarTypeNode id) {
		this.declarations = declarations;
		this.id = id;
	}

}
