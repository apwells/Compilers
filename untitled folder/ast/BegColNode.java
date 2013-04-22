package ast;

public class BegColNode extends DualExprNode{

	public BegColNode(ExprNode value1, ExprNode value2) {
		super(value1, value2);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
