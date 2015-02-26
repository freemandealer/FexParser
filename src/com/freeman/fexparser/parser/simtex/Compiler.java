package com.freeman.fexparser.parser.simtex;

import java.io.IOException;

import com.freeman.fexparser.parser.Parser;

/**
 * <p>
 * The main class of the program. Used as a driver for the lexical, syntax, and
 * semantic analyzers.
 * </p>
 * <p/>
 * <p>
 * Reads in a .mkd file written in the compiler language and compiles it to html
 * code
 * </p>
 * 
 * @author Freeman Zhang
 */
public class Compiler extends Parser{

	public static final ParseTree tree = new ParseTree();
	private static final SyntaxAnalyzer syntax = new SyntaxAnalyzer();
	public static Tokens.TagObject nextToken;
	public static LexicalAnalyzer lexer;
	public static String htmlString = "";
	private static SemanticAnalyzer semant;

	public String parse(String contents) {

		StringBuffer sb = new StringBuffer(contents);
		int index13;
		/**
		 * Sigh.. Index13 points to real daemons! In ANSI, '\n'(0xA) is the end
		 * of the line. Our parser works well. However, textarea of HTML gives
		 * us '\n\r'(0xA,0xD), which confuses our parser. But don't worry, I'll
		 * delete them.
		 */
		while (true) {
			index13 = contents.indexOf(13);
			if (index13 == -1)
				break;
			sb.deleteCharAt(index13);
			contents = sb.toString();
		}
		contents = contents + ' ';
		System.out.println(contents);
		// initialize lexer
		lexer = new LexicalAnalyzer(contents);
		lexer.lex();
		syntax.start();
		// initialize sematic analyzer
		semant = new SemanticAnalyzer(tree);
		semant.run();
		// write html file
		System.out.println(Compiler.htmlString); // TODO
		return Compiler.htmlString;
	}
}
