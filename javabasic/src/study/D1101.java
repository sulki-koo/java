package study;

import java.util.Scanner;

public class D1101 {

	public static void main(String[] args) {

		// Extra 실습 ) 별찍기 2) 배열 사용
		// 3) 3이상의 홀수를 입력하면 최대 별의 개수가 입력한 별의 개수가 되는 다이아몬드 찍기 - 입력다이아..
		//    *
		//  ***
		// *****
		//  ***
		//    *
		

		
		// 1,3) 배열 미사용, 입력
//	    줄   i 0~4 번째
//		별   j 1 3 5 3 1 개
//		공백 k 2 1 0 1 2 개
		
		// k=(5-j)/2
		// k=|2(i의 중간값)-i|(절대값)
		// 절대값 구하는 메서드
//		int max = Math.abs(-3);
//		System.out.println(max);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("원하는 별의 개수 입력(3이상의 홀수)");
		
		int loopNum = scan.nextInt();
		int count = loopNum/2;
		
		for (int i = -count; i<=count; i++) {   // 줄수 - 5
				for (int k=0; k<=Math.abs(i);k++) { // 공백
					System.out.print("o");
				}
				for (int j=0; j<loopNum-(Math.abs(i)*2);j++) {
					System.out.print("*");
				}
				
				System.out.println();
			}
		scan.close();
		
		System.out.println("===예시===");
		
		for (int i = 0; i<loopNum; i++) {
			int num1 = Math.abs(loopNum/2-i);
			for (int k=0; k < num1;k++) { // 공백
				System.out.print("o");
			}
			for (int j=0; j< loopNum-2*num1;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("===2) 배열 별찍기===");
		int[][] starArr = {
				{0,0,1,0,0},
				{0,1,1,1,0},
				{1,1,1,1,1},
				{0,1,1,1,0},
				{0,0,1,0,0},
		};
		
		int starArrLength = starArr.length;
		int starArr0Length = starArr[0].length;
		
		for (int i=0;i<starArrLength;i++) {
			for (int j=0;j<starArr0Length;j++) {
				if (starArr[i][j]==0) System.out.print("o");
				else System.out.print("*");
			}System.out.println();
		}

	} // main

} // class
