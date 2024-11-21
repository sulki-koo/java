package javabasic.exio;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class EXIO1 {

	public static void main(String[] args) {

		Reader reader = null;

		try {

			File file = new File("C:\\Users\\Administrator\\git\\java\\javabasic\\src\\javabasic\\exapi1\\gimi.txt");

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
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main

} // class
