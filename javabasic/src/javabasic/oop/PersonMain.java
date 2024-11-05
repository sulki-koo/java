package javabasic.oop;

public class PersonMain {

	public static void main(String[] args) {
		
		Person person = new Person("홍길동", "산적", 20, 170.5f);
		System.out.println(person);  // person.toString() 이 생략됨 - 오버라이딩 되어있어 그 형태로 출력됨
		
	}  // Main
	
}  // class
