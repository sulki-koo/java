package javabasic.oop;

public class IAnimalMain {

	public static void main(String[] args) {

		// Dog 1마리 멍멍
		IAnimal dog1 = new Dog2();
		dog1.sound();
		
		// Dog 1마리 왈왈
		IAnimal dog2 = new AnimalAdapter() {
			@Override
			public void sound() {
				System.out.println("왈왈");
			}
		};
		dog2.sound();
		
	}  //  main

}  // class
     