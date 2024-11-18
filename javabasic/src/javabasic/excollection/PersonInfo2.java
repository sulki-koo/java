package javabasic.excollection;

import java.util.ArrayList;
import java.util.List;

public class PersonInfo2 {

	public static void main(String[] args) {

		List<Person> person = new ArrayList<Person>();

		person.add(new Person("홍길동", "20"));
		person.add(new Person("강감찬", "30"));
		person.add(new Person("이순신", "50"));
		
		System.out.println(person);
		
		for(Person i : person) {
			System.out.println(i);
		}

	} // main

} // class
