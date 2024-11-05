package javabasic.exoop2;

public class Table {

	String size;
	String color;
	int price;
	
	public Table() {
	}

	public Table(String size) {
		super();
		this.size = size;
	}

	public Table(String size, String color) {
		super();
		this.size = size;
		this.color = color;
	}

	public Table(String size, String color, int price) {
		super();
		this.size = size;
		this.color = color;
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Table [size=" + size + ", color=" + color + ", price=" + price + "]";
	}
	
}
