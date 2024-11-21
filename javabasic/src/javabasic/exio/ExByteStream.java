package javabasic.exio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExByteStream {

	public static void main(String[] args) {

		OutputStream os = null;
		InputStream is = null;

		try {

			os = new FileOutputStream(new File("D:/embededk/files/byte.dat"));
			os.write(65);
			os.flush();

			is = new FileInputStream(new File("D:/embededk/files/byte.dat"));
			System.out.println((char) is.read());

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main

} // class
