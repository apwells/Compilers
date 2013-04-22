package ast;

import java.util.*;

public class ExprListNode extends Node {
	
	public ArrayList<ExprNode> expressions;
	
	public ExprListNode (ArrayList<ExprNode> expressions) {
		this.expressions = expressions;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
