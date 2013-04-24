package ast;

public abstract class Node {
    
    public int line;
    public int column;
    
    public void setup(int line,int column)
    {
        this.line=line+1;
        this.column=column+1;
    }

}
