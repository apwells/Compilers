package ast;

public class PowerNode extends FactorNode{
	protected ExponentNode exponent;
	protected FactorNode factor;
	
	public PowerNode (ExponentNode exponent, FactorNode factor) {
		this.exponent = exponent;
		this.factor = factor;
	}

}
