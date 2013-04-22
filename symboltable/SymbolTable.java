package symboltable;

import java.util.ArrayList;
import java.util.Hashtable;

public class SymbolTable {
	
	private SymbolTable parent;
	private ArrayList<SymbolTable> children;
	private Hashtable<String, Object> table;
	
	public SymbolTable() {
		// Initialize
		table = new Hashtable<String, Object>();
	}
	
	public SymbolTable put (String key, Object value) {
		// Insert a new binding
		table.put(key, value);
		return this;
	}
	
	public Object get (String key) {
		// look up a binding
		return table.get(key);
	}
	
	public Object getRecursive(String key) {
		// Will look for a key in this table or any parent tables. (for scoping)
		if (table.get(key) == null) {
			return parent.getRecursive(key);
		} 
		return table.get(key);
	}
	
	public SymbolTable beginScope() {
		// Creates a new nested table
		SymbolTable newTable = new SymbolTable();
		newTable.setParent(this);
		children.add(newTable);
		return newTable;
		
	}
	
	public void setParent(SymbolTable parent) {
		this.parent = parent;
	}
	
	public SymbolTable endScope() {
		// Restore last table (does that mean it exits nested scope to return to parent scope?)
		return parent;
	}

}
