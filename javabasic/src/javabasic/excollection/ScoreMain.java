package javabasic.excollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ScoreMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름과 국어, 영어, 수학 성적을 차례로 입력하시오");
		Map<Student, Score> infoMap = new HashMap<Student, Score>();

		for (int i = 0; i < 3; i++) {
			Student stu = new Student(scan.next());
			Score score = new Score(scan.nextInt(), scan.nextInt(), scan.nextInt());
			
			infoMap.put(stu, score);
		}

		Set<Map.Entry<Student, Score>> infoSet = infoMap.entrySet();
		Iterator<Map.Entry<Student, Score>> it = infoSet.iterator();
		while (it.hasNext()) {
			Map.Entry<Student, Score> entry = it.next();
			System.out.println(entry.getKey() + "은 " + entry.getValue());
		}

		scan.close();
	} // main

} // class
