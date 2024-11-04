package javabasic.exoop1;

public class Furniture {

	String company; // 제조사
	int price; // 가격

	// 가구 is a가 되어 성립되지 않음 [Table extends Furniture]로 클래스 설정하는게 맞음
	Table table;  // 에 drawer를 has a 가능함
	Sofa sofa;
	Drawer drawer;

	public Furniture() {
	}

	public Furniture(String company, Table table, Sofa sofa, Drawer drawer) {
		super();
		this.company = company;
		this.table = table;
		this.sofa = sofa;
		this.drawer = drawer;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice() {
		this.price = table.price + sofa.price + drawer.price;
	}

}
