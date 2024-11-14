package javabasic.exapiextra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class APIExtra10 {

	public static void main(String[] args) {

		String americadoi = getText(); // 파일의 전체 텍스트를 저장
		// System.out.println(americadoi); // 프린트

		String reText = americadoi.replaceAll("[가-힣\\p{Punct}]", "");
		// System.out.println(reText);

		String[] reTextArr = reText.split(" ");
		int count = 0;
		for (String str : reTextArr) {
			if (!str.isBlank()) {
				count++;
			}
		}

		String[] okArr = new String[count];
		int index = 0;
		for (String str : reTextArr) {
			if (!str.isBlank()) {
				okArr[index++] = str;
			}
		}

		Arrays.sort(okArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		System.out.println(Arrays.toString(okArr));
	} // main

	// 파일의 내용을 한 줄 씩 읽어서 모두 합쳐 리턴하는 메소드
	private static String getText() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File(
					"C:\\Users\\Administrator\\git\\java\\javabasic\\src\\javabasic\\exapiextra\\americadoi.txt")));
			String line = "";
			String americadoiTxt = "";
			while ((line = br.readLine()) != null) {
				americadoiTxt += line;
			}
			br.close();
			return americadoiTxt;
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			return null;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		}
	}

} // class
