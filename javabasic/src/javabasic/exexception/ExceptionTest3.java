package javabasic.exexception;

public class ExceptionTest3 {

	public static void main(String[] args) {

			inputInfo("홍길동", "산적");
			inputInfo("강감찬", "장군");
			inputInfo("이순신", "장군");
			inputInfo("임꺽정", "산적");
			inputInfo("권율", "장군");
		
	} // main

	private static void inputInfo(String name, String job) {
		new Person(name, job);
		System.out.println(name+"/"+job);
		try {
			if (job == "산적")
				throw new JobException();
		} catch (JobException je) {
			System.out.println(je);
		}
	}

} // class
