package javabasic.project.ooplotto.Collection;

public class LottoMain {

	public static void main(String[] args) {

		// 인터페이스 호출
		ILottoGame lottoGame = new LottoLogicCollection();

		lottoGame.gamePlay(); // 실행

	} // main

} // class