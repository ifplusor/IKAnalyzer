package org.wltea.analyzer.sample;

import java.io.*;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class IKSegmenterDemo {
	
	public static void main(String[] args) {

		Reader in = null;
		try {
            in = new StringReader("这是一个中文分词的例子，你可以直接运行它！IKAnalyer can analysis english text too, haha");

			IKSegmenter _IKImplement = new IKSegmenter(in , true);
			
			Lexeme nextLexeme = null;
			while ((nextLexeme = _IKImplement.next()) != null) {
				System.out.println(nextLexeme.toString());
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Finished !");
	}
}