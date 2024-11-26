package javabasic.exthread;

public class TVFactory {

	private int tvNum = 100;
	private TVFactory tvFactory;

	public TVFactory() {
	}

	public TVFactory(TVFactory tvFactory) {
		this.tvFactory = tvFactory;
	}

	public int getTvNum() {
		return tvNum;
	}

	public void setTvNum(int tvNum) {
		this.tvNum = tvNum;
	}

	@Override
	public String toString() {
		return "[TV의 재고수량 : " + tvNum + "대]";
	}

}