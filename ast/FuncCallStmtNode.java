package ast;

public class FuncCallStmtNode extends StmtNode {
	protected FuncCallNode function;
	
	public FuncCallStmtNode(FuncCallNode func) {
		this.function=func;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
