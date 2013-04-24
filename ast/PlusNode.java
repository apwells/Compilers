package ast;

public class PlusNode extends ExprTermNode {

	public PlusNode(ExprNode value, TermNode term) {
		super(value, term);
		System.out.println("Value = " + value + ", Term = " + term);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
