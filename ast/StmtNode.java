package ast;

public abstract class StmtNode {
	
	public abstract Object accept(Visitor v);


}
