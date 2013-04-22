package ast;

public class NotEqNode extends ExprTermNode {

	public NotEqNode(ExprNode value, TermNode term) {
		super(value, term);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
