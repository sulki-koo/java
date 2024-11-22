package javabasic.exio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExBuffered1 {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\Administrator\\git\\java\\javabasic\\src\\javabasic\\exapi1\\gimi.txt");

		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader(file));
			bw = new BufferedWriter(new FileWriter(new File("D:\\embededk\\files\\ex\\gimi_copy.txt")));
			
			String str;

			while ((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // main

} // class
