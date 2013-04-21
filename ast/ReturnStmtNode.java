package ast;

public class ReturnStmtNode  extends StmtNode{
	protected ExprNode value;
	
	public ReturnStmtNode(ExprNode value) {
		this.value = value;
	}

}
