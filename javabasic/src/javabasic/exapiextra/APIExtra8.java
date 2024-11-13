package javabasic.exapiextra;

public class APIExtra8 {

	public static void main(String[] args) {

		String str = Util.getLineText(1)[0];
		char[] chArr = str.toCharArray();

		int upCount = 0;
		int lowCount = 0;
		int numCount = 0;
		int markCount = 0;

		for (char ch : chArr) {
			int iChar = (int) ch;
			if (iChar > 64 && iChar < 91) { // 대문자 범위
				upCount++;
			} else if (iChar > 96 && iChar < 123) { // 소문자 범위
				lowCount++;
			} else if (iChar > 47 && iChar < 58) { // 숫자 범위
				numCount++;
			} else { // 나머지는 기호
				markCount++;
			}
		}

		System.out.println("대문자:" + upCount + "개, 소문자:" + lowCount + "개, 숫자:" + numCount + "개, 기호:" + markCount + "개");

	}

}
