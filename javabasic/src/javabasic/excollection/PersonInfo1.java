package javabasic.excollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class PersonInfo1 {

	public static void main(String[] args) {

		Map<String, String> piMap = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);

		System.out.println("이름과 나이 3명의 정보를 입력(형식:이름,나이)");

		for (int i = 0; i < 3; i++) {
			String info = scan.nextLine();
			int coma = info.indexOf(",");
			String name = info.substring(0, coma);
			String age = info.substring(coma + 1);
			piMap.put(name, age);
		}

		System.out.println(piMap);

		Set<Map.Entry<String, String>> piMapSet = piMap.entrySet();
		Iterator<Map.Entry<String, String>> it = piMapSet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.printf("%s은 %s살\n", entry.getKey(), entry.getValue());
		}

		scan.close();

	} // main

} // class
