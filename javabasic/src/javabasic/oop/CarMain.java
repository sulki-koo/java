package javabasic.oop;

public class CarMain {

	public static void main(String[] args) {

		// Car타입 객채를 생성
		// 1. Car(); 생성자 호출
		// 2. new연산을 통해서 Car타입의 객체가 메모리에 생성
		// 3. 메모리에 생성된 객체의 주소를 해시알고리즘을 사용해서 참조로 변환
		// 4. 참조(참조값)을 Car타입 객체참조변수인 bmw에 저장
		Car bmw = new Car();
		//System.out.println(bmw); // javabasic.oop.Car@5305068a 16진수 8자리 -> 32 bit(4byte)

		// 객체의 멤버변수등에 값을 할당 (타입에 맞춰서)
		bmw.company = "BMW KOREA";
		bmw.model = "520D";
		bmw.name = "BMW";
		bmw.price = 1000;

		System.out.println(
				"제조사명 : " + bmw.company + "\n" 
				+ "모델명 : " + bmw.model 
				+ "\n" + "이름 : " + bmw.name + "\n"
				+ "판매가격 : " + bmw.price
				);

		// 같은 객체 = 주소가 같다 = 참조가 같다 = 참조값이 같다
		// 메모리상에 같은 곳에 있는 객체를 같은 객체라 함
		// 타입은 동일(javabasic.oop.Car)해도 참조값이 다르면 다른 객체
		Car audi = new Car();
		//System.out.println(audi); // javabasic.oop.Car@1f32e575
		
		audi.company = "AUDI KOREA";
		audi.model = "A8";
		audi.name = "AUDI";
		audi.price = 1500;
		
		System.out.println(
				"제조사명 : " + audi.company + "\n" 
				+ "모델명 : " + audi.model 
				+ "\n" + "이름 : " + audi.name + "\n"
				+ "판매가격 : " + audi.price
			);

		// 메모리상에 있는 audi객체의 참조값을 복사
		// audi2객체는 audi객체와 같은 객체
		Car audi2 = audi;
		//System.out.println(audi2); // javabasic.oop.Car@1f32e575
		
		audi2.price = 2000;
		System.out.println(
				"제조사명 : " + audi.company + "\n" 
				+ "모델명 : " + audi.model 
				+ "\n" + "이름 : " + audi.name + "\n"
				+ "판매가격 : " + audi.price
			);
		
		// audi2에서 변경한 price 값으로 같이 대입됨...
		System.out.println(
				"제조사명 : " + audi.company + "\n" 
				+ "모델명 : " + audi.model 
				+ "\n" + "이름 : " + audi.name + "\n"
				+ "판매가격 : " + audi.price
			);

	} // main

} // class
