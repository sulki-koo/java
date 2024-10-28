package study;

public class ExLoopStatement1 {

	public static void main(String[] args) {

		for (int dan = 2; dan < 10; dan++) {

			for (int num = 1; num < 10; num++) {
				System.out.print(dan + "X" + num + "=" + (dan * num) + "\t");
			}
			System.out.println();
		}
	} // main

} // class
