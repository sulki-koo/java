package javabasic.exio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ExCharStream {

	public static void main(String[] args) {

		Writer writer = null;
		BufferedReader reader = null;

		try {
			File file = new File("D:/embededk/files/name.txt");
			writer = new FileWriter(file);
			writer.write("Koo Sul-ki");
			writer.flush();

			reader = new BufferedReader(new FileReader(file));

			System.out.println(reader.readLine());

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
