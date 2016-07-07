package org.wltea.analyzer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class IKAnalzyerDemo {
	
	public static void main(String[] args) {
		File file = new File("D:\\wd\\2.txt");
		File outFile = new File("D:\\wd\\out.txt");

		InputStream is = null;
		Reader in = null;
		FileWriter fw = null;
		try {
			is = new FileInputStream(file);
			in = new InputStreamReader(is, "GB2312");
			fw = new FileWriter(outFile);

			IKSegmenter _IKImplement = new IKSegmenter(in , true);
			
			Lexeme nextLexeme = null;
			while ((nextLexeme = _IKImplement.next()) != null) {
				fw.write(nextLexeme.toString() + "\n");
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
			
			try {
				if (is != null)
					is.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Finished !");
	}
}