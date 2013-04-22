all:
	/Users/m3t/Downloads/jflex-1/jflex-1.4.3/bin/jflex Q.lex
	java java_cup.Main Q.cup
	javac ast/*.java Lexer.java parser.java sym.java QC.java


clean:
	rm -f ast/*.class Lexer.java parser.java sym.java *.class *~