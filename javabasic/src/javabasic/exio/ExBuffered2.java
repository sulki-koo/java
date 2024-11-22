package javabasic.exio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExBuffered2 {

	public static void main(String[] args) {

		File file = new File("D:\\embededk\\files\\ex\\사진.jpg");

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(new FileOutputStream(new File("D:\\embededk\\files\\ex\\사진_copy.jpg")));
			
			byte[] bArr = new byte[1024];
			int readByte = 0;
			while((readByte = bis.read(bArr))>-1) {
				bos.write(bArr, 0, readByte);
			}
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // main

} // class
