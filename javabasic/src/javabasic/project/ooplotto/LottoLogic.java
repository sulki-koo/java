package javabasic.project.ooplotto;

import java.util.InputMismatchException;
import java.util.Scanner;

// 로또 게임 구현
public class LottoLogic implements ILottoGame {

	Scanner scan = new Scanner(System.in);
	int[][] applyNamber = new int[5][6]; // 입력한 로또 번호 저장용 배열
	int applyNamberLeng = applyNamber.length;
	int applyNamber0Leng = applyNamber[0].length;

	int[] drawNamber = new int[7]; // 추첨된 로또 번호 저장용 배열
	int drawNamberLeng = drawNamber.length;

	int[] errorArr = new int[5];

	// 아이템 정보 클래스 호출
	LottoItemInfo lottoItemInfo = new LottoItemInfo();
	// 구매 정보 클래스 호출
	LottoBuyInfo lottoBuyInfo = new LottoBuyInfo();

	@Override
	// 게임 유저측 실행
	public void gamePlay() {
		inputBuyinfo();
		drawAutoUser();
		scan.close();
	}

	// 구매수량 입력 받기
	void inputBuyinfo() {

		int i = 0;

		while (i < 1) {
			System.out.println("구매 수량을 입력하세요!(최대 5장)");
			int iCount = scan.nextInt();
			lottoBuyInfo.setCount(iCount);
			if (iCount > 5) {
				System.out.println("올바른 값을 입력해주세요");
			} else {
				i++;
			}
		}

		int j = 0;
		int countNum = lottoBuyInfo.getCount();
		while (j < 1) {
			System.out.println("자동으로 번호를 선택 할 수량을 입력하세요!");
			int iAuto = scan.nextInt();
			lottoBuyInfo.setAutoApplyNum(iAuto);
			if (iAuto > countNum) {
				System.out.println("올바른 값을 입력해주세요");
			} else {
				j++;
			}
		}

		System.out.println(
				lottoItemInfo.getItemName() + "의 총 금액:" + (lottoItemInfo.getPrice() * lottoBuyInfo.getCount()) + "원");

		apply();
	} // inputBuyinfo

	// 로또번호 입력 받기
	void apply() {
		lottoBuyInfo.getAutoApplyNum();
		int countNum = lottoBuyInfo.getCount();
		int autoNum = lottoBuyInfo.getAutoApplyNum();

		try {
			for (int i = 0; i < countNum - autoNum; i++) {
				System.out.println((i + 1) + "번째 로또번호를 6개를 입력해 주세요!");
				for (int j = 0; j < applyNamber0Leng; j++) {
					int num = scan.nextInt();
					if (num > 45) {
						j--;
						System.out.println("1~45의 숫자를 입력해주세요.");
						continue;
					}
					applyNamber[i][j] = num;
				}
			}
		} catch (InputMismatchException error) {
			System.out.println("Error:1~45의 숫자를 입력해주세요.");
			apply();
		}
	} // apply

	// 자동을 선택한 경우 랜덤으로 번호 뽑기
	void drawAutoUser() {
		int countNum = lottoBuyInfo.getCount();
		int autoNum = lottoBuyInfo.getAutoApplyNum();
		for (int i = (countNum - autoNum); i < countNum; i++) {
			for (int j = 0; j < applyNamber0Leng; j++) {
				int drawAutoNum = (int) (Math.random() * 45) + 1;
				applyNamber[i][j] = drawAutoNum;
			}
		}
		inputDupe();
	} // drawAutoUser

	// 중복 체크 구매 횟수만큼 반복 검사
	boolean checkRound(int round) {
		int countNum = lottoBuyInfo.getCount();
		for (int i = 0; i < countNum; i++) {
			for (int j = i + 1; j < applyNamber0Leng; j++) {
				if (applyNamber[round][i] == applyNamber[round][j]) {
					return true;
				}
			}
		}
		return false;
	} // checkRound

	// 입력받은 로또 번호 검사
	void inputDupe() {
		int countNum = lottoBuyInfo.getCount();
		int round = 0;
		for (; round < countNum - 1; round++) {
			checkRound(round);
		}

		if (checkRound(round)) {
			System.out.println("중복 값을 입력하였습니다. 다시 입력해주세요.");
			apply();
		}
		printApplyCheck();

	} // inputDupe

