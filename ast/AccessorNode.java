package ast;

import java.util.*;

public class AccessorNode extends FinalNode{
	
	public ArrayList<String> ids;

	
	public AccessorNode(String id) {
		this.ids = new ArrayList<String>();
        this.ids.add(id);
		
	}
	
	public String getWholeName() {
		String wholeName = "";
		int i = 1;
		
		for (String id : ids) {
			if (i ==1) {
				wholeName = wholeName + id;
			} else {
				wholeName = wholeName +"."+ id;
			}
			i++;
		}
		
		return wholeName;
	}
	
	public Object accept(Visitor v) {
		return v.visit(this);
	    }


}
