package javabasic.exexception;

public class ExceptionTest1 {

	public static void main(String[] args) {

		// long 8byte / 전산학 gb = 1024*1024*1024
		// 현재 heap메모리 용량은 최대 2기가로 할당되어 있음 : -Xmx2048m
		// long[] longArr = new long[1024*1024*1024];

		// inputInfo메소드에서 객체를 생성함
		// 일정시간이 지나면 가비지컬렉터에서 필요없는 데이터 삭제
		// 계속 메모리를 소비하면 OutOfMemory error 발생될 수 있음
//		while (true) {
//			String name = "홍길동";
//			String job = "산적";
//			input1(name, job);
//		}

		input1("홍길동", "산적");
		
	} // main

	private static void input1(String name, String job) {
		new Person(name, job);
		System.out.println(name + job);
		input2(name, job); // StackOverflowError
	}

	private static void input2(String name, String job) {
		new Person(name, job);
		System.out.println(name + job);
		input1(name, job); // StackOverflowError
	}

} // class
