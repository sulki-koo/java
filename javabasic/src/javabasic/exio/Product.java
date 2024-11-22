package javabasic.exio;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVerisonUID = 987654328462313L;
	private String name; // 제품명
	private String num; // 제품번호
	private int price; // 가격

	public Product() {
	}
	
	public Product(String name, String num, int price) {
		this.name = name;
		this.num = num;
		this.price = price;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "제품명:"+name+", 제품번호:"+num+", 가격:"+price ;
	}
	
}