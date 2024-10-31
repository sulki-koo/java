package study;

class Cat { // 보통 클래스 2개를 사용하지는 않음
	Cat c; // 객체 변수

	static void number() {
		int num = 4; // 필드 선언+초기화
		num = 5; // num 필드값을 5로 변경
		System.out.println(num);

	}

	void move() { // 메서드 선언
		System.out.println("잠자고 있습니다.");
		System.out.println("움직입니다.");
	}
} // Cat 클래스

public class D1031 {

	public static void main(String[] args) {

		Cat c = new Cat(); // Cat 클래스를 이용한 객체 생성 -> 객체 생성, 대입
		Cat.number(); // 다른 클래스에 있는 Cat 의 메소드 number를 실행 -> 값은 5

		c.move(); // Cat 클래스의 메서드 move 실행
		c.move();
		c.move();

	} // main

} // class
