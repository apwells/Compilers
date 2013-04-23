package ast;
import symboltable.SymbolTable;
import java.util.List;
import java.util.ArrayList;

import org.xml.sax.ErrorHandler;

import static java.util.Arrays.asList;

import ast.*;
import errors.Error;


public class TypeVisitor implements Visitor{
	
	private SymbolTable table;
	private Error error;
	private List<String> basics = new ArrayList<String>(asList("int", "float", "char", "bool", "string", "list", "tuple"));

	
	public TypeVisitor(SymbolTable table, Error error){
		table = table;
		this.error = error;
		
	}

	
	@Override
	public Object visit(AccessorNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AndNode n) {
		String type1 = (String) n.getTern().accept(this);
		String type2 = (String) n.getFactor().accept(this);
		return c
		// TODO Auto-generated method stub
		return null;
	}
	
	private String checkBoolean(String t, String f) {
		if(t.equals("bool") && f.equals("bool"))
			return "bool";
		
		Error.PrintError(t + " " + f, Error.Type.TYPE);
		return "error";
	}

	@Override
	public Object visit(AssignNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(BegColNode n) {
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
		table = table.beginScope();
		
		if(n.declarations != null){
			n.declarations.accept(this);
		}
		
		if(n.statements != null) {
			n.statements.accept(this);
		
		}
		table = table.endScope();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(BoolNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CharNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ConcatNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(BrkExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DatatypeNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DeclListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DeclNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DivideNode n) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(EqNode n) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FuncCallNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FuncCallStmtNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FuncDeclNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GreatThEqNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GreatThNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IfElseNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(InNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IntNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LengthNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LessThEqNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LessThNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MinExponentNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MinusNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MultiplyNode n) {
		if(n.term != null) {
			n.term.accept(this);
		}
		if(n.factor != null) {
			n.factor.accept(this);
		}
		if((n.term.)
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NoColNode n) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(OrNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ParamListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(PlusNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(PowerNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(PowerTermNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ProgramNode n) { 
		for(DeclNode d : n.declarations.declarations ){
			d.accept(this);
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ReturnStmtNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RptUntilNode n) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(TupleNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(TypeNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VarDeclNode n) {
		String id = n.getId();
		String type = n.getType();
		if(n.getDeclarations() != null) {
			if(basics.contains(type)){
				for(ExprNode e : n.declarations.expressions){
					String str = (String) e.accept(this);
					if(str == null) str = "string";
					if(!type.equals(str)) && !(type.equals("float") && str.equals(("init"))
							&& !(type.equals("int") && str.equals("bool"))
							&& !(type.equals("string") && str.equals("char"))
				}
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VarTypeNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WhileStmtNode n) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
