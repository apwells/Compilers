package ast;

public class FloatNode extends FinalNode{
	protected float value;
	
	public FloatNode (float value) {
		this.value = value;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
