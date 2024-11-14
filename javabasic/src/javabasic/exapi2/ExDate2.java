package javabasic.exapi2;

import java.util.Calendar;
import java.util.Scanner;

public class ExDate2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Calendar cal = Calendar.getInstance();// Calendar 객체 생성

		System.out.println("년도 4자리와 월 2자리를 입력해주세요."); 

		String find = scan.next();

		cal.set(Integer.parseInt(find.substring(0, 4)), // year 문자열을 정수로 변환
				Integer.parseInt(find.substring(4)) - 1, // month 문자열을 정수로 변환
				1);

		int week = cal.get(Calendar.DAY_OF_WEEK); // 1일의 요일을 구함
		// 입력받은 년, 월, 1일의 최대 day를 반환
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		printCalendar(week, lastDay);

		scan.close();
	} // main

	private static void printCalendar(int week, int lastDay) {
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		// 요일값 -1만큼 탭 만들기
		for (int i = 1; i < week; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= lastDay; i++) {
			System.out.print(i + "\t");
			if ((week + (i - 1)) % 7 == 0) {
				System.out.println();
			}
		}
	}
	
} // class
