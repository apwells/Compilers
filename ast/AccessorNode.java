package ast;

import java.util.List;

public class AccessorNode extends FinalNode{
	
	protected List<String> ids;
	
	public AccessorNode(List<String> ids) {
		this.ids = ids;
		
	}
	

}
