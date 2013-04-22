package ast;

public class ExprTermNode extends ExprNode{
	
	protected ExprNode value;
	protected TermNode term;
	
	public ExprTermNode (ExprNode value, TermNode term) {
		this.value = value;
		this.term = term;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
