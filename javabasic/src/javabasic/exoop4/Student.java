package javabasic.exoop4;

public class Student {

	String name; // 학생 이름
	Score score;

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	class Score {
		int korScore; // 국어점수
		int engScore; // 영어점수
		int mathScore; // 수학점수
		int sum; // 총점
		float average; // 평균

		public Score(int korScore, int engScore, int mathScore) {
			this.korScore = korScore;
			this.engScore = engScore;
			this.mathScore = mathScore;
			this.sum = korScore + engScore + mathScore;
			this.average = sum/3;
		}

		@Override
		public String toString() {
			return "이름:"+name + "\t국어점수:" + korScore + "\t영어점수:" + engScore + "\t수학점수:" + mathScore + "\t총점:" + sum + "\t평균" + average;
		}
	}
}
