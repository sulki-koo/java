package javabasic.exapi2;

import java.util.Calendar;
import java.util.Scanner;

public class ExCalendar {

	public static void main(String[] args) {

		System.out.println("달력을 표시할 년을 4자리로 입력해 주세요!");
		printCalendar(inputYear());

	} // main

	public static int inputYear() {
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
		scan.close();
		return year;
	}

	public static void printCalendar(int year) {
		Calendar cal = Calendar.getInstance();

		for (int month = 0; month < 12; month++) {
			cal.set(year, month, 1);

			System.out.println(year + "년 " + (month+1) + "월");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			int week = cal.get(Calendar.DAY_OF_WEEK);

			for (int i = 1; i < week; i++) {
				System.out.print("\t");
			}

			for (int i = 1; i < lastDay; i++) {
				System.out.print(i + "\t");
				if (((week+(i-1))% 7) == 0) {
					System.out.println();
				}
			}
			System.out.println("\n\n");
		}

	}

} // class
