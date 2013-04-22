package ast;

public class ExponentNode extends FactorNode {
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
