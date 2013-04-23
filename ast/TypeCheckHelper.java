package ast;

import symboltable.SymbolTable;

public class TypeCheckHelper {
	
	public boolean checkForBool(TermNode term, SymbolTable currentScope) throws ClassCastException {
		
		BoolNode isBool = null;
		AccessorNode isId = null;
		
		try {
		isBool = (BoolNode) term;
		} catch (ClassCastException e) { 
		}
		
		try {
			isId = (AccessorNode) term;
		} catch (ClassCastException e) { } 
		
		if (isBool != null) {
			System.out.println("Detected that term was a bool literal!");
			return true;
		}
		
		if (isId != null) {
			System.out.println("Detected that term was a ID (could be of type bool)!");
			for (String id : isId.ids) {
				VarTypeNode node = (VarTypeNode)currentScope.getRecursive(id);	// May throw exception... Try catch?
				if (node.type.type == "bool") {
					System.out.println("OMG IT WAS A FUCKING BOOL AFTER ALL!");
					return true;
				}
			}
		}
		
		return false;
		
	}

}
