package ast;

public class CharNode extends FinalNode{
	protected char value;
	
	public CharNode (char value) {
		this.value = value;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
