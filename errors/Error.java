package errors;

public class Error {
	
	public static void PrintError(String error){
		System.out.println("ERROR : " + error);
	}
	
	/*
	 * 	Scope Errors
	 */

	public static void VariableAlreadyDeclared(){
		PrintError("Variable Already Declared");
	}
	
}
