package javabasic.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {

		// Comparator타입의 객체 생성
		Comparator<Integer> intCom = new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;
			}
		};

		List<Integer> intList = new ArrayList<Integer>();
		intList.add(3);
		intList.add(10);
		intList.add(2);
		intList.add(9);
		intList.add(5);

		// 컬렉션 정렬
		Collections.sort(intList, intCom);
		System.out.println(intList);

		// 컬렉션 뒤집기
		Collections.reverse(intList);
		System.out.println(intList);

		Comparator<String> strCom = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				// 문자열 길이 오름차순 정렬
				// return str1.length()-str2.length();
				// 문자열 길이 내림차순 정렬
				return str2.length() - str1.length();
			}
		};

		List<String> strList = new ArrayList<String>();
		strList.add("hi");
		strList.add("hello");
		strList.add("java");
		strList.add("programming");
		strList.add("a");

		Collections.sort(strList, strCom);
		System.out.println(strList);

		class Person {
			String name;
			int age;

			public Person(String name, int age) {
				this.name = name;
				this.age = age;
			}

			@Override
			public String toString() {
				return name + ":" + age;
			}
		}

		List<Person> personList = new ArrayList<Person>();

		personList.add(new Person("홍길동", 90));
		personList.add(new Person("강감찬", 10));
		personList.add(new Person("이순신", 30));
		personList.add(new Person("최영", 100));
		personList.add(new Person("권율", 40));

		// 각 사람의 나이에 대해서 오름차순 정렬하는 Comparator
		Collections.sort(personList, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.age - p2.age;
			};
		});
		System.out.println(personList);

		// 각 사람의 나이에 대해서 내림차순 정렬하는 Comparator
		Collections.sort(personList, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p2.age - p1.age;
			};
		});
		System.out.println(personList);

		// 1) 아래 리스트를 나이순으로 내림차순 정렬하세요
		List<String> ssnList = new ArrayList<String>();
		ssnList.add("980000-1234567");
		ssnList.add("000000-1234567");
		ssnList.add("050000-1234567");
		ssnList.add("880000-1234567");
		ssnList.add("990000-1234567");

		Collections.sort(ssnList, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String shortYear1 = str1.substring(0, 2);
				String longYear1 = str1.startsWith("0") ? "20" + shortYear1 : "19" + shortYear1;
				String shortYear2 = str2.substring(0, 2);
				String longYear2 = str2.startsWith("0") ? "20" + shortYear2 : "19" + shortYear2;

				return Integer.parseInt(longYear2) - Integer.parseInt(longYear1);
			}
		});
		System.out.println(ssnList);

		// 2) 아래 리스트를 각 학생의 성적 총합 순으로 내림차순 정렬하세요.
		class Score {
			int kor;
			int eng;

			Score(int kor, int eng) {
				this.kor = kor;
				this.eng = eng;
			}

			@Override
			public String toString() {
				return "국어:" + kor + " 영어:" + eng;
			}
		}
		class Student {
			String name;
			Score score;

			Student(String name, Score score) {
				this.name = name;
				this.score = score;
			}

			@Override
			public String toString() {
				return name + "은 " + score;
			}
		}
		List<Student> stdList = new ArrayList<Student>();
		stdList.add(new Student("홍길동", new Score(70, 50)));
		stdList.add(new Student("강감찬", new Score(100, 100)));
		stdList.add(new Student("이순신", new Score(90, 70)));
		stdList.add(new Student("장보고", new Score(40, 90)));
		stdList.add(new Student("최영", new Score(80, 60)));

		Collections.sort(stdList, new Comparator<Student>() {
			@Override
			public int compare(Student score1, Student score2) {
				int total1 = score1.score.eng + score1.score.kor;
				int total2 = score2.score.eng + score2.score.kor;
				return total2 - total1;
			};
		});

		System.out.println(stdList);

		// 3) 아래 리스트를 이름순으로 1차 오름차순 정렬하고 가격순으로 2차 내림정렬
		class Product {
			String name;
			int price;

			Product(String name, int price) {
				this.name = name;
				this.price = price;
			}

			@Override
			public String toString() {
				return name + ":" + price;
			}
		}
		List<Product> prodList = new ArrayList<Product>();
		prodList.add(new Product("피씨", 100));
		prodList.add(new Product("모니터", 100));
		prodList.add(new Product("마우스", 100));
		prodList.add(new Product("키보드", 100));
		prodList.add(new Product("스피커", 100));
		prodList.add(new Product("피씨", 200));
		prodList.add(new Product("모니터", 200));
		prodList.add(new Product("마우스", 200));
		prodList.add(new Product("키보드", 200));
		prodList.add(new Product("스피커", 200));

		// 이름순으로 1차 오름차순 정렬
		Collections.sort(prodList, new Comparator<Product>() {
			@Override
			public int compare(Product name1, Product name2) {
				int ni1 = name1.name.charAt(0);
				int ni2 = name2.name.charAt(0);
				return ni1-ni2;
			};
		});
		
		System.out.println("이름 오름차순 : "+prodList);
		
		// 가격순으로 2차 내림정렬
		Collections.sort(prodList, new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				int pi1 = p1.price;
				int pi2 = p2.price;
				return pi2-pi1;
			};
		});
		System.out.println("가격 내림차순 : "+prodList);
		
	} // main

} // class
