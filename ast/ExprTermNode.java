package ast;

public class ExprTermNode extends Node{
	
	protected ExprNode value;
	protected TermNode term;
	
	public ExprTermNode (ExprNode value, TermNode term) {
		this.value = value;
		this.term = term;
	}

}
