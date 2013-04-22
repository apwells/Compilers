package ast;

public class TermNode extends ExprNode{
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
