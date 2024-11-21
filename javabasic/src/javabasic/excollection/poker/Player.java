package javabasic.excollection.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

	private String name; // 이름
	private List<Card> cardList; // 카드리스트
	private String rank;  // 족보 결과
	private Map<Integer, Integer> numCountMap; // 숫자카운트맵
	private Map<String, Integer> shapeCountMap; // 무늬카운트맵

	public Player() {
	}

	public Player(String name, List<Card> cardList) {
		super();
		this.name = name;
		this.cardList = cardList;
	}

	public Player(String name, List<Card> cardList, String rank) {
		super();
		this.name = name;
		this.cardList = cardList;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Map<Integer, Integer> getNumCountMap() {
		return numCountMap;
	}

	public void setNumCountMap(Map<Integer, Integer> numCountMap) {
		this.numCountMap = numCountMap;
	}

	public Map<String, Integer> getShapeCountMap() {
		return shapeCountMap;
	}

	public void setShapeCountMap(Map<String, Integer> shapeCountMap) {
		this.shapeCountMap = shapeCountMap;
	}

	@Override
	public String toString() {
		return name + "\t" + cardList +"\n 족보 결과 : "+ rank;
		// return name + " " + cardList + "\n" + numCountMap + "\n" + shapeCountMap;
	}
}