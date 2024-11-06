package javabasic.project.ooplotto;

import java.util.Arrays;

// 로또 로직
public class LottoLogic {
	
	int[] applyNamber = new int[6];  // 입력한 로또 번호 저장용 배열
	int applyNamberLeng = applyNamber.length;
	
	int[] drawNamber = new int[7];  // 추첨된 로또 번호 저장용 배열
	int drawNamberLeng = drawNamber.length;

	// 로또번호 입력 받기
	
	
	
	
	
	
	
	
	
	
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
			int lottoNuber = (int) (Math.random() * (lottoBallsLeng-1)) + 1;
			drawNamber[i] = lottoBalls[lottoNuber].ball; // 추첨된 7개 숫자만 배열에 새로 저장
			// System.out.print(lottoBalls[lottoNuber].ball+"\t"); // lottoBalls[]에서 추첨된 7개
			// 확인용
			//System.out.print(drawNamber[i] + "\t"); // 추첨된 7개 숫자만 배열에 새로 저장 프린트
		}
		drawCheck(lottoBalls);

	} // drawLotto

	// 추첨값 중복 체크
	void drawCheck(LottoBall[] lottoBalls) {
		int dupe = 0;
		for (int i = 0; i < drawNamberLeng; i++) {
			for (int j = i+1; j < drawNamberLeng; j++) {
				if (drawNamber[i] == drawNamber[j]) {
					dupe++;
				}
			}
		} //System.out.println(dupe+"개 중복");
		if (dupe!=0) {
			drawLotto(lottoBalls);
		}else {
		printDraw(lottoBalls);
		}
	}  // drawCheck
	
	// 추첨값 프린트
	void printDraw(LottoBall[] lottoBalls) {
		System.out.print("추첨번호는 ");
		for (int i=0; i<drawNamberLeng-1; i++) {
			System.out.print(drawNamber[i]+" ");
		}
		System.out.println("(보너스번호:"+drawNamber[6]+")");
	}  // printDraw
	
	

} // class
