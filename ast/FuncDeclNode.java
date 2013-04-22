package ast;

public class FuncDeclNode extends DeclNode {

	protected ParamListNode params;
	protected String id;
	protected TypeNode type;
	protected BlockNode block;
	
	public FuncDeclNode (ParamListNode params, String id, TypeNode type, BlockNode block) {
		this.params = params;
		this.type = type;
		this.id = id;
		this.block = block;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
