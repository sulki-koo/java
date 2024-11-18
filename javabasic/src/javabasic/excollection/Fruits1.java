package javabasic.excollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Fruits1 {

	public static void main(String[] args) {

		List<String> fruitList = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);

		System.out.println("5개의 과일명을 입력하세요");
		for (int i = 0; i < 5; i++) {
			fruitList.add(scan.next());
		}
		System.out.println(fruitList);

		Iterator<String> it = fruitList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		scan.close();
		
	} // main

} // class
