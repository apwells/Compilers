package ast;

public class MinExponentNode extends ExponentNode{
	protected ExponentNode exponent;
	
	public MinExponentNode (ExponentNode exponent) {
		this.exponent = exponent;
	}

}
