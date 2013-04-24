package ast;

import symboltable.SymbolTable;
import errors.*;
import errors.Error;

public class ScopeVisitor implements Visitor {
	
	private SymbolTable rootTable;
	private SymbolTable currentScope;
	private TypeCheckHelper typeHelp;
	
	public ScopeVisitor(){
		rootTable = new SymbolTable();
		typeHelp = new TypeCheckHelper();
		currentScope = rootTable;
	}
	
	    
		@Override
		public Object visit(AccessorNode n) {
			
			String wholeName = n.getWholeName();
			
				
				if (currentScope.getRecursive(wholeName) == null) {
					Error.PrintError(wholeName, Error.Type.NOTDECLARED);
				}
				System.out.print(wholeName);

				
			// TODO Auto-generated method stub
			return null;
		}
	    
	    
		@Override
		public Object visit(AssignNode n) {
			n.value.accept(this);
//			if (typeHelp.isInt(n.value, currentScope)) {
//				System.out.print("FOUND INT");
//			}
//			System.out.print("=");
//			n.var.accept(this);
//			if (typeHelp.isInt(n.var, currentScope)) {
//				System.out.print("FOUND INT");
//			}
			if (currentScope.getRecursive(n.var.getWholeName()) != null) {
				// Found it in symbol table
				System.out.println("Var for assignment was found");
			} else {
				Error.PrintError("Assignment error : ", Error.Type.NOTDECLARED);
			}
			
			
			System.out.println(";");

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(BegColNode n) {
			n.value1.accept(this);
			System.out.print("[:");
			n.value2.accept(this);
			System.out.print("]");
			
			if(typeHelp.getType(n.value1, currentScope) != "string" 
					&& typeHelp.getType(n.value1, currentScope) != "tuple"
					&& typeHelp.getType(n.value1, currentScope) != "list"
					){
				Error.PrintError("in VALUE1 of BEGCOL expression", Error.Type.TYPE);
			}
			if(typeHelp.getType(n.value2, currentScope) != "int") {
				Error.PrintError("in VALUE2 of BEGCOL expression", Error.Type.TYPE);
				
			}
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(BinaryTermNode n) {
			
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(BlockNode n) {
			
			currentScope = currentScope.beginScope();
			System.out.println("Began new scope");
			
			if (n.declarations!=null){
				n.declarations.accept(this);
			}
			if (n.statements!=null){
				n.statements.accept(this);
			}
			
			currentScope = currentScope.endScope();
			System.out.println("Exited current scope");

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(BoolNode n) {
			//System.out.print("%%%BOOL%%%");
			// n.accept(this);
			System.out.print(n.value);
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(CharNode n) {
			System.out.println("Charnode visit called!");
			// n.accept(this);
			System.out.print(n.value);
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(ConcatNode n) {
			
			//System.out.println("**************CONCAT :: VAlue = " +  n.value.toString() + " Term = "+ n.term.toString());
			n.value.accept(this);
			System.out.print("::");
			
			n.term.accept(this);
			System.out.println(";");

			if(typeHelp.getType(n.term, currentScope) != "string" 
					&& typeHelp.getType(n.term, currentScope) != "tuple"
					&& typeHelp.getType(n.term, currentScope) != "list"
					){
				Error.PrintError("in TERM of CONCAT expression", Error.Type.TYPE);
			}
			
			if(typeHelp.getType(n.value, currentScope) != "string" 
					&& typeHelp.getType(n.value, currentScope) != "tuple"
					&& typeHelp.getType(n.value, currentScope) != "list"
					){
				Error.PrintError("in VALUE of CONCAT expression", Error.Type.TYPE);
			}
			
			String list1Type = "";
			String list2Type = "";
			
			if (typeHelp.getType(n.term, currentScope) == "list") {
				
				if (typeHelp.isAccessor(n.value, currentScope)) {
					//System.out.println("8888888888888888");
					// Its an accessor. Look it up, get its sequenceNode, then run checkSequence on it.
					AccessorNode access = (AccessorNode) n.value;
					VarDeclNode varDecl = (VarDeclNode) currentScope.getRecursive(access.getWholeName());
					SequenceNode seq = (SequenceNode) varDecl.declarations.expressions.get(0);
					//System.out.println("------- ----- --- seq is "+seq.toString());
					// Store list type
					list1Type = typeHelp.checkSequence(seq, currentScope);
				}
			}
			//System.out.println(" --- ---- -- - - TYPE IS  " + typeHelp.getType(n.term, currentScope));
			//System.out.println(n.term.toString());
			if (typeHelp.getType(n.term, currentScope) == "list") {
				
				if (typeHelp.isAccessor(n.term, currentScope)) {
					// Its an accessor. Look it up, get its sequenceNode, then run checkSequence on it.
					AccessorNode access = (AccessorNode) n.term;
					VarDeclNode varDecl = (VarDeclNode) currentScope.getRecursive(access.getWholeName());
					SequenceNode seq = (SequenceNode) varDecl.declarations.expressions.get(0);
					//System.out.println("------- ----- --- seq is "+seq.toString());
					// Store list type
					list2Type = typeHelp.checkSequence(seq, currentScope);
				}
			}
			
			if (list1Type != list2Type) {
				Error.PrintError("You must concat 2 lists of the same type! on line " , Error.Type.TYPE);
			} else {
				// System.out.println("LISTS ARE THE SAME TYPE! CONCAT!");
			}
			
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(DatatypeNode n) {
			System.out.print(n.id);
			System.out.print(":");
			n.params.accept(this);
			System.out.println(";");
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(DeclListNode n) {
			for(DeclNode d : n.declarations){
				d.accept(this);
			}
			
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object visit(ListNode n) {
			System.out.print("[");
			n.values.accept(this);
			System.out.print("]");
			
			if(typeHelp.checkSequence(n, currentScope) != "bool") {
				Error.PrintError("in VALUE2 of THREEEXPRNODE expression", Error.Type.TYPE);
				
			}
			return null;

			
		}
	    
		@Override
		public Object visit(DeclNode n) {
			
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(DivideNode n) {
			n.term.accept(this);
			System.out.print(" / ");
			n.factor.accept(this);
			if((typeHelp.isNum(n.term, currentScope) == false)|| typeHelp.isNum(n.factor, currentScope) == false){
				Error.PrintError("in DIVIDE expression", Error.Type.TYPE);
			}
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(DualExprNode n) {
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(EndColNode n) {
			
			n.value1.accept(this);
			System.out.print("[");
			n.value2.accept(this);
			System.out.print(":]");
			
			if(typeHelp.getType(n.value1, currentScope) != "string" 
					&& typeHelp.getType(n.value1, currentScope) != "tuple"
					&& typeHelp.getType(n.value1, currentScope) != "list"
					){
				Error.PrintError("in VALUE1 of ENDCOL expression", Error.Type.TYPE);
			}
			if(typeHelp.getType(n.value1, currentScope) != "int") {
				Error.PrintError("in VALUE2 of ENDCOL expression", Error.Type.TYPE);
				
			}
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(EqNode n) {
			
			String termType = typeHelp.getType(n.term, currentScope);
			String valueType = typeHelp.getType(n.value, currentScope);
			
			if (termType != valueType) {
				if (termType != "int" && termType != "float" && valueType != "int" && termType != "float") {
					if (!typeHelp.isPrimitive(termType) && !typeHelp.isPrimitive(valueType)) {
						Error.PrintError("in EQUAL expression!!!", Error.Type.TYPE);
					}
				}
			}
			n.value.accept(this);
			System.out.print(" == ");
			n.term.accept(this);
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(ExponentNode n) {
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(ExprListNode n) {
			for(ExprNode a : n.expressions){
				//System.out.println("ssssize!"+n.expressions.size());
				a.accept(this);
			}
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(ExprNode n) {
			
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(ExprTermNode n) {
			
			n.term.accept(this);
			n.value.accept(this);

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(FactorNode n) {
			
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(FinalNode n) {
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(FloatNode n) {
			System.out.print(n.value);
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(FuncCallNode n) {
			System.out.println("Function " + n.id + " called. Checking if exists in scope");
			if (currentScope.getRecursive(n.id) != null) {
				// This has been defined
				System.out.println("has been defined. Continuing happily");
				n.params.accept(this);
			} else {
				Error.PrintError(n.id, Error.Type.NOTDECLARED);
				n.params.accept(this);
			}
//			System.out.print(n.id);
//			System.out.print("(");
//			n.params.accept(this);
//			System.out.print(")");

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(FuncCallStmtNode n) {
			n.function.accept(this);
			System.out.print(";");

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(FuncDeclNode n) {
			//System.out.print("fdef ");
			System.out.println("Function declaration found. Checking symbol table...");
			if (currentScope.getRecursive(n.id) != null) {
				Error.PrintError(n.id, Error.Type.DECLARED);
			} else {
				System.out.println("Function has not been declared before. Saving and continuing happily");
				currentScope.put(n.id, n);
				

				
			}
			//System.out.print(n.id);
			currentScope = currentScope.beginScope();	// We make a new scope for the params
			
			for (VarTypeNode param : n.params.params) {
				if (currentScope.getRecursive(param.id) != null) {
					Error.PrintError(param.id, Error.Type.DECLARED);
				} else {
					System.out.println("Saving param");
					currentScope.put(param.id, param.type);
				}
			}
			
			//System.out.print("(");
			n.params.accept(this);
			//System.out.print(")");
			//System.out.print(" : ");
			n.type.accept(this);
			n.block.accept(this);
			currentScope = currentScope.endScope();
			// TODO Auto-generated method stub
			return null;
			
			
			
			
		}
	    
		@Override
		public Object visit(GreatThEqNode n) {
			
			
			String termType = typeHelp.getType(n.term, currentScope);
			String valueType = typeHelp.getType(n.value, currentScope);
			
			if (termType != valueType) {
				if (termType != "int" && termType != "float" && valueType != "int" && termType != "float") {
					if (!typeHelp.isPrimitiveNoBool(termType) && !typeHelp.isPrimitiveNoBool(valueType)) {
						Error.PrintError("in GREATERTHANEQUAL expression!!!", Error.Type.TYPE);
					}
				}
			}
			
			n.value.accept(this);
			System.out.print(" >= ");
			n.term.accept(this);
			
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(GreatThNode n) {
			
			String termType = typeHelp.getType(n.term, currentScope);
			String valueType = typeHelp.getType(n.value, currentScope);
			
			if (termType != valueType) {
				if (termType != "int" && termType != "float" && valueType != "int" && termType != "float") {
					if (!typeHelp.isPrimitiveNoBool(termType) && !typeHelp.isPrimitiveNoBool(valueType)) {
						Error.PrintError("in GREATER expression!!!", Error.Type.TYPE);
					}
				}
			}
			n.value.accept(this);
			System.out.print(" > ");
			n.term.accept(this);
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(IfElseNode n) {
			System.out.print("if ");
			System.out.print("(");
			n.cond.accept(this);
			System.out.print(")");
			System.out.println("{");
			n.body.accept(this);
			System.out.print("}");
			System.out.print(" else ");
			System.out.println("{");
			n.elsebody.accept(this);
			System.out.println("}");

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(InNode n) {

			n.value.accept(this);
			System.out.print(" in ");
			n.term.accept(this);

			if(typeHelp.isBool(n.value, currentScope) == false 
					&& typeHelp.isNum(n.value, currentScope) == false
					&& typeHelp.isChar(n.value, currentScope) == false
					){
				Error.PrintError("in VALUE of IN expression", Error.Type.TYPE);
			}
			if(typeHelp.getType(n.term, currentScope) != "string" 
					&& typeHelp.getType(n.term, currentScope) != "tuple"
					&& typeHelp.getType(n.term, currentScope) != "list"
					){
				Error.PrintError("in TERM of IN expression", Error.Type.TYPE);
			}
			if(typeHelp.getType(n.term, currentScope) != "list")
				if((typeHelp.isBool(n.value, currentScope) == true && typeHelp.checkSequence((SequenceNode) n.term, currentScope) != "bool")
						||(typeHelp.isInt(n.value, currentScope) == true && typeHelp.checkSequence((SequenceNode) n.term, currentScope) != "int")
						||(typeHelp.isFloat(n.value, currentScope) == true && typeHelp.checkSequence((SequenceNode) n.term, currentScope) != "float")
						||(typeHelp.isChar(n.value, currentScope) == true && typeHelp.checkSequence((SequenceNode) n.term, currentScope) != "char")){
					Error.PrintError("- Value does not match term in IN expression", Error.Type.TYPE);
				}
			
			if(typeHelp.getType(n.value, currentScope) == "string" && typeHelp.isChar(n.value, currentScope) != true){
				Error.PrintError("String only takes characters in IN", Error.Type.TYPE);

				
			}
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(IntNode n) {
			System.out.print(n.value);
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(LengthNode n) {
			// TODO : Should we relaly be accepting these ones? Or will it form a stackoverflow/inf loop?
			System.out.print("len ");
			System.out.print("(");
			n.value.accept(this);
			System.out.print(")");

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(LessThEqNode n) {
			
			String termType = typeHelp.getType(n.term, currentScope);
			String valueType = typeHelp.getType(n.value, currentScope);
			
			if (termType != valueType) {
				if (termType != "int" && termType != "float" && valueType != "int" && termType != "float") {
					if (!typeHelp.isPrimitiveNoBool(termType) && !typeHelp.isPrimitiveNoBool(valueType)) {
						Error.PrintError("in LESSTHANEQUAL expression!!!", Error.Type.TYPE);
					}
				}
			}
			n.value.accept(this);
			System.out.print(" <= ");
			n.term.accept(this);
			
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(LessThNode n) {
			
			String termType = typeHelp.getType(n.term, currentScope);
			String valueType = typeHelp.getType(n.value, currentScope);
			
			if (termType != valueType) {
				if (termType != "int" && termType != "float" && valueType != "int" && termType != "float") {
					if (!typeHelp.isPrimitiveNoBool(termType) && !typeHelp.isPrimitiveNoBool(valueType)) {
						Error.PrintError("in LESSTHAN expression!!!", Error.Type.TYPE);
					}
				}
			}
			n.value.accept(this);
			System.out.print(" < ");
			n.term.accept(this);
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(MinExponentNode n) {
			System.out.print(" - ");
			n.exponent.accept(this);

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(MinusNode n) {
			n.value.accept(this);
			System.out.print(" - ");
			n.term.accept(this);
			
			if((typeHelp.isNum(n.term, currentScope) == false)|| typeHelp.isNum(n.value, currentScope) == false){
				Error.PrintError("in MINUS expression", Error.Type.TYPE);
			}

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(MultiplyNode n) {
			n.term.accept(this);
			System.out.print(" * ");
			n.factor.accept(this);
			if((typeHelp.isNum(n.term, currentScope) == false)|| typeHelp.isNum(n.factor, currentScope) == false){
				Error.PrintError("in MULTIPLY expression", Error.Type.TYPE);
			}
			return null;
		}
	    
		@Override
		public Object visit(NoColNode n) {
			n.value1.accept(this);
			System.out.print("[");
			n.value2.accept(this);
			System.out.print("]");
			
			if(typeHelp.getType(n.value1, currentScope) != "string" 
					&& typeHelp.getType(n.value1, currentScope) != "tuple"
					&& typeHelp.getType(n.value1, currentScope) != "list"
					){
				Error.PrintError("in VALUE1 of NOCOL expression", Error.Type.TYPE);
				System.out.println("** "+n.value1.toString());
			}
			if(typeHelp.getType(n.value2, currentScope) != "int") {
				Error.PrintError("in VALUE2 of NOCOL expression", Error.Type.TYPE);
				
			}

			


			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(Node n) {
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(NotEqNode n) {
			String termType = typeHelp.getType(n.term, currentScope);
			String valueType = typeHelp.getType(n.value, currentScope);
			
			if (termType != valueType) {
				if (termType != "int" && termType != "float" && valueType != "int" && termType != "float") {
					if (!typeHelp.isPrimitive(termType) && !typeHelp.isPrimitive(valueType)) {
						Error.PrintError("in EQUAL expression!!!", Error.Type.TYPE);
					}
				}
			}
			n.value.accept(this);
			System.out.print(" != ");
			n.term.accept(this);

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(NotExprNode n) {
			System.out.print(" ! ");
			n.value.accept(this);
			
			if(typeHelp.isBool(n.value, currentScope) == false) {
				Error.PrintError("in VALUE of NOTEXPR expression", Error.Type.TYPE);
				
			}

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(OrNode n) {
			n.value.accept(this);
			System.out.print(" || ");
			n.term.accept(this);
			System.out.println("term is " + n.term.toString() + " and val is " + n.value.toString());
			if((typeHelp.isBool(n.term, currentScope) == false)|| typeHelp.isBool(n.value, currentScope) == false){
				Error.PrintError("in OR expression", Error.Type.TYPE);
			}

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(ParamListNode n) {
			for(VarTypeNode a : n.params)
			{
				a.accept(this);
			}
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(PlusNode n) {
			
			n.value.accept(this);
			System.out.print(" + ");
			n.term.accept(this);
			if((typeHelp.getType(n.term, currentScope) != "int")
					|| (typeHelp.getType(n.value, currentScope) != "float"
					|| (typeHelp.getType(n.term, currentScope) != "int")
					|| typeHelp.getType(n.value, currentScope) != "float")){
				Error.PrintError("in Plus expression", Error.Type.TYPE);
			}
			
//			if (!typeHelp.isNum(n.term, currentScope)) {
//				System.out.println("Term is NaN");
//				System.out.println(n.term.toString());
//			}
//			
//			if (!typeHelp.isNum(n.value, currentScope)) {
//				System.out.println("value is NaN");
//				System.out.println(n.value.toString());
//			}
			
			return null;
		}
	    
		@Override
		public Object visit(PowerNode n) {
			n.exponent.accept(this);
			System.out.print("^");
			n.factor.accept(this);
			if((typeHelp.isNum(n.exponent, currentScope) == false)|| typeHelp.isNum(n.factor, currentScope) == false){
				Error.PrintError("in POWER expression", Error.Type.TYPE);
			}
			return null;
		}
	    
		@Override
		public Object visit(PowerTermNode n) {
			n.term.accept(this);
			System.out.print("^");
			n.factor.accept(this);
			return null;
		}
	    
		@Override
		public Object visit(ProgramNode n) {
			if (n==null) { System.out.println("Null programnode!");}
			n.declarations.accept(this);
			n.block.accept(this);
			return null;
		}
	    
		@Override
		public Object visit(ReturnStmtNode n) {
			System.out.print("return ");
			n.value.accept(this);
			
			System.out.println(" ; ");


			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(RptUntilNode n) {
			System.out.print("repeat ");
			System.out.print("{");
			n.body.accept(this);
			System.out.print("}");
			System.out.print(" until ");
			System.out.print("(");
			n.cond.accept(this);
			System.out.print(")");
			System.out.print(";");

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(SequenceNode n) {
			
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(StatementListNode n) {
			for(StmtNode a : n.statements)
			{
				a.accept(this);
			}
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(StmtNode n) {
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(StringLitNode n) {
			System.out.print(n.value);
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(TermNode n) {
			
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(ThreeExprNode n) {
			n.value1.accept(this);
			System.out.print("(");
			n.value2.accept(this);
			System.out.print(" : ");
			n.value3.accept(this);
			System.out.print(")");
			
			if(typeHelp.getType(n.value1, currentScope) != "string" 
					&& typeHelp.getType(n.value1, currentScope) != "tuple"
					&& typeHelp.getType(n.value1, currentScope) != "list"
					){
				Error.PrintError("in VALUE1 of THREEEXPRNODE expression", Error.Type.TYPE);
			}
			if(typeHelp.getType(n.value2, currentScope) != "int") {
				Error.PrintError("in VALUE2 of THREEEXPRNODE expression", Error.Type.TYPE);
				
			}
			if(typeHelp.getType(n.value3, currentScope) != "int") {
				Error.PrintError("in VALUE3 of THREEEXPRNODE expression", Error.Type.TYPE);
				
			}

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(TupleNode n) {
			System.out.print("[");
			n.value.accept(this);
			System.out.print("]");


			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(TypeNode n) {
			System.out.print(n.type);
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(VarDeclNode n) {

			
			//System.out.println("VARIABLE DECLARATION\n\n");
			
			if (currentScope.get(n.id.id) != null) {
				Error.PrintError(n.id.id, Error.Type.DECLARED);
				n.id.accept(this);
			} else {
				System.out.println("Saving new variable " + n.id.id + " to current scope in symbol table as " + n.toString());
				currentScope.put(n.id.id, n);
				
			}
			
			n.id.accept(this);
			System.out.print(" = ");
			n.declarations.accept(this);
			
			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(WhileStmtNode n) {
			System.out.print(" while ");
			System.out.print("(");
			n.body.accept(this);
			System.out.print(")");
			System.out.print(" do ");
			System.out.println(" { ");
			n.cond.accept(this);
			System.out.print("}");

			// TODO Auto-generated method stub
			return null;
		}
	    
		@Override
		public Object visit(AndNode n) {
			
			
			
			n.term.accept(this);
			System.out.println("AndNode :: "+n.term.toString());

			System.out.print(" && ");
			n.factor.accept(this);
			
			if((typeHelp.isBool(n.term, currentScope) == false) || typeHelp.isBool(n.factor, currentScope) == false){
				Error.PrintError("in AND expression", Error.Type.TYPE);
			}

			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public Object visit(VarTypeNode n) {
			System.out.print(n.id);
			System.out.print(" : ");
			n.type.accept(this);
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public Object visit(BrkExprNode n) {
			System.out.print("(");
			n.value.accept(this);
			System.out.print(")");

			// TODO Auto-generated method stub
			return null;
		}
		
	    
	}

