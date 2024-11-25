package javabasic.exthread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class LogThread extends Thread {

	@Override
	public void run() {
		File file = new File("D:\\embededk\\files\\ex\\inputstring.log");
		Scanner scan = new Scanner(System.in);

		PrintWriter w = null;

		System.out.println("입력해주세요");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("[yyyy/ww/dd kk:mm:ss]");
			String input = sdf.format(System.currentTimeMillis()) + scan.next();
			w = new PrintWriter(new FileWriter(file, true));
			w.write(input);
			w.println();
			w.flush();
		} catch (IOException ie) {
			ie.printStackTrace();
		}

	} // run

} // class
