package ast;

public class StringLitNode extends SequenceNode{
	protected String value;
	
	public StringLitNode (String value) {
		this.value = value;
	}

}
