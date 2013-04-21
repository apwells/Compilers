package ast;

public class BrackExprNode extends FinalNode{
	protected ExprNode value;
	
	public BrackExprNode (ExprNode value) {
		this.value = value;
	}

}
