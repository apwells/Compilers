package ast;

public abstract class DeclNode extends Node{
	
	public abstract Object accept(Visitor v);

}
