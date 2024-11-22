package javabasic.exio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ExPrint {

	public static void main(String[] args) {

		File file1 = new File("D:\\embededk\\files\\ex\\perintStream.dat");
		
		PrintStream ps = null;
		
		try {
			ps = new PrintStream(new FileOutputStream(file1));
			ps.print("print");
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		
		PrintWriter pw = null;
		File file2 = new File("D:\\embededk\\files\\ex\\perintWriter.txt");
		
		try {
			pw = new PrintWriter(new FileWriter(file2));
			pw.print("writer");
			pw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		
	}  // main

}  // class