	// 입력한 번호 출력 and 조건별 멘트 출력
	void printApplyCheck() {
		int countNum = lottoBuyInfo.getCount();
		// 응모값 출력
		for (int i = 0; i < countNum; i++) {
			System.out.print("( ");
			for (int j = 0; j < applyNamber0Leng; j++) {
				System.out.print(applyNamber[i][j] + " ");
			}
			System.out.println(")");
		}
		intoMachine();

	} // printApplyCheck

	// LottoMachine에 LottoBall 정수 1~45 넣음
	void intoMachine() {
		// LottoMachine()생성자를 이용해 LottoMachine 타입의 객체 생성(new)
		// 참조값으로 변환 lottoMachine에 객체참조변수로 저장
		LottoMachine lottoMachine = new LottoMachine();

		// LottoMachine 타입의 배열에 int를 담기 위해 만든 배열 - 선언,초기화
		int[] lottoDraw = new int[45];
		int lottoDrawLeng = lottoDraw.length; // lottoDraw 배열 길이

		// lottoDraw 배열에 1~45 숫자 할당
		for (int i = 0; i < lottoDrawLeng; i++) {
			lottoDraw[i] = i + 1;
		}

		// 위에서 lottoDraw 배열에 할당한 값을 LottoMachine 타입의 배열에 할당하기 위한 for문
		for (int i = 0; i < lottoDrawLeng; i++) {
			// LottoBall() 생성자를 이용해 위에서 객체참조변수로 저장한 lottoMachine의 lottoBalls[]을 호출
			// 그 배열에 위에서 lottoDraw[]에 할당한 값을 lottoBalls[]에 할당해줌
			lottoMachine.lottoBalls[i] = new LottoBall(lottoDraw[i]);

			// lottoMachine.lottoBalls[i].ball -> .ball(class LottoBall의 int ball;을 불러옴)
			// .ball이 없으면 Object 참조값 반환
			// System.out.print(lottoMachine.lottoBalls[i].ball + "\t"); // 할당한 값을 출력
		}
		drawLotto(lottoMachine.lottoBalls);

	} // intoMachine

	// 로또 추첨
	void drawLotto(LottoBall[] lottoBalls) {
		int lottoBallsLeng = lottoBalls.length;
		for (int i = 0; i < 7; i++) {
			int lottoNuber = (int) (Math.random() * (lottoBallsLeng - 1)) + 1;
			drawNamber[i] = lottoBalls[lottoNuber].ball; // 추첨된 7개 숫자만 배열에 새로 저장
			// System.out.print(lottoBalls[lottoNuber].ball+"\t"); // lottoBalls[]에서 추첨된 7개
			// 확인용
			// System.out.print(drawNamber[i] + "\t"); // 추첨된 7개 숫자만 배열에 새로 저장 프린트
		}
		drawCheck(lottoBalls);

	} // drawLotto

	// 추첨값 중복 체크
	void drawCheck(LottoBall[] lottoBalls) {
		int dupe = 0;
		for (int i = 0; i < drawNamberLeng; i++) {
			for (int j = i + 1; j < drawNamberLeng; j++) {
				if (drawNamber[i] == drawNamber[j]) {
					dupe++;
				}
			}
		}
		if (dupe != 0) {
			drawLotto(lottoBalls);
		} else {
			printDraw(lottoBalls);
		}
	} // drawCheck

	// 추첨값 프린트
	void printDraw(LottoBall[] lottoBalls) {
		System.out.print("추첨번호는 ");
		for (int i = 0; i < drawNamberLeng - 1; i++) {
			System.out.print(drawNamber[i] + " ");
		}
		System.out.println("(보너스번호:" + drawNamber[6] + ")");
		matching();
	} // printDraw

	
	// 당첨 확인 해야됨.....
	// 당첨 확인
	void matching() {
		int countNum = lottoBuyInfo.getCount();

		int count = 0;

		// 로또 번호 확인
		for (int i = 0; i < countNum; i++) { // 구매횟수만큼
			int n = 0;
			for (int j = 0; j < applyNamberLeng; j++) { // index 0~5
				if (applyNamber[i][n] == drawNamber[j]) {
					count++;
				}
				n++;
			}
		}

		// 보너스 번호 확인
		int bonus = 0;
		for (int i = 0; i < countNum; i++) {
			for (int j = 0; j < applyNamberLeng; j++) {
				if (drawNamber[6] == applyNamber[i][j])
					bonus += 1;
			}
		}
		printLotto(count, bonus);

	} // matching

	// 로또 당첨여부 출력
	void printLotto(int count, int bonus) {

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
	}// printLotto

}