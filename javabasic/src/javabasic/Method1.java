package javabasic;

public class Method1 {

	public static void main (String[] args) {
		
		/*
		   메서드 실행 순서
		   1) main 호출
		   2) print 호출
		   3) print내의 println 호출
		   4) add 호출
		   5) main내의 println 호출
		 */
		
		// main에서 print메서드를 호출
		print("Hello Java!"); // Method1. 이 생략된 것
		Method1.print("Hi Java!");
		
		//main에서 add메서드를 호출
		System.out.println(add(10, 20));  // add 앞에 Method1. 이 생략된 것
		System.out.println(Method1.add(10, 20));
		
		// main메서드가 return;하면 프로그램이 종료
		return;
	}  // main
	
	// static : 객체 생성없이 클래스로 접근(호출)할 수 있는 메서드
	// void : 반환값이 없다
	// String str : 파라미터(parameter) 변수 = 매개변수
	static void print(String str) {
		System.out.println(str);
		// return; : 리턴값이 없을때는 return; 구문을 생략가능하다
		// 하지만, 생략하면 return 구문을 넣어준다. 즉, 모든 메서드는 리턴구문을 가지고 있다.
	}
	
	// int : 반환타입 (메서드 실행 후 반환할 값의 타입)
	// return 값; : 메서드 실행 후 값을 호출한 쪽으로 반환
	static int add(int a, int b) {
		return a + b;
	}
	
	
}  // class
