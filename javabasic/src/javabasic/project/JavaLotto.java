package javabasic.project;

import java.util.Scanner;
import java.util.StringTokenizer;

// 능력단위평가 - 11/6 제출
// Java Lotto : 개인 Java 프로젝트
// [Lotto 프로그램 구현]

// 1. 기능
// 1) 사용자에게 1~45 중 중복되지 않은 6개의 정수를 입력받는다.
// 2) 중복되지 않은 7개의 정수를 랜덤하게 뽑아낸다. (앞의 6개는 로또번호, 7번재는 보너스번호)
// 3) 로또 당첨규칙에 따라서 사용자의 당첨등수를 출력한다.

// 2. 규칙
// 1) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽀은 앞의 6개 번호가 모두 일치하면 1등
// 2) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호 중 5개가 일치하고
//     보너스번호가 일치하면 2등
// 3) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호 중 5개가 일치 3등
// 4) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호 중 4개가 일치 4등
// 5) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호 중 3개가 일치 5등
// 6) 나머지는 꽝! 다음기회에!

// 3. 출력 예시
// 로또번호를 6개를 입력해 주세요!
// 21 3 8 9 40 33
// 추첨번호는 3 8 33 22 10 34 (보너스번호:45)
// 5등입니다!

public class JavaLotto {

	public static void main(String[] args) {

		// 랜덤정수 추출
		// Math.random() : 0.0<=n<1.0 범위의 실수를 반환
		// int randomNumber = (int) (Math.random() * 10) + 1; // 1~10

		// 문자열 토크나이징(자르기)
		// 한 라인의 문자열 입력
		// String line = scanner.nextLine();

		// 문자열을 공백문자 기준으로 토크나이징(토큰으로 분리)
		// StringTokenizer st = new StringTokenizer(line);

		// 토큰이 있는동안 반복
		// while (st.hasMoreTokens()) {
		// 토큰 하나씩 가져와서 출력
		// String token = st.nextToken();
		// System.out.println(token);
		// }

		// 추첨번호 저장 배열
		int[] lottoNum = new int[7];
		int lottoNumLength = lottoNum.length;
		
		int [] payLotto = new int[6];
		int payLottoLength = payLotto.length;
		
		
		
		// 로또번호 입력
		inputLotto(payLotto);
		// 중복 체크
		checkInput(payLotto);
		
		// 로또번호 프린트
		System.out.print("입력하신 번호는 ");
		for(int i : payLotto) {
			System.out.print(i+" ");
		}System.out.println("입니다.");
		

		// 메소드로 로또번호 추첨
		madeLotto(lottoNum);

		// 메소드로 추첨번호 중복 체크
		checkLotto(lottoNum);

		// 추첨번호 프린트
		System.out.print("추첨번호는 ");
		for (int i = 0; i < lottoNumLength - 1; i++) {
			System.out.print(lottoNum[i] + " ");
		}
		System.out.println("(보너스번호:" + lottoNum[6] + ")");


	} // main

	// 로또번호 추첨
	static void madeLotto(int[] lottoNum) {
		int whileCount = 0;
		while (whileCount < 7) {
			int lottoNumber = (int) (Math.random() * 45) + 1; // 45까지의 랜덤 숫자
			lottoNum[whileCount] = lottoNumber;
			whileCount++;
		}
	}  //madeLotto

	// 로또번호 중복 체크
	static void checkLotto(int[] lottoNum) {

		int lottoNumLength = lottoNum.length;
		for (int i = 0; i < lottoNumLength; i++) {
			int dupe = lottoNum[i];
			for (int j = i + 1; j < lottoNumLength; j++) {
				if (dupe == lottoNum[j]) {
					madeLotto(lottoNum);
				}
			}
		}
	}  // checkLotto
	
	// 사용자 로또번호 입력 받기
	static void inputLotto(int [] payLotto) {
		System.out.println("1~45까지의 중복되지 않은 로또번호를 6개를 입력해 주세요!");
		int payLottoLength = payLotto.length;
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<payLottoLength; i++) {
			payLotto[i]=scanner.nextInt();
		}
		scanner.close();
	}
	
	// 로또번호 중복 체크
	static void checkInput(int[] payLotto) {

		int payLottoLength = payLotto.length;
		for (int i = 0; i < payLottoLength; i++) {
			int dupe = payLotto[i];
			for (int j = i + 1; j < payLottoLength; j++) {
				if (dupe == payLotto[j]) {
					System.out.println("중복입니다. 다시 입력해주세요.");
				}
			}
		} 
		inputLotto(payLotto);
	}  // checkLotto
	

} // class
