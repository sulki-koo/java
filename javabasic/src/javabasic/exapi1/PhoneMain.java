package javabasic.exapi1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PhoneMain {

	// Scanner를 통해 5명의 이름과 휴대폰번호를 입력받고 출력
	// 입력형식은 '홍길동 010-1234-5678'으로 하고
	// 출력시에는 이름 5개, 국번 5개, 앞자리5개, 뒷자리5개를 각각 출력합니다.

	static String[][] infoArr = new String[5][4];

	public static void main(String[] args) {

		System.out.println("5명의 이름과 휴대폰번호를 입력해 주세요!");
		System.out.println("형식:홍길동 000-0000-0000");

		inputInfo();  // 데이터 저장 메서드 호출

		printInfo();  // 데이터 출력 메서드 호출

	} // main

	private static void inputInfo() {
		Scanner scanner = new Scanner(System.in); 	// 스캐너 생성

		int infoArrLeng = infoArr.length;  // 배열 행의 수
		String line = "";  // 사용자가 입력한 한 줄의 문자열을 저장할 변수

		for (int i = 0; i < infoArrLeng; i++) {  // 행의 수 만큼 반복
			line = scanner.nextLine();   // line에 스캔받은 값 저장
			//이름을 각 행의 첫번째 열에 저장
			// ex) '홍길동 010-1234-5678' 입력 => 홍길동
			infoArr[i][0] = line.substring(0, line.indexOf(' '));  // 문자 빈칸의 인덱스를 반환
			
			// 위에서 구한 문자 빈칸의 인덱스 값+1부터 "-"의 전까지를 반환
			// 그 문자열을 st에 잘라서 넣음
			// 휴대폰번호를 - 기준으로 자르는 토크나이저 생성
			// ex) 010-1234-5678 > 010 1234 5678
			StringTokenizer st 
				= new StringTokenizer(line.substring(line.indexOf(' ') + 1), "-");  
			// 열 인덱스
			int j = 1;
			// 토큰이 더이상 없을때까지 반복
			while (st.hasMoreTokens()) {
				// 자른 문자열을 배열에 차례로 저장
				// 국번, 앞자리번호, 뒷자리번호 배열에 저장
				infoArr[i][j] = st.nextToken();
				j++;
			}
		}
		scanner.close();
	} // inputInfo

	private static void printInfo() {
		int infoArrLeng = infoArr.length;  // 행의 수
		int infoArr0Leng = infoArr[0].length;  // 열의 수
		for (int i = 0; i < infoArr0Leng; i++) {  // 열의 수 만큼 반복
			for (int j = 0; j < infoArrLeng; j++) {  // 행의 수 만큼 반복
				System.out.print(infoArr[j][i] + " "); // 00 10 20 30 01 11 21 31  
			}
			System.out.println();
		}

	} // main

} // class
