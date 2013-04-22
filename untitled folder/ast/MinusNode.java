package ast;

public class MinusNode extends ExprTermNode {

	public MinusNode(ExprNode value, TermNode term) {
		super(value, term);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
