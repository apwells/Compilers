package ast;

public class DualExprNode extends ExprNode{
	
	protected ExprNode value1;
	protected ExprNode value2;
	
	public DualExprNode (ExprNode value1, ExprNode value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
