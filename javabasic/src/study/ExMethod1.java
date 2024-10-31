package study;

public class ExMethod1 {

	public static void main(String[] args) {

		biggerInt(30, 30);

	} // main

	static void biggerInt(int a, int b) {
		if (a > b) {
			System.out.println(a + "은 "+b +" 보다 크다.");
		} else if (b > a) {
			System.out.println(b + "은 "+ a +" 보다 크다.");
		} else {
			System.out.println("두 값은 같다.");
		}
	}

} // class
