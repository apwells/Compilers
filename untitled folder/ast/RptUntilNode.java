package ast;

public class RptUntilNode extends StmtNode{
	
	protected ExprNode cond;
	protected StatementListNode body;
	
	public RptUntilNode (ExprNode cond, StatementListNode body) {
		this.cond = cond;
		this.body = body;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
