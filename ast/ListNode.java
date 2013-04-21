package ast;

public class ListNode extends SequenceNode{
	protected ExprListNode values;
	
	public ListNode(ExprListNode values) {
		this.values = values;
	}

}
