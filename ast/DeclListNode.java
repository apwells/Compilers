package ast;

import java.util.List;

public class DeclListNode {
	
	protected List<DeclNode> declarations;
	
	public DeclListNode (List<DeclNode> declarations) {
		this.declarations = declarations;
	}

}
