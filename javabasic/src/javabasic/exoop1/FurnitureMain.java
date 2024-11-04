package javabasic.exoop1;

public class FurnitureMain {

	public static void main(String[] args) {

		Table table = new Table();

		table.color = "WOOD";
		table.size = "80X60(cm)";
		table.price = 5000;

		Sofa sofa = new Sofa();
		sofa.color = "BLACK";
		sofa.people = 2;
		sofa.price = 10000;
		
		Drawer drawer = new Drawer();
		drawer.color = "WHITE";
		drawer.tier = 5;
		drawer.price = 5000;
		
		Furniture furniture = new Furniture("Hanssem", table, sofa, drawer);
		
		furniture.setPrice();
		System.out.println(furniture.company + " 가구 정보 \n"
				+"총 금액 : " + furniture.getPrice() + "원" + "\n"
				+"Table color : " + table.color + "\n"
				+"Sofa color : " + sofa.color + "\n"
				+"Drawer color : " + drawer.color
				);

	} // main

} // class
