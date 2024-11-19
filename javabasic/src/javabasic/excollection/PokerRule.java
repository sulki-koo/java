package javabasic.excollection;

import java.util.List;

/*
 * 높은 무늬의 순서는 ♠(스페이드) > ◆(다이아) > ♥(하트) > ♣(클로버) 순입니다.
 * 높은 숫자의 순서는 A > K > Q > J > 10~2 순입니다.
 * 1.로얄 스트레이트 플러쉬(로티플):카드 5장이 모두 무늬가 같으면서 10, J, Q, K, A 연달아 있는 패
 * 2.스트레이트 플러쉬(스티플):카드 5장이 모두 무늬가 같으면서 숫자가 연달아 있는 패
 * 3.포카드(포카):같은 숫자의 카드 4장으로 되어 있는 패
 * 4.풀하우스:같은 숫자 3개(트리플)와 같은 숫자 2개(원페어)로 된 패
 * 5.플러쉬:카드 5장 모두 무늬가 같은 패
 * 6.스트레이트:모든 무늬가 같지는 않고 카드 5장의 숫자가 연달아 있는 패
 * 7.트리플:5장의 카드 중에서 3장의 숫자가 같은 패
 * 8.투 페어:같은 숫자 두 개(원페어)가 두 쌍이 있는 패
 * 9.원 페어:5장의 카드 중에서 2장의 숫자가 같은 패
 * 10.제일 높은 숫자
 */

public class PokerRule {

	// 로얄스트레이트 플러쉬 여부 : 연속된 5개의 숫자(10~14)이고, 5개가 동일한 무늬
	public static boolean isRoyalStraightFlush(List<Card> cardList) {

		return false;
	}

	// 스트레이트 플러쉬 여부 : 연속된 5개의 숫자, 5개가 동일 무늬, 로얄제외
	public static boolean isStraightFlush(List<Card> cardList) {
		return !isRoyalStraightFlush(cardList) && isStraight(cardList) && isFlush(cardList);
	}

	// 포카드 여부 : 동일 숫자 4개
	public static boolean isFourCard(List<Card> cardList) {
		// 동일 숫자 카드 세기
		return false;
	}

	// 풀하우스 여부 : 동일 숫자 3개와 2개/ 트리플+트리플 또는 트리플+원페어 또는 트리플 + 투페어
	public static boolean isFullHouse(List<Card> cardList) {
		if(numOfTriple(cardList)==2
				||(numOfTriple(cardList)==1&&numOfPair(cardList)==1)
				||(numOfTriple(cardList)==1&&numOfPair(cardList)==2)) {
			return true;
			}
		return false;
	}

	// 플러쉬 여부 : 같은무늬 5개이상
	public static boolean isFlush(List<Card> cardList) {

		return false;
	}

	// 스트레이트 여부 : 연속된 번호 5개 이상
	public static boolean isStraight(List<Card> cardList) {

		return false;
	}

	// 트리플 여부 : 동일숫자 3개
	public static boolean isTriple(List<Card> cardList) {
		if(numOfTriple(cardList)==1) return true;
		return false;
	}

	// 투페어 여부 : 동일숫자 2개가 2개 이상
	public static boolean isTwoPair(List<Card> cardList) {
		if(numOfPair(cardList)==2||numOfPair(cardList)==3) return true;
		return false;
	}

	// 원페어 여부 : 동일숫자 2개
	public static boolean isOnePair(List<Card> cardList) {
		if(numOfPair(cardList)==1) return true;
		return false;
	}

	// 페어수를 반환
	public static int numOfPair(List<Card> cardList) {

		return 0;
	}

	// 트리플수를 반환
	public static int numOfTriple(List<Card> cardList) {

		return 0;
	}

}  // class
