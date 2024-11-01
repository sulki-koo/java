package study;

import java.util.Scanner;

public class ExMethod3 {

	public static void main(String[] args) {
		input();
	} // main

	// 입력
	static void input() {

		System.out.println("숫자 두개와 연산자를 차례로 입력하시오.");

		Scanner scan = new Scanner(System.in);
//		int num1 = scan.nextInt();                  // 한번만 사용하는 변수...
//		int num2 = scan.nextInt();
//		String str = scan.next();
//		operation(num1,num2,str);

		operation(scan.nextInt(), scan.nextInt(), scan.next());

		scan.close();
	}  // input

	// 연산 + 프린트
	static void operation(int i, int j, String str) {
		if (str.equals("+")) System.out.println(i + j);
		else if (str.equals("-")) System.out.println(i - j);
		else if (str.equals("*")) System.out.println(i * j);
		else if (str.equals("/")) System.out.println(i / j);
		else System.out.println("올바른 값을 입력하시오.");
	}  // operation

} // class
