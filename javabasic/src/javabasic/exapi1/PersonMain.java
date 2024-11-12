package javabasic.exapi1;

public class PersonMain {

	public static void main(String[] args) {

		Person person1 = new Person("홍길동", 20);
		Person person2 = new Person("홍길동", 20);
		
		// 참조값이 달라도 이름과 나이가 동일하다면 출력
		if (person1.equals(person2)) {
		System.out.println(person1);
		System.out.println(person2);
		}
		
	}  // main

}  //class
