package javabasic.excollection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		List<String> memoList = new ArrayList<String>();
		System.out.println("1.메모리트스 2.메모입력 3.메모삭제 4.종료");

		File file = new File("D:\\embededk\\files\\ex\\memo.dat");

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			ois = new ObjectInputStream(new FileInputStream(file));

			while (true) {
				int num = scan.nextInt();
				if (num == 1) {
					System.out.println("메모리스트입니다.");
					for (String list : memoList) {
						System.out.println(list);
					}
				} else if (num == 2) {
					System.out.println("메모내용을 입력하세요.");
					String note = scan.next();
					memoList.add(note);
					System.out.println(note);
				} else if (num == 3) {
					// 삭제
					System.out.println("삭제할 메모 번호를 입력하세요.");
					try {
						memoList.remove(scan.nextInt() - 1);
						System.out.println("삭제되었습니다.");
					} catch (IndexOutOfBoundsException iobe) {
						System.out.println("해당 번호의 메모가 없습니다.");
					}
				} else if (num == 4) {
					System.out.println("메모를 종료합니다.");
					System.exit(0);
					scan.close();
				}
				oos.writeObject(memoList);
				//List<String> memo = (List<String>) ois.readObject();
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
//		} catch (ClassNotFoundException cnfe) {
//			cnfe.printStackTrace();
		} finally {
			scan.close();
		}

	} // main

} // class
