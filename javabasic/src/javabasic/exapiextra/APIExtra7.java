package javabasic.exapiextra;

public class APIExtra7 {

	public static void main(String[] args) {

		String str = Util.getLineText(1)[0];
		char[] chArr = str.toCharArray();

		for (char ch : chArr) {
			int iChar = (int) ch;
			if (iChar > 64 && iChar < 91) {  // 대문자 범위
				System.out.print((char) (iChar + 32));
			} else if (iChar > 96 && iChar < 123) {  // 소문자 범위
				System.out.print((char) (iChar - 32));
			}
		}

	}

}
