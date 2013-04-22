package ast;

public class TupleNode extends SequenceNode{
	protected ExprListNode value;
	
	public TupleNode (ExprListNode value) {
		this.value = value;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
