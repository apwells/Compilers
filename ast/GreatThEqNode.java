package ast;

public class GreatThEqNode extends ExprTermNode {

	public GreatThEqNode (ExprNode value, TermNode term) {
		super(value, term);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
