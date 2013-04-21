package ast;

public class FuncDeclNode extends DeclNode {

	protected ParamListNode params;
	protected boolean isVoid;
	protected TypeNode type;
	protected String id;
	
	public FuncDeclNode (ParamListNode params, boolean isVoid, TypeNode type, String id) {
		this.params = params;
		this.isVoid = isVoid;
		this.type = type;
		this.id = id;
	}
}
