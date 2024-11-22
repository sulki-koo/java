package javabasic.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedTest {

	public static void main(String[] args) {

		File file = new File("D:\\embededk\\files\\buffered.dat");

		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;

		try {
			bos = new BufferedOutputStream(new FileOutputStream(file));
			
			// 1024(=Kilo)*1024(=Maga)*1024(=Giga)*1024(=Tera)*1024(=Peta)
			byte[] byteArr = new byte[1024*1024*1024]; // 1G
			
			int byteArrLeng = byteArr.length;
			for(int i=0; i<byteArrLeng; i++) {
				byteArr[i] = (byte)i;
			}
			bos.write(byteArr);

			bis = new BufferedInputStream(new FileInputStream(file));
			byte[] readArr = new byte[1024*1024*1024];
			int readArrLeng = readArr.length;
			bis.read(readArr);
			for(int i=0; i<readArrLeng; i++){
				System.out.print(readArr[i]);
			}
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // main

} // class
