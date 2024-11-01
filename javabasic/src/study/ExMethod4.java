package study;

import java.util.Scanner;

public class ExMethod4 {

	
	public static void main(String[] args) {
		inputStarNum();
	} // main

	// 입력
	static void inputStarNum() {

		System.out.println("별의 개수를 입력하시오.");

		Scanner scan = new Scanner(System.in);
		star(scan.nextInt());
		scan.close();
	}  // input
	
	// 출력
	static void star(int i) {
		for (int j=0; j<i;j++) {
			for (int k=0;k<j+1;k++) {
				System.out.print("*");
			}System.out.println(" ");
		}
		System.out.println("마지막 행에 입력한 별의 개수는 "+ i + " 개 입니다.");
	}  // star
	
}  // class
