package ast;

public class BoolNode extends FinalNode{
	protected boolean value;
	
	public BoolNode (boolean value) {
		this.value = value;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}