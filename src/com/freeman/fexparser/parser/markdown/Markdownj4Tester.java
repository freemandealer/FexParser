package com.freeman.fexparser.parser.markdown;
import java.io.IOException;

public class Markdownj4Tester {
	
	public static void main(String args[]) throws IOException{
		String html = new Markdown4jProcessor().process("##hello");
		System.out.print(html);
	}
}
