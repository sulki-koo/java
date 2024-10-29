package study;

public class ExArray2 {

	public static void main(String[] args) {

		String[][] stuArr = { { "홍길동", "박말자", "허준" }, { "A", "B", "C", "D", "F" } };

		for (int name = 0;name<stuArr.length;name++) {
			for (int grade = 0; grade<stuArr[name].length;grade++) {
				System.out.println(stuArr[name][grade]);
			}
		}
	} // main
} //class
