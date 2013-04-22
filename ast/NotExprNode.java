package ast;

public class NotExprNode {
	
	protected ExprNode value;
	
	public NotExprNode (ExprNode value) {
		this.value = value;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
