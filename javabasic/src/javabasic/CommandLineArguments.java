package javabasic;

public class CommandLineArguments { // 명령 행 인자

	// String[] args : 명령행 인자 배열
	// main 실행 시 main 메소드에 전달할 문자열들
	public static void main(String[] args) {

		System.out.println("첫번재 명령행인자는: " + args[0]);
		System.out.println("두번재 명령행인자는: " + args[1]);
		System.out.println("세번재 명령행인자는: " + args[2]);
		
		
	} // main

} // class
