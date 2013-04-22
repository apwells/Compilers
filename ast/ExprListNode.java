package ast;

import java.util.List;

public class ExprListNode extends Node {
	
	protected List<ExprNode> expressions;
	
	public ExprListNode (List<ExprNode> expressions) {
		this.expressions = expressions;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
