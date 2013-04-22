package ast;

public class ExponentNode {
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
