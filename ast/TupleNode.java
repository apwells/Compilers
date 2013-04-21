package ast;

public class TupleNode extends SequenceNode{
	protected ExprListNode value;
	
	public TupleNode (ExprListNode value) {
		this.value = value;
	}

}
