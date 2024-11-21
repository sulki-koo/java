package javabasic.exio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class EXConvBufferStream {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Writer writer = null;
		BufferedReader reader = null;

		try {

			File file = new File("D:/embededk/files/scanner1.txt");
			System.out.println("파일에 작성할 내용을 입력해주세요.");
			writer = new FileWriter(file);
			writer.write(scan.next());
			writer.flush();

			reader = new BufferedReader(new FileReader(file));

			System.out.println("scanner1.txt 내용: "+ reader.readLine());

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
