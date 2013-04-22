package ast;

public class EndColNode extends DualExprNode{

	public EndColNode(ExprNode value1, ExprNode value2) {
		super(value1, value2);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
