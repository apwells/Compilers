package ast;

public class GreatThNode extends ExprTermNode {

	public GreatThNode(ExprNode value, TermNode term) {
		super(value, term);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
