package javabasic.project.ooplotto.Collection;

//로또 구매
public class LottoBuyInfo {

	private int count; // 구매 수량
	private int autoApplyNum; // 자동으로 구매할 수량

	public LottoBuyInfo() {
	}

	public LottoBuyInfo(int count, int autoApplyNum) {
		this.count = count;
		this.autoApplyNum = autoApplyNum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAutoApplyNum() {
		return autoApplyNum;
	}

	public void setAutoApplyNum(int autoApplyNum) {
		this.autoApplyNum = autoApplyNum;
	}

}