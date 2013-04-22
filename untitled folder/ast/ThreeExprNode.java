package ast;

public class ThreeExprNode extends ExprNode{
	
	protected ExprNode value1;
	protected ExprNode value2;
	protected ExprNode value3;
	
	public ThreeExprNode (ExprNode value1, ExprNode value2, ExprNode value3) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
