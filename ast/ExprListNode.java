package ast;

import java.util.*;

public class ExprListNode extends Node {
	
	public ArrayList<ExprNode> expressions;
	
	public ExprListNode (ExprNode expression) {
        
		this.expressions = new ArrayList<ExprNode>();
        this.expressions.add(expression);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
