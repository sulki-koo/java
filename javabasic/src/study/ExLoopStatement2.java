package study;

public class ExLoopStatement2 {

	public static void main(String[] args) {

		int x = 5;

		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			} // * 반복
			System.out.println();
		}	// 줄바꿈

	} // main

} // class
