package javabasic.project.ooplotto;

import javabasic.oop.inheritance.Person;

// 로또 구매
public class LottoBuyInfo {

	private boolean howToPurchase; // 수동, 자동 구입
	private int selectNumber; // 선택한 번호
	private int count; // 구매 수량

	public LottoBuyInfo() {
	}

	
	public LottoBuyInfo(boolean howToPurchase) {
		super();
		this.howToPurchase = howToPurchase;
	}


	public LottoBuyInfo(boolean howToPurchase, int selectNumber, int count) {
		super();
		this.howToPurchase = howToPurchase;
		this.selectNumber = selectNumber;
		this.count = count;
	}

	public boolean isHowToPurchase() {
		return howToPurchase;
	}

	public void setHowToPurchase(boolean howToPurchase) {
		this.howToPurchase = howToPurchase;
	}

	public int getSelectNumber() {
		return selectNumber;
	}

	public void setSelectNumber(int selectNumber) {
		this.selectNumber = selectNumber;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
