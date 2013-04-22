package ast;

public class PowerTermNode extends BinaryTermNode{
	
	public PowerTermNode (TermNode term, FactorNode factor) {
		super(term, factor);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }


}
