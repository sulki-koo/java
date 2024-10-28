package study;

public class D1028 {

	public static void main(String[] args) {

		int i1 = 10;
		int i2 = 15;
		//          	조건		 ture 	: false
		int i3 = (i1 < i2) ? i2 - i1 : i1 - i2;

		System.out.println("i1은 " + i1 + " / i2는 " + i2);
		System.out.println("i3은 " + i3);
		boolean bool1 = true;
		boolean bool2 = false;
		System.out.println("ture에서 " + !bool1);
		System.out.println("false에서 " + !bool2);
		System.out.println();

		Object o = new Integer(i1);
		//if (i1 instanceof int) {}  // int 와 같은 primitive 연산 못 함
		if (o instanceof Integer) {
			System.out.println("ture");
		} else
			System.out.println("false");
	
		
		if ("Str" instanceof String) {
			System.out.println("ture");
		} else
			System.out.println("false");

	} // main

}  // class
