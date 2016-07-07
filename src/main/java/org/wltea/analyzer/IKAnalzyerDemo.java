package org.wltea.analyzer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class IKAnalzyerDemo {
	
	public static void main(String[] args) {
		Reader in = new StringReader("IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。");
		IKSegmenter _IKImplement = new IKSegmenter(in , true);
		try {
			Lexeme nextLexeme = null;
			while ((nextLexeme = _IKImplement.next()) != null) {
				System.out.println(nextLexeme.getBeginPosition() + " - "
						+ nextLexeme.getEndPosition() + " : " + nextLexeme.getLexemeText());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}