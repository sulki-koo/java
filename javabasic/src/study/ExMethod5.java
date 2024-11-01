package study;

public class ExMethod5 {

	public static void main(String[] args) {
		// 데이터
		String[][] info = { 
				{ "홍길동", "90", "80", "70" }, 
				{ "강감찬", "80", "70", "60" }, 
				{ "이순신", "60", "50", "60" } 
		};
		int[] score = { 0, 0, 0 };

		// score 배열에 데이터 넣기
		saveDate(info, score);

		// 연산&프린트 메소드 호출
		addTotalScore(info, score);
	} // main

	// 총점 데이터 저장
	static void saveDate(String[][] stu, int[] score) {

		int stuLenght = stu.length;
		int stu0Lenght = stu[0].length;

		for (int score1 = 0; score1 < stuLenght; score1++) { // 3
			for (int score2 = 0; score2 < stu0Lenght; score2++) { // 1~4
				if (score2 > 0) {
					score[score1] += Integer.parseInt(stu[score1][score2]);
				}
			}
		}

	} // saveDate

	// 평균 연산&프린트
	static void addTotalScore(String[][] stu, int[] score) {
		int scoreLength = score.length;
		int stu0Lenght = stu[0].length;
		for (int i = 0; i < scoreLength; i++) {
			for (int j = 0; j < stu0Lenght; j++) {
				System.out.print(stu[i][j] + " ");
			}
			System.out.println("총점 : " + score[i] + "점, 평균 : " + score[i] / (stu0Lenght-1) + "점");
		}
	} // addTotalScore

} // class
