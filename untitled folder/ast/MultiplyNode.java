package ast;

public class MultiplyNode extends BinaryTermNode{
	
	public MultiplyNode (TermNode term, FactorNode factor) {
		super(term, factor);
	}
	
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

	

}
