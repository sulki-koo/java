package study;

import java.util.Scanner;

public class ExConsoleIO1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

//		System.out.println("첫번째 숫자 입력 : ");
//		int s1 = scan.nextInt();
//		System.out.println("두번째 숫자 입력 : ");
//		int s2 = scan.nextInt();
//		System.out.println("두 수의 곱셉 결과값은 " + (s1 * s2) + " 입니다.");
//
//		scan.close();

		System.out.println("곱셈하실 두 수를 입력해 주세요!");
		
		int firstInt = 0;
		int secondInt = 0;
		
		if (scan.hasNext()) {
			firstInt = scan.nextInt();
			secondInt = scan.nextInt();
		} // if
		
		System.out.println("두 수의 곱은 " + firstInt*secondInt + "입니다.");
		
		scan.close();
		
	} // mian

} // class
