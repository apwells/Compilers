package ast;

import java.util.*;

public class AccessorNode extends FinalNode{
	
	public ArrayList<String> ids;
	
	public AccessorNode(String id) {
		this.ids = new ArrayList<String>();
        this.ids.add(id);
		
	}
	
	public Object accept(Visitor v) {
		return v.visit(this);
	    }


}
