package javabasic.exio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class EXIO3 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Student student1 = new Student(scan.next(), new Score(scan.next(), scan.next(), scan.next()));
		Student student2 = new Student(scan.next(), new Score(scan.next(), scan.next(), scan.next()));
		Student student3 = new Student(scan.next(), new Score(scan.next(), scan.next(), scan.next()));
		
		OutputStream os = null;
		Reader reader = null;
		
		try {
			File file = new File("D:\\\\embededk\\\\files\\\\student.dat");
			os = new FileOutputStream(file);
			os.write(student1.name.getBytes());
			os.write(student1.score.kor.getBytes());
			os.write(student1.score.eng.getBytes());
			os.write(student1.score.math.getBytes());
			
			os.flush();
			
			reader = new FileReader(file); 
			
			int i = 0;
			while ((i = reader.read()) > -1) {
				System.out.print((char) i);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				os.close();
				scan.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main

} // class
