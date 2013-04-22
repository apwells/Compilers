package ast;

import java.util.List;

public class AccessorNode extends FinalNode{
	
	public List<String> ids;
	
	public AccessorNode(List<String> ids) {
		this.ids = ids;
		
	}
	
	public Object accept(Visitor v) {
		return v.visit(this);
	    }


}
