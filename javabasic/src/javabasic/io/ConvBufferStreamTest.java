package javabasic.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ConvBufferStreamTest {

	public static void main(String[] args) {

		OutputStream os = null;
		InputStream is = null;
		Writer writer = null;
		Reader reader = null;

		try {

			File file = new File("D:\\embededk\\files\\file4.dat"); // 파일 객체 생성
			os = new FileOutputStream(file);

			// 바이트단위 출력스트림을 문자단위 출력으로 변환하는 변환스트림
			writer = new OutputStreamWriter(os);
			writer.write(65);
			writer.flush();

			is = new FileInputStream(file);

			// 바이트단위 입력스트림을 문자단위 입력스트림으로 변환하는 변환스트림
			reader = new InputStreamReader(is);
			System.out.println((char) reader.read());

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				reader.close();
				is.close();
				writer.close();
				os.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main

} // class
