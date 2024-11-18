package javabasic.excollection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Fruits2 {

	public static void main(String[] args) {

		Set<String> fruitSet = new HashSet<String>();
		Scanner scan = new Scanner(System.in);

		System.out.println("5개의 과일명을 입력하세요");
		while (fruitSet.size() != 5) {
			fruitSet.add(scan.next());
		}

		System.out.println(fruitSet);

		Iterator<String> it = fruitSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		scan.close();

	} // main

} // class
