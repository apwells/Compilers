package ast;

public class VisitorAdapter implements Visitor{
	
    
	@Override
	public Object visit(AccessorNode n) {
		
		// TODO Auto-generated method stub
		return null;
	}
    
    
	@Override
	public Object visit(AssignNode n) {
		n.value.accept(this);
		System.out.print("=");
		n.var.accept(this);
		// TODO Auto-generated method stub
		return null;
	}
    
	@Override
	public Object visit(BegColNode n) {
		n.value1.accept(this);
		System.out.print("[:");
		n.value2.accept(this);
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
	    if(n.declarations!=null){
	    	for (DeclNode d : n.declarations.declarations){
	    		d.accept(this);
	    		
	    	}
        }
	    if(n.statements!=null){
	    	for (StmtNode s : n.statements.statements){
	    		s.accept(this);
	    		
	    	}
        }
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
		n.term.accept(this);
		System.out.print("+");
		n.factor.accept(this);
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
		n.value.accept(this);
		System.out.print("+");
		n.term.accept(this);
		return null;
	}
    
	@Override
	public Object visit(PowerNode n) {
		n.exponent.accept(this);
		System.out.print("^");
		n.factor.accept(this);
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
		n.block.accept(this);
		if(n.declarations!=null) n.declarations.accept(this);
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
		// TODO Auto-generated method stub
		return null;
	}
    
	@Override
	public Object visit(WhileStmtNode n) {
		// TODO Auto-generated method stub
		return null;
	}
    
	@Override
	public Object visit(AndNode n) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object visit(VarTypeNode n) {
		// TODO Auto-generated method stub
		return null;
	}
	
    
}
