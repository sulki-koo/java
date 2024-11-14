package javabasic.oop;

import java.text.SimpleDateFormat;
import java.util.Date;

// java.text.SimpleDateFormat
// 날짜/시간 정보를 원하는 문자열 형태로 변경할 때 주로 사용

public class SimpleDateFormatTest {

	public static void main(String[] args) {

		Date now = new Date(); // 현재 날짜/시간 정보를 가진 Date객체
		System.out.println(now);
		
		// 날짜/시간 표시 형식 SimpleDateFormat객체 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
		System.out.println(sdf.format(now));
		
		
		
	}  // main

}  // class

/*
 * "yyyy.MM.dd G 'at' HH:mm:ss z"	
 * "EEE, MMM d, ''yy"
 * "h:mm a"
 * "hh 'o''clock' a, zzzz"
 * "K:mm a, z"
 * "yyyyy.MMMMM.dd GGG hh:mm aaa"
 * "EEE, d MMM yyyy HH:mm:ss Z"
 * "yyMMddHHmmssZ"	
 * "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
 * "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"	
 * "YYYY-'W'ww-u"
 */
