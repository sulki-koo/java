package javabasic.exoop4;

public class StudentMain {

	public static void main(String[] args) {

		makeStudent("김서", 100, 90, 80);
		makeStudent("민유", 90, 80, 70);
		makeStudent("전저", 80, 70, 60);

	} // main

	public static void makeStudent(String name, int kor, int eng, int Math) {
		Student.Score Student = new Student(name).new Score(kor, eng, Math);
		System.out.println(Student);
	}

} // class
