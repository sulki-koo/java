package javabasic.exoop1;

public class Furniture {

	private String company; // 제조사
	String size; // 크기
	String color; // 색상
	int price; // 가격

	// 생성자
	public Furniture() {
	}

	public Furniture(String company, String size, String color, int price) {
		this.company = company;
		this.size = size;
		this.color = color;
		this.price = price;
	}

	public String getColor() {
		return "Violet";
	}
	
	@Override
	public String toString() {
		return "가구";
	}
	
}
