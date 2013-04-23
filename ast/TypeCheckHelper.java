package ast;

import symboltable.SymbolTable;

public class TypeCheckHelper {
	
	public boolean isBool(ExprNode term, SymbolTable currentScope) throws ClassCastException {
		
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
			//System.out.println("Detected that term was a bool literal!");
			return true;
		}
		
		if (isId != null) {
			//System.out.println("Detected that term was a ID (could be of type bool)!");
			for (String id : isId.ids) {
				VarTypeNode node = (VarTypeNode)currentScope.getRecursive(id);	// May throw exception... Try catch?
				if (node.type.type == "bool") {
					//System.out.println("OMG IT WAS A FUCKING BOOL AFTER ALL!");
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public boolean isInt(ExprNode node, SymbolTable currentScope) {
		
		IntNode myInt = null;
		String type= "";
		
		try {
			myInt = (IntNode) node;
			if (myInt != null) {
				return true;
			}
		} catch (ClassCastException e) {
			
		}
		
		try {
			AccessorNode isId = (AccessorNode) node;
			type = getAccessorType(isId, currentScope);
			if (type == "int") {return true;}
		} catch (ClassCastException e) {}
	
		return false;
	}
	
	public boolean isFloat(ExprNode node, SymbolTable currentScope) {
		FloatNode myFloat = null;
		String type = "";
				
		try {
			myFloat = (FloatNode) node;
			if (myFloat != null) {
				return true;
			}
		} catch (ClassCastException e){
			// Wasn't a float node
		}
		
		try {
			AccessorNode isId = (AccessorNode) node;
			type = getAccessorType(isId, currentScope);
			if (type == "float") {return true;}
		} catch (ClassCastException e) {
			// Wasn't an accessor of type float
		}
		
		return false;
	}
	
	public boolean isNum(ExprNode node, SymbolTable currentScope) {
		if (isInt(node, currentScope) || isFloat(node, currentScope)) {
			return true;
		}
		return false;
	}
	
	public boolean isString(ExprNode node, SymbolTable currentScope) {
		
		StringLitNode stringLit = null;
		String type = "";
		
		try {
			stringLit = (StringLitNode) node;
			if (stringLit != null) {
				return true;
			}
		} catch (ClassCastException e){
			// Wasn't a float node
		}
		
		try {
			AccessorNode isId = (AccessorNode) node;
			if (getAccessorType(isId, currentScope) == "string") {return true;}
		} catch (ClassCastException e) {
			// Wasn't an accessor of type float
		}
		
		return false;
	}
	
	/*
	 *  This method attempts to give the type of any given ExprNode... Should have made this first.
	 *  REMEMBER : Could also be a function! So check for literals, Ids and Functions. (do for FuncCallStmt)
	 */
	public String getType (Node node, SymbolTable currentScope) {
		/*
		 *  Int, Float <= (numbers)
		 *  String, Char
		 *  String, Tuple, List
		 *  boolean
		 */
		
		StringLitNode stringLit = null;
		IntNode intLit = null;
		FloatNode floatLit = null;
		BoolNode boolLit = null;
		CharNode charLit = null;
		TupleNode tupleLit = null;
		ListNode listLit = null;
		
		AccessorNode accessor = null;
		//String type = "";
		
		// One of these will return if we've sent a literal
		try { stringLit = (StringLitNode) node; if (stringLit!=null) { return "string"; } } catch (ClassCastException e) {}
		try { intLit = (IntNode) node; if (intLit!=null) { return "int"; } } catch (ClassCastException e) {}
		try { floatLit = (FloatNode) node; if (floatLit!=null) { return "float"; } } catch (ClassCastException e) {}
		try { boolLit = (BoolNode) node; if (boolLit!=null) { return "bool"; } } catch (ClassCastException e) {}
		try { charLit = (CharNode) node; if (charLit!=null) { return "char"; } } catch (ClassCastException e) {}
		try { tupleLit = (TupleNode) node; if (tupleLit!=null) { return "tuple"; } } catch (ClassCastException e) {}
		try { listLit = (ListNode) node; if (listLit!=null) { return "list"; } } catch (ClassCastException e) {}
		
		// Now if it's an accessor or function
		try { accessor = (AccessorNode) node; 
			TypeNode typeNode = (TypeNode) currentScope.getRecursive(accessor.getWholeName());
			return typeNode.type;
		} catch (ClassCastException e) {}
		
		return "type not found";
		
	}
	
	public boolean isChar(Node node, SymbolTable currentScope) {
		if (getType(node, currentScope) == "char") {
			return true;
		}
		return false;
	}
	
	public String getAccessorType (AccessorNode node, SymbolTable currentScope) {
		
		if (node != null) {
			try {
				VarTypeNode varType = (VarTypeNode) currentScope.getRecursive(node.getWholeName());
				return varType.type.type;
			} catch (NullPointerException e) {
				// Will throw exception if the node we originally sent wasn't an accessor (like if we run this on the number 6 or something..
			}
		}
		
		//System.out.println("Error in TypeCheckHelper. Node was null. Don't send null nodes to getAccessorType!");
		return "getAccessorType error : null node";
		
	}

}
