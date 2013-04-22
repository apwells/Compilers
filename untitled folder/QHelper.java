/**
 *	Helper class for creating symbol objects 
 *
 */

import java_cup.runtime.*;

class QHelper {
	Lexer lex;

	public QHelper(Lexer lex) {
		this.lex = lex;
	}

	/**
	 * Returns symbol object containing a Boolean.
	 * 
	 * @param yytext
	 * @return Symbol object
	 */
	public Symbol parseBool(String yytext) {
		return sym(sym.BOOLLITERAL, yytext.equals("true"));
	}

	/**
	 * Returns symbol object containing a char.
	 * 
	 * @param yytext
	 * @return Symbol object
	 */
	public Symbol parseChar(String yytext) {
		return sym(sym.CHARLITERAL, yytext.charAt(1));
	}

	/**
	 * Returns symbol object containing an integer.
	 * 
	 * @param yytext
	 * @return Symbol object
	 */
	public Symbol parseInteger(String yytext) {
		return sym(sym.INTLITERAL, Integer.parseInt(yytext));
	}

	/**
	 * Returns symbol object containing a float.
	 * 
	 * @param yytext
	 * @return Symbol object
	 */
	public Symbol parseFloat(String yytext) {
		return sym(sym.FLOATLITERAL, Float.parseFloat(yytext));
	}

	/**
	 * Returns symbol object containing a string. The leading and following
	 * quotes are trimmed from the string.
	 * 
	 * @param yytext
	 * @return Symbol object
	 */
	public Symbol parseString(String yytext) {
		return sym(sym.STRINGLITERAL, yytext.substring(1, yytext.length() - 1));
	}

	/**
	 * Creates a symbol object containing its type and position in source code.
	 * 
	 * @param type
	 * @return Symbol object
	 */
	public Symbol sym(int type) {
		return new Symbol(type, lex.getLine(), lex.getCol());
	}

	/**
	 * Creates a symbol object containing its type and position in source code
	 * and value associated with token.
	 * 
	 * @param type
	 * @param value
	 * @return
	 */
	public Symbol sym(int type, Object value) {
		return new Symbol(type, lex.getLine(), lex.getCol(), value);
	}
}
