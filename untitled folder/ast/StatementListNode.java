package ast;

import java.util.List;

public class StatementListNode extends Node {
	public List<StmtNode> statements;
	
	public StatementListNode (List<StmtNode> statements) {
		this.statements = statements;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
