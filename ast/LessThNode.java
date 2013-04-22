package ast;

public class LessThNode extends ExprTermNode {

	public LessThNode(ExprNode value, TermNode term) {
		super(value, term);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
