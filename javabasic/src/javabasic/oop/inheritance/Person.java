package javabasic.oop.inheritance;

public class Person {
	
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// equals 오버라이딩하면 참조값이 다르더라도 같은값으로 바꿔줄 수 있음
	// 이름과 나이가 같으면 equals가 true를 반환하도록 오버라이딩
	@Override
	public boolean equals(Object obj) {  //  obj 이름 변경은 가능함..
		if (this.name.equals(((Person)obj).name)   //  Object에는 name이 없으므로 (Person)으로 형변환
				&& this.age==((Person)obj).age) {  //  Object에는 age가 없으므로 (Person)으로 형변환
			return true;
		}else {
			return false;
		}
	}
		
} // class
