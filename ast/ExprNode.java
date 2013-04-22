package ast;

public abstract class ExprNode extends Node{
	
	public abstract Object accept(Visitor v);

}
