package javabasic;

public class Variable1 {
	
	public static void main(String[] args) {
		
		// 자바의 기본타입 8가지
		// 기본타입 : 정수나 실수의 값을 기본 평가하는 타입
		//				만약 100이라는 정수가 있다면 int,
	    //				만약 3.14라는 실수가 있다면 double
		byte b = 1;	// 1바이트 정수, 값의 유효범위 -2^7 ~ 2^7-1
		short s =2;	// 2바이트 정수, 값의 유효범위 -2^15 ~ 2^15-1
		int i = 3;		// 4바이트 정수, 값의 유효범위 -2^31 ~ 2^31-1, 정수의 기본타입
		long l = 4;		// 8바이트 정수, 값의 유효범위 -2^63 ~ 2^63-1
		float f = 3.14f;	// 4바이트 실수, 3.14는 double이므로 3.14f라고 써서
								// 4바이트 3.14임을 알려줘야 함
		double d = 2.1;	// 8바이트 실수, 실수의 기본타입
		char c = 'A';		// 2바이트 유니코드 문자
		boolean bool = true;	// 1바이트, true 또는 false의 값만 가짐
		
	}
}
