package ast;

public class BrkExprNode extends FinalNode{
	protected ExprNode value;
	
	public BrkExprNode (ExprNode value) {
		this.value = value;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
