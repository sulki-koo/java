package study;

import java.util.Scanner;

public class ExMethod3 {

	public static void main(String[] args) {
		// 바로 실행됨.........
		input();
	} // main

	// 입력
	static void input() {

		System.out.println("숫자 두개와 연산자를 차례로 입력하시오.");

		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		String str = scan.next();
		
		operation(num1,num2,str);
		
		scan.close();
	}
	
	// 연산
	static void operation(int i, int j, String str) {
		if (str.equals("+")) System.out.println(i+j);
		else if (str.equals("-")) System.out.println(i-j);
		else if (str.equals("*")) System.out.println(i*j);
		else if(str.equals("/")) System.out.println(i/j);
		else System.out.println("올바른 값을 입력하시오.");
	}
	


} // class
