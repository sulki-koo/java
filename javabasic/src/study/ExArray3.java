package study;

public class ExArray3 {

	public static void main(String[] args) {

		String[][] strArr = { 
				{ "홍길동", "강감찬", "이순신" }, 
				{ "국어", "영어", "수학" }, 
				{ "90", "80", "70", "60", "50", "40" } };

		int num1= Integer.parseInt(strArr[2][0]);
		int num2 = Integer.parseInt(strArr[2][1]);
		int num3 = Integer.parseInt(strArr[2][2]);
		int num4 = Integer.parseInt(strArr[2][3]);
		int num5 = Integer.parseInt(strArr[2][4]);
		int num6 = Integer.parseInt(strArr[2][5]);

			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num3);
			System.out.println(num4);
			System.out.println(num5);
			System.out.println(num6);

	} // main

} // class
