package javabasic.exio;

public class Student {
	
	String name;
	
	Score score;
	
	public Student() {
	}

	public Student(String name, Score score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return name + "의 성적 " + score;
	}

}
