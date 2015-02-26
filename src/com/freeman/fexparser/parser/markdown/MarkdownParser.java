package com.freeman.fexparser.parser.markdown;

import java.io.IOException;
import com.freeman.fexparser.parser.Parser;

public class MarkdownParser extends Parser {

	@Override
	public String parse(String raw) {
		String html;
		try {
			html = new Markdown4jProcessor().process(raw);
			System.out.println(html);
		} catch (IOException e) {
			html = null;
			e.printStackTrace();
		}
		return html;
	}
}
