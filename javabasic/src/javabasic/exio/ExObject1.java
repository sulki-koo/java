package javabasic.exio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ExObject1 {

	public static void main(String[] args) {

		File file = new File("D:\\embededk\\files\\ex\\person.dat");

		class Person implements Serializable {
			private static final long serialVersionUID = 2315647891658974L;

			String name;
			int age;

			public Person(String name, int age) {
				this.name = name;
				this.age = age;
			}

		}

		Person hong = new Person("홍합", 25);

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(hong);

			ois = new ObjectInputStream(new FileInputStream(file));
			Person h = (Person)ois.readObject();
			System.out.println(h.name);
			System.out.println(h.age);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	} // main

} // class
