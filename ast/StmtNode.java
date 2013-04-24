package ast;

public abstract class StmtNode extends Node{
	
	public abstract Object accept(Visitor v);


}
