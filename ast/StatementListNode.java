package ast;

import java.util.List;

public class StatementListNode extends Node {
	protected List<StmtNode> statements;
	
	public StatementListNode (List<StmtNode> statements) {
		this.statements = statements;
	}
}