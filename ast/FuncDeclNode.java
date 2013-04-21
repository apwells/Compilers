package ast;

public class FuncDeclNode extends DeclNode {

	protected ParamListNode params;
	protected String id;
	protected TypeNode type;
	
	public FuncDeclNode (ParamListNode params, String id, TypeNode type) {
		this.params = params;
		this.type = type;
		this.id = id;
	}
}
