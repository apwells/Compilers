package ast;

import java.util.*;

public class DeclListNode {
	
	public ArrayList<DeclNode> declarations;
	
	public DeclListNode (DeclNode declaration) {
		this.declarations = new ArrayList<DeclNode>();
        this.declarations.add(declaration);
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
