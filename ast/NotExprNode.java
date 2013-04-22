package ast;

public class NotExprNode extends ExprNode{
	
	protected ExprNode value;
	
	public NotExprNode (ExprNode value) {
		this.value = value;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
