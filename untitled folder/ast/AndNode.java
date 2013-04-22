package ast;

public class AndNode extends BinaryTermNode{
	
	public AndNode (TermNode term, FactorNode factor) {
		super(term, factor);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }


}
