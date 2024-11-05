package javabasic.project;

import java.util.Arrays;

// 로또볼을 안에 넣고 뽑을 수 있게 만드는 기계....
public class LottoMachine {
	
	String color;  // 기계 색깔
	boolean working; // 작동 여부
	
	LottoBall[] lottoBalls = new LottoBall[45];     // 로또볼들 45개
	
	
	public LottoMachine() {
	}
	
	public LottoMachine(LottoBall[]  lottoBalls) {
		this.lottoBalls = lottoBalls;
	}

	

}
