package javabasic.variable;

import java.io.BufferedReader; // BufferedReader Class 사용
import java.io.IOException;		// BufferedReader Class 사용
import java.io.InputStreamReader; // BufferedReader Class 사용

//import java.io.Console;  // Console Class 사용
//import java.util.Scanner; // Scanner Class 사용

public class Study1025 {

//	public static void main(String[] args) { // Console/Scanner Class 사용
	public static void main(String[] args) throws IOException {  // BufferedReader Class 사용
//-----형변환--------------------------------------------------------------------------------
//		int i = 100;
//		long l = 10000;
//		int i2 = (int)l;  // 강제형변환
//		System.out.println(i);
//		System.out.println(l);
//		System.out.println(i2);
//		
//		byte b = 65;
//		char c = (char)b;  // 바이트 수가 작아도 char는 정수가 아니므로 강제형변환
//		System.out.println(c);		
//-----콘솔--------------------------------------------------------------------------------
//		Console console = System.console();
//		
//		System.out.println("아이디 : ");
//		String id = console.readLine();
//		
//		System.out.println("패스워드 : ");
//		char[] charPass = console.readPassword();  //???
//		String strPassword = new String(charPass);
//		
//		System.out.println("-------------------------");
//		System.out.println("아이디 : "+id);
//		System.out.println("패스워드 : "+strPassword);
//-----스캐너---------------------------------------------------------------------------------	
//		Scanner scan = new Scanner(System.in);
//		
//		String ps = scan.nextLine();
//		System.out.println("You entered sting : "+ps);
//		
//		int pi = scan.nextInt();
//		System.out.println("You entered integer : "+pi);
//		
//		float pf = scan.nextFloat();
//		System.out.println("You entered float : "+pf);
//		
//		scan.close();
//------BufferedReader--------------------------------------------------------------------------------			
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		System.out.println("input : "+input);
	}

} // class