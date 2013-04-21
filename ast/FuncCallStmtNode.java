package ast;

public class FuncCallStmtNode {
	protected ExprListNode params;
	protected String id;
	
	public FuncCallStmtNode(ExprListNode params, String id) {
		this.params = params;
		this.id = id;
	}

}
