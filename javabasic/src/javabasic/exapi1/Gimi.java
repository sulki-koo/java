package javabasic.exapi1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// gimi.txt 파일을 읽어 '독립'이라는 단어의 개수를 출력하고 모든 마침표 뒤에 줄바꿈을 한 후 파일의 모든 내용을 출렵합니다.

public class Gimi {

	public static void main(String[] args) {

		String gimi = getText(); // 파일의 전체 텍스트를 저장
		// System.out.println(gimi); // 프린트

		// System.out.println(gimi.indexOf("독립") + ":첫번째/시작인덱스번호");
		// System.out.println(gimi.lastIndexOf("독립") + ":마지막/시작인덱스번호");

		int gimiLeng = gimi.length(); // 총길이
		int search = -1;
		int count = 0;
		while (search < gimiLeng) {
			search = gimi.indexOf("독립", search + 1);
			search += search;
			count++;
		}
		System.out.println("독립이라는 단어는 " + count + "번 나옵니다.\n");

		System.out.println(gimi.replace(".", ".\n"));

		// 예시
		// '독립' 문자열 인덱스를 탐색을 위한 시작 인덱스
		int idx = -1;
		// '독립' 문자열의 발생 횟수를 저장할 변수
		int count1 = 0;
		// idx = gimi.indexOf("독립",idx+1) => 0번 인덱스부터 "독립"의 인덱스를 찾아서 idx에 저장
		// indexOf는 문자열이 없으면 -1을 반환
		while ((idx = gimi.indexOf("독립", idx + 1)) >= 0) {
			count1++;
			System.out.println("'독립'의 " + count1 + "번쨰 인덱스 : " + idx + "\n");
		}
		// 발생 횟수를 출력
		System.out.println("'독립' 이라는 문자열은 " + count + "번 나옵니다!\n");

		// "." 문자열을 ".\n"로 대체
		// \\. => 정규표현식의 패턴문자열 (정규표현식에서 . 문자는 문자하나를 나타냄)
		System.out.println(gimi.replaceAll("\\.", ".\n"));

	} // main

	// 파일의 내용을 한 줄 씩 읽어서 모두 합쳐 리턴하는 메소드
	private static String getText() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(
					new File("C:\\Users\\Administrator\\git\\java\\javabasic\\src\\javabasic\\exapi1\\gimi.txt")));
			String line = "";
			String gimiTxt = "";
			while ((line = br.readLine()) != null) {
				gimiTxt += line;
			}
			br.close();
			return gimiTxt;
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			return null;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		}
	}

} // class
