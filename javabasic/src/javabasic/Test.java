package javabasic;

// Java Test용 클래스
public class Test {

	public static void main(String[] args) {

		int i = 3;
		Integer integer = 3;  // wrapping, 기본타입의 값을 가진 참조 타입을 생성(3을 Integer로 자동 대입) - 형변환이 아님
		int j = integer;  // unwrapping, 참조 타입에서 기본타입의 값을 꺼냄(integer를 int로 자동 대입) - 형변환이 아님
		
		
	} // main

} // class
