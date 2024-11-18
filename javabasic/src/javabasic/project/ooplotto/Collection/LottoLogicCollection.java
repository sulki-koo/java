package javabasic.project.ooplotto.Collection;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LottoLogicCollection implements ILottoGame {

	Scanner scan = new Scanner(System.in);
	// 입력한 로또 저장 - 중복 저장 안됨
	Set<Integer> apply1 = new TreeSet<Integer>();
	Set<Integer> apply2 = new TreeSet<Integer>();
	Set<Integer> apply3 = new TreeSet<Integer>();
	Set<Integer> apply4 = new TreeSet<Integer>();
	Set<Integer> apply5 = new TreeSet<Integer>();

	// 추첨된 로또 번호 저장
	Set<Integer> drawNamber = new TreeSet<Integer>();

	// 아이템 정보 클래스 호출
	LottoItemInfo lottoItemInfo = new LottoItemInfo();
	// 구매 정보 클래스 호출
	LottoBuyInfo lottoBuyInfo = new LottoBuyInfo();

	@Override
	// 게임 유저측 실행
	public void gamePlay() {
		inputBuyinfo();

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
		int countNum = lottoBuyInfo.getCount();
		int j = 0;
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

	
	
	
	// 응모하기
	void apply() {
		try {
			System.out.println("1번째 로또번호를 6개를 입력해 주세요!");
			while (apply1.size() != 6) { // 6개 숫자 받기
				int num = scan.nextInt();
				if (num > 45) {
					System.out.println("1~45의 숫자를 입력해주세요.");
					continue;
				} else {
					apply1.add(num);
				}
			}
		} catch (InputMismatchException error) {
			System.out.println("Error:1~45의 숫자를 입력해주세요.");
			apply();
		}
		System.out.println(apply1);

	} // apply

} // class
