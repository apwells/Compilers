package ast;

public class NotExprNode extends ExprNode{
	
	protected AccessorNode accessor;
	protected ExprNode value;
	
	public NotExprNode (ExprNode value) {
		this.value = value;
	}
	
	public NotExprNode (AccessorNode value) {
		accessor = value;
	}
	
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
