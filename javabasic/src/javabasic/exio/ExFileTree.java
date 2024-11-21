package javabasic.exio;

import java.io.File;

public class ExFileTree {

	public static void main(String[] args) {

		printFileTree(new File("C:\\"));

	} // main

	private static void printFileTree(File file) {

		// 재귀함수를 사용한 재귀 메서드
		File[] files = file.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					System.out.println("[" + f.getName() + "]");  // 디렉토리 프린트
					printFileTree(f);
				} else if (f.isFile()) {
					System.out.println("\t" + f.getName() + "(" + f.length() + ")");
				}
			}
		}
	}

} // class
