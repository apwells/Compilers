package ast;

import symboltable.SymbolTable;

public class TypeCheckHelper {
	
	public boolean isBool(Node node, SymbolTable currentScope) throws ClassCastException {
		
		try {
			if (getType(node, currentScope) == "bool") {
				return true;
			}
		} catch (Exception e) {}
		return false;
		
	}
	
	public boolean isInt(Node node, SymbolTable currentScope) {
		
		try {
			if (getType(node, currentScope) == "int") {
				return true;
			}
		} catch (Exception e) {}
		return false;
	}
	
	public boolean isFloat(Node node, SymbolTable currentScope) {
		try {
			if (getType(node, currentScope) == "float") {
				return true;
			}
		} catch (Exception e) {}
		return false;
	}
	
	public boolean isNum(Node node, SymbolTable currentScope) {
		if (isInt(node, currentScope) || isFloat(node, currentScope)) {
			return true;
		}
		return false;
	}
	
	public boolean isString(Node node, SymbolTable currentScope) {
		
		try {
			if (getType(node, currentScope) == "string") {
				return true;
			}
		} catch (Exception e) {}
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
			VarTypeNode typeNode = (VarTypeNode) currentScope.getRecursive(accessor.getWholeName());
			//System.out.println(" *** Type is " + typeNode.type.type + " *** ");
			return typeNode.type.type;
		} catch (ClassCastException e) { 
			//System.out.println (" EXCEPTION !! " + e);
		}
		
		return "type not found";
		
	}
	
	/*
	 *  Returns the type of the elements in the list. Checks that the seuqnce all have the same type (unless its a tuple).
	 */
	public String checkSequence(SequenceNode node, SymbolTable currentScope) {
		
		ListNode list = null;
		String type = "";
		try {list = (ListNode) node;} catch (Exception e) {}
		
		if (list != null) {
			for (ExprNode listItem : list.values.expressions) {
				if (type != "") {
					try {
						if (type != getType(listItem, currentScope)) { System.out.println("TCH : List found to be inconsistent"); return "BAD LIST"; }
					} catch (Exception e) {
						System.out.println ("Exception in checkSequence : " + e);
					}
				} else {
					try {
						type = getType(listItem, currentScope);	// First item of list sets the type
						System.out.println("TCH : Checking list. First item found to be " + type);
					} catch (Exception e) {
						System.out.println ("Exception in checkSequence : " + e);
					}
				}
			}
			
		}
		
		return type;
		
	}
	
	public boolean isChar(Node node, SymbolTable currentScope) {
		try {
			if (getType(node, currentScope) == "char") {
				return true;
			}
		} catch (Exception e) {}
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
