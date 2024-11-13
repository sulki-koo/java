package javabasic.exapiextra;

public class APIExtra5 {
	
	public static void main(String[] args) {
		
		String[] strArr = Util.getLineText(2);
		
		System.out.println(strArr[0].contains(strArr[1]) ? "포함한다" : "포함안한다");

		System.out.println(strArr[1].indexOf(strArr[0], 0));
		
		int index = -1;
		int count = 0;
		while((index=strArr[0].indexOf(strArr[1], index+1))>=0) {
			System.out.println("반복문 작동체크");
			count++;
			System.out.println(strArr[1]+"의 " + count + "번쨰 인덱스 : " + index + "\n");
		}
		System.out.println(strArr[1]+"이라는 문자열은 " + count + "번 나옵니다!\n");
		
		
		
	}  // main
	
}  // class
