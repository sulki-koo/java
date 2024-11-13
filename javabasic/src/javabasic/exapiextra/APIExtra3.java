package javabasic.exapiextra;

import java.util.StringTokenizer;

public class APIExtra3 {

	public static void main(String[] args) {

//		String str = Util.getLineText(1)[0];
//		String[] strArr = new String[5];
//
//		StringTokenizer st = new StringTokenizer(str, " ");
//		int i = 0;
//		while (st.hasMoreElements()) {
//			strArr[i] = st.nextToken();
//			i++;
//		}
//
//		char[] charArr = strArr[2].toCharArray();
//
//		int sum = 0;
//		for (char ch : charArr) {
//			System.out.println((int) ch);
//			sum += (int) ch;
//		}
//		System.out.println(sum);

		// 예시

		String[] strArr = Util.getLineText(5);
		System.out.println((int) strArr[2].charAt(0));

	} // main

} // class
