package javabasic.exapi1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// gimi.txt 파일을 읽어 '독립'이라는 단어의 개수를 출력하고 모든 마침표 뒤에 줄바꿈을 한 후 파일의 모든 내용을 출렵합니다.

public class Gimi {
	
	public static void main(String[] args) {
		
		String gimi = getText();
		System.out.println(gimi);
		
	} // main
	
	private static String getText() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\git\\embededk\\javabasic\\src\\javabasic\\exapi1\\gimi.txt")));
			String line = "";
			String gimiTxt = "";
			while ((line=br.readLine())!=null) {
				gimiTxt += line;
			}
			br.close();
			return gimiTxt;
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			return null;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
} // class



















