package study;

import java.util.Scanner;

public class ExConditionalStatement1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자 2개를 입력하시오!");
		int i = scan.nextInt();
		int j = scan.nextInt();
		System.out.println("합은 "+(i+j)+"이므로 "+((i+j>10) ?"10보다 크다":"10보다 크지 않다")); 
		
		scan.close();
	}
	
}
