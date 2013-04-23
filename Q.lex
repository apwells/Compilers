import java.util.*;
import java.io.*;
import java_cup.runtime.Symbol;

%%

%class Lexer
%unicode
%cup
%line
%column
%states INCOMMENT

%{
	QHelper h;
	public int getLine() { return yyline; }
	public int getCol() {return yycolumn; }
	private StringBuilder badinput = null;
%}

%init{
	h = new QHelper(this);
%init}


/* Macros */

Whitespace = [\ \t\n\r]+
NewLine = \r|\n|\r\n

LineComment = "//".*{NewLine}

Identifier = [:jletter:] [:jletterdigit:]*
BooleanLiteral = "true" | "false"
IntegerLiteral = ("-")?[:digit:]+
FloatLiteral = ("-")?[:digit:]+\.[:digit:]+
StringLiteral = "\"" ~"\"" 
CharLiteral = "'"."'"

%states ERROR

%%

<YYINITIAL> {

{Whitespace} {}
{LineComment} {}

// Types
"bool"				{return h.sym(sym.BOOL); }
"int"				  {return h.sym(sym.INT); }
"char"				{return h.sym(sym.CHAR); }
"float"				{return h.sym(sym.FLOAT); }
"string"			{return h.sym(sym.STRING); }
"list"				{return h.sym(sym.LIST); }
"void"				{return h.sym(sym.VOID);}

// Declarations
"fdef"				{return h.sym(sym.FDEF);}
"tdef"				{return h.sym(sym.TDEF);}

// Operators

// Logical Operators
"\!"				{return h.sym(sym.NOT); }
"||"				{return h.sym(sym.OR); }
"&&"				{return h.sym(sym.AND); }

// Numerical Operators
"\+"				{return h.sym(sym.PLUS); }
"-"					{return h.sym(sym.MINUS); }
"\*"				{return h.sym(sym.MULTIPLY); }
"/"					{return h.sym(sym.DIVIDE); }
"\^"				{return h.sym(sym.POWER); }

// Sequence Operators
"::"				{return h.sym(sym.CONCAT);}
"in"				{return h.sym(sym.IN); }
"len"				{return h.sym(sym.LENGTH); }

// Comparison Operators
"<"					{return h.sym(sym.LESSTHAN); }
"<="				{return h.sym(sym.LESSTHANEQUAL); }
">"					{return h.sym(sym.GREATERTHAN); }
">="				{return h.sym(sym.GREATERTHANEQUAL); }
"=="				{return h.sym(sym.EQUAL); }
"!="				{return h.sym(sym.NOTEQUAL); }

// Expression Operators
"."					{return h.sym(sym.DOT); }
"="					{return h.sym(sym.ASSIGN); }

// Structural Tokens
"{"					{return h.sym(sym.LEFTBRACE); }
"}"					{return h.sym(sym.RIGHTBRACE); }
"["					{return h.sym(sym.LEFTBRACKET); }
"]"					{return h.sym(sym.RIGHTBRACKET); }
"[|"				{return h.sym(sym.LEFTTBRACKET); }
"|]"				{return h.sym(sym.RIGHTTBRACKET); }
";"					{return h.sym(sym.SEMICOLON); }
":"					{return h.sym(sym.COLON); }
"("					{return h.sym(sym.LEFTPAREN); }
")"					{return h.sym(sym.RIGHTPAREN); }
","					{return h.sym(sym.COMMA); }

// Literals
{CharLiteral}	    {return h.parseChar(yytext());}
{BooleanLiteral}	{return h.parseBool(yytext());}
{FloatLiteral}		{return h.parseFloat(yytext());}
{IntegerLiteral}	{return h.parseInteger(yytext());}
{StringLiteral}		{return h.parseString(yytext());}

// Control Flow
"if"  				{return h.sym(sym.IF);}
"else"				{return h.sym(sym.ELSE);}
"repeat"			{return h.sym(sym.REPEAT);}
"while"				{return h.sym(sym.WHILE);}
"do"  				{return h.sym(sym.DO); }
"until"				{return h.sym(sym.UNTIL); }
"return"			{return h.sym(sym.RETURN); }

// Identifier
{Identifier}		{return h.sym(sym.ID, yytext());}

// Multiline Comment
"/*"       { yybegin(INCOMMENT); }

// Error Handling
.					{ 
						yybegin(ERROR);
       			badinput = new StringBuilder(yytext()); 
       		}
}

<INCOMMENT> {
"*/"      { yybegin(YYINITIAL); }
[^*\n]+   {} // eat comment in chunks
"*"       {} // eat the lone star
"\n"      {} 
}


<ERROR> {
[\{\}\(\);] | {Whitespace}
					{
						yypushback(1);
						yybegin(YYINITIAL);
						System.err.println("Error: unknown input " + badinput + " found at line " + yyline + ", character " + yycolumn);
					}
. 					{badinput.append(yytext());}
}
