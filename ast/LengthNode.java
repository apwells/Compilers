package ast;

public class LengthNode extends FinalNode{
	protected ExprNode value;
	
	public LengthNode (ExprNode value) {
		this.value = value;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
