package ast;

public class LessThEqNode extends ExprTermNode {

	public LessThEqNode(ExprNode value, TermNode term) {
		super(value, term);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
