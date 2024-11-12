package javabasic.api;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {

		String str1 = "안녕 하세요! 자바 졸지 마!";
		String str2 = "010-1234-5678";

		// 공백 delimiter 기준으로 분리하는 토크나이저
		StringTokenizer st1 = new StringTokenizer(str1);
		
		System.out.println(st1.countTokens());
		
		while(st1.hasMoreElements()) {
			System.out.println(st1.nextToken());
		}
		
		// - delimiter 기준으로 분리하는 토크나이저
		StringTokenizer st2 = new StringTokenizer(str2,"-");
		while(st2.hasMoreElements()) {
			System.out.println(st2.nextToken());
		}
		
		

	} // main

} // class
