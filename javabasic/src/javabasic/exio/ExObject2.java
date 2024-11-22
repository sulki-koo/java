package javabasic.exio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExObject2 {

	public static void main(String[] args) {

		List<Product> productList = new ArrayList<Product>(); // 리스트 생성

		productList.add(new Product("사과", "f1", 3000));
		productList.add(new Product("딸기", "f2", 4000));
		productList.add(new Product("키위", "f3", 5000));
		productList.add(new Product("바나나", "f4", 2000));

		File file = new File("D:\\embededk\\files\\ex\\shop_produt.dat"); // 파일 생성

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(new Shop("m.shop", productList)); // 상점 생성 및 직렬화

			ois = new ObjectInputStream(new FileInputStream(file));
			Shop s = (Shop) ois.readObject();
			System.out.println(s.getName());
			System.out.println(s.getProductList());
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	} // main

} // class
