package symboltable;

import java.util.Hashtable;

public class SymbolTable {
	
	private SymbolTable parent;
	private ArrayList children;
	
	public SymbolTable() {
		// Initialize
		
	}
	
	public SymbolTable put (String key, Object value) {
		// Insert a new binding
	}
	
	public Object get (String key) {
		// look up a binding
	}
	
	public SymbolTable beginScope() {
		// Creates a new nested table
		
		SymbolTable newTable = new SymbolTable();
		
	}
	
	public void endScope() {
		// Not sure if should be void
		// Restore last table (does that mean it exits nested scope to return to parent scope?)
	}

}
