package javabasic.excollection;

public class Card {

	Integer num;  // 숫자 (A~10, J, Q, K)
	String shape;  // 무늬 (스페이드, 다이아몬드, 하트, 클로버)

	public Card() {
	}

	public Card(Integer num, String shape) {
		this.num = num;
		this.shape = shape;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	@Override
	public String toString() {
		return shape+num;
	}
	
}
