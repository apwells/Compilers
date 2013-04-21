package ast;

public class RptUntilNode extends StmtNode{
	
	protected ExprNode cond;
	protected StatementListNode body;
	
	public RptUntilNode (ExprNode cond, StatementListNode body) {
		this.cond = cond;
		this.body = body;
	}

}
