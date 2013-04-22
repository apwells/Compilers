package ast;

public class DivideNode extends BinaryTermNode{
	
	public DivideNode (TermNode term, FactorNode factor) {
		super(term, factor);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }


}
