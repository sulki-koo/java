package study;

import java.util.Scanner;

public class ExArray4 {

	public static void main(String[] args) {

//		이름1 국어점수 영어점수 수학점수
//		이름2 국어점수 영어점수 수학점수
//		이름3 국어점수 영어점수 수학점수

		Scanner scan = new Scanner(System.in); // 스캐너

		String[][] info = new String[3][4];
		int infoLength = info.length; // 행수 3
		int info0Length = info[0].length;   // 열수 4

		int[] score1 = { 0, 0, 0 }; // 총점을 구할 배열
		int score1Length = score1.length; // 행수 3

		// 이름 넣기
		for (int num = 0; num < infoLength; num++) {
			System.out.println((num+1)+"번째 학생의 이름을 입력하시오.");
			String name = scan.next();
			info[num][0] = name;
		}


		// 점수 입력
		for (int i = 0; i < infoLength; i++) {
			System.out.println(info[i][0]+"의 국어, 수학, 영어 점수를 차례로 입력하시오.");
			for (int j = 0; j < info0Length; j++) {
				if(j>0) {
				String score = scan.next();
				info[i][j] = score;}
			}
		}
		
		//  점수 합산
		for (int i = 0; i < infoLength; i++) {   //3
			for (int j = 0; j < info0Length; j++) {  //4
				if(j>0) {
				score1[i] += Integer.parseInt(info[i][j]);
				}
			}
		}

		// 총점 평균 프린트
		System.out.println();
		for (int i = 0; i < score1Length; i++) {
			System.out.println(info[i][0] + "의 총점은 " + score1[i] + "점, 평균은 " + score1[i] / score1Length + "점 입니다.");
		}

		scan.close();

	} // main

} // class
