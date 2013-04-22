package ast;

public class EqNode extends ExprTermNode {

	public EqNode(ExprNode value, TermNode term) {
		super(value, term);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
