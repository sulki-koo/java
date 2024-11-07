package javabasic.oop;

public abstract class AbstractPrinter implements IPrinter {

	String sort;
	String company;
	String name;
	int price;
	
	// Object 상속을 받음 (interface는 클래스가 아님 - 클래스를 상속받음...)
	public AbstractPrinter(String company, String name, int price) {
		this.company = company;
		this.name = name;
		this.price = price;
	}
	
	public AbstractPrinter(String sort, String company, String name, int price) {
		this.sort = sort;
		this.company = company;
		this.name = name;
		this.price = price;
	}

	@Override
	public void turnOn() {
		System.out.println(name + "프린터의 전원을 켜다!");
	}

	@Override
	public abstract void print();

	@Override
	public void turnOff() {
		System.out.println(name + "프린터의 전원을 끄다!");
	}

	@Override
	public String toString() {
		return sort + "(" +  company + ", " + name + ", " + price + "원)";
	}

}
