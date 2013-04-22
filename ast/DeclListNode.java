package ast;

import java.util.List;

public class DeclListNode {
	
	public List<DeclNode> declarations;
	
	public DeclListNode (List<DeclNode> declarations) {
		this.declarations = declarations;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	    }

}
