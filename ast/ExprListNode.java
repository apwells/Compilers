package ast;

import java.util.*;

public class ExprListNode extends Node {
	
	public List<ExprNode> expressions;
	
	public ExprListNode (List<ExprNode> expressions) {
		this.expressions = expressions;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
