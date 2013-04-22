package ast;

public class ConcatNode extends ExprTermNode {

	public ConcatNode(ExprNode value, TermNode term) {
		super(value, term);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
