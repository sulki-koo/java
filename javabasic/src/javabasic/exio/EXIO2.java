package javabasic.exio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class EXIO2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Writer writer = null;
		Reader reader = null;
		
		System.out.println("파일명을 입력해주세요.");
		String fileName = scan.next();

		try {
			File file = new File("D:/embededk/files/"+fileName+".txt");

			System.out.println("파일에 작성할 내용을 입력해주세요.");
			writer = new FileWriter(file);
			writer.write(scan.next());
			writer.flush();

			reader = new FileReader(file); 

			int i = 0;
			while ((i = reader.read()) > -1) {
				System.out.print((char) i);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
				scan.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main

} // class
