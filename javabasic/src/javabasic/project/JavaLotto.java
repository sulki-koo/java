package javabasic.project;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

//Java Lotto : 개인 Java 프로젝트
//[Lotto 프로그램 구현]

//1. 기능
//1) 사용자에게 1~45 중 중복되지 않은 6개의 정수를 입력받는다.
//2) 중복되지 않은 7개의 정수를 랜덤하게 뽑아낸다. (앞의 6개는 로또번호, 7번재는 보너스번호)
//3) 로또 당첨규칙에 따라서 사용자의 당첨등수를 출력한다.

//2. 규칙
//1) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽀은 앞의 6개 번호가 모두 일치하면 1등
//2) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호 중 5개가 일치하고
//  보너스번호가 일치하면 2등
//3) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호 중 5개가 일치 3등
//4) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호 중 4개가 일치 4등
//5) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호 중 3개가 일치 5등
//6) 나머지는 꽝! 다음기회에!

//3. 출력 예시
//로또번호를 6개를 입력해 주세요!
//21 3 8 9 40 33
//추첨번호는 3 8 33 22 10 34 (보너스번호:45)
//5등입니다!

public class JavaLotto {

	public static void main(String[] args) {

		// 응모
		int[] applyLotto = new int[6];
		// 추첨
		int[] lottoNum = new int[7];

		// 응모 
		apply(applyLotto, lottoNum);
		// 입력값 중복 체크부터 추첨까지
		inputDupe(applyLotto, lottoNum); // 입력받은 값 중복체크 실행

	} // main

	// 로또번호 입력받기
	static void apply(int[] applyLotto, int[] lottoNum) {

		Scanner input = new Scanner(System.in);

		int applyLottoLength = applyLotto.length;
		System.out.println("로또번호를 6개를 입력해 주세요!");

		try {
			for (int i = 0; i < applyLottoLength; i++) {
				applyLotto[i] = input.nextInt();
			}
		} catch (InputMismatchException error) {
			System.out.println("Error:1~45의 '숫자'를 입력해주세요.");
			apply(applyLotto, lottoNum);
		}
		
		input.close();

	} // apply

	// 입력받은 로또 번호 검사
	static void inputDupe(int[] applyLotto, int[] lottoNum) {

		// 중복
		int applyLottoLength = applyLotto.length;
		int k = 0;
		for (int i = 0; i < applyLottoLength; i++) {
			for (int j = i + 1; j < applyLottoLength; j++) {
				if (applyLotto[i] == applyLotto[j]) {
					System.out.print(applyLotto[i]);
					System.out.println(" 중복!");
					k += 1;
				}
			}
		}
		// 1~45
		int maxErr = 0;
		for (int i = 0; i < applyLottoLength; i++) {
			if (applyLotto[i] > 46) {
				maxErr++;
			}
		}
		printApply(applyLotto, lottoNum, k, maxErr);
	}

	// 입력한 번호 출력 and 조건에 부합하면 다음 단계
	static void printApply(int[] applyLotto, int[] lottoNum, int k, int maxErr) {
		System.out.println(Arrays.toString(applyLotto)); // 입력한 번호 출력
		if (k != 0 || maxErr != 0) {
			System.out.println("바른 값을 입력해주세요!");
		} else {
			madeLotto(applyLotto, lottoNum); // 중복이 아니면 로또번호 추첨
		}
	} // printApply

	// 로또번호 추첨
	static void madeLotto(int[] applyLotto, int[] lottoNum) {
		for (int i = 0; i < 7; i++) {
			int lottoNumber = (int) (Math.random() * 45) + 1; // 45까지의 랜덤 숫자
			lottoNum[i] = lottoNumber;
		}
		checkLotto(applyLotto, lottoNum); // 로또번호 중복체크 실행
	} // madeLotto

	// 로또번호 중복 체크
	static void checkLotto(int[] applyLotto, int[] lottoNum) {

		int lottoNumLength = lottoNum.length;
		int reCount = 0;

		for (int i = 0; i < lottoNumLength; i++) {
			for (int j = i + 1; j < lottoNumLength; j++) {
				if (lottoNum[i] == lottoNum[j]) {
					reCount++;
				}
			}
		}
		if (reCount == 0) {
			matching(applyLotto, lottoNum);
		} else {
			madeLotto(applyLotto, lottoNum);
		}

	} // checkLotto

	// 당첨 확인
	static void matching(int[] applyLotto, int[] lottoNum) {
		int applyLottoLength = applyLotto.length;
		int count = 0;
		for (int i = 0; i < applyLottoLength; i++) { // 6번
			for (int j = 0; j < applyLottoLength; j++) {
				if (applyLotto[i] == lottoNum[j]) {
					count += 1;
				}
			}
		}
		// 보너스 일치
		int bonus = 0;
		for (int i = 0; i < applyLottoLength; i++) {
			if (lottoNum[6] == applyLotto[i])
				bonus += 1;
		}
		printLotto(applyLotto, lottoNum, count, bonus);

	}

	// 로또 번호 출력
	static void printLotto(int[] applyLotto, int[] lottoNum, int count, int bonus) {
		int lottoNumLength = lottoNum.length;
		System.out.print("추첨 번호는 ");

		for (int i = 0; i < lottoNumLength; i++) {
			if (i == 6) {
				System.out.println("(보너스번호:" + lottoNum[i] + ")");
			} else
				System.out.print(lottoNum[i] + " ");
		}

		System.out.println(count + "개 일치");

		if (count == 6) {
			System.out.println("축! 1등입니다!");
		} else if (count == 5 && bonus > 0) {
			System.out.println("축! 2등입니다!");
		} else if (count == 5) {
			System.out.println("축! 3등입니다!");
		} else if (count == 4) {
			System.out.println("축! 4등입니다!");
		} else if (count == 3) {
			System.out.println("축! 5등입니다!");
		} else {
			System.out.println("꽝! 다음기회에!");
		}
	}

}
// class