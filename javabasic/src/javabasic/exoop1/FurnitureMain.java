package javabasic.exoop1;

public class FurnitureMain {

	public static void main(String[] args) {

		Furniture[] furniture = {
				new Furniture(),
				new Sofa(),
				new Table(),
				new Bed()
		};
		
		for (int i = 0; i<furniture.length; i++) {
			System.out.println(furniture[i]);
		}
		
		for (int i = 0; i<furniture.length; i++) {
			System.out.println(furniture[i].getColor());
		}
		
	} // main

} // class
