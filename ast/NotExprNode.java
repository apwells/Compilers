package ast;

public class NotExprNode {
	
	protected ExprNode value;
	
	public NotExprNode (ExprNode value) {
		this.value = value;
	}
}
