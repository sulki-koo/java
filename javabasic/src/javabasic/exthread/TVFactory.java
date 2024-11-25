package javabasic.exthread;

public class TVFactory {
	
	private int tvNum = 100;
	
	public TVFactory() {
	}

	public TVFactory(int tvNum) {
		super();
		this.tvNum = tvNum;
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
