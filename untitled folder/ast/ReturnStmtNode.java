package ast;

public class ReturnStmtNode  extends StmtNode{
	protected ExprNode value;
	
	public ReturnStmtNode(ExprNode value) {
		this.value = value;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
