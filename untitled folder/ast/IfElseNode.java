package ast;

public class IfElseNode extends StmtNode{
	
	protected ExprNode cond;
	protected StatementListNode body;
	protected StatementListNode elsebody;
	
	public IfElseNode (ExprNode cond, StatementListNode body, StatementListNode elsebody) {
		this.cond = cond;
		this.body = body;
		this.elsebody = elsebody;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
