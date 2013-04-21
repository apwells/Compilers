package ast;

public class BinaryTermNode extends TermNode{
	
	protected TermNode term;
	protected FactorNode factor;
	
	public BinaryTermNode (TermNode term, FactorNode factor) {
		this.term = term;
		this.factor = factor;
	}
}
