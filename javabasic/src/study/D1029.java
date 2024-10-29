package study;

public class D1029 {

	public static void main(String[] args) {

		// 배열
//		int[] intArr;  //  배열 int 타입으로 선언
//		int[] intArr = new int[5]; // intArr에 5개 공간 선언
//		intArr[0] = 1;
//		intArr[1] = 2;
//		intArr[2] = 3;
//		intArr[3] = 4;
//		intArr[4] = 5;
//
//		System.out.println("intArr 참조형변수 = " + intArr); // 배열 intArr의 참조형변수 : [I@28a418fc
//		System.out.println("intArr 배열의 길이 : " + intArr.length);
//		System.out.println("intArr[0] = " + intArr[0]); // index 0의 값
//		System.out.println("intArr[1] = " + intArr[1]); // index 1의 값
//		System.out.println("intArr[2] = " + intArr[2]); // index 2의 값
//		System.out.println("intArr[3] = " + intArr[3]); // index 3의 값
//		System.out.println("intArr[4] = " + intArr[4]); // index 4의 값

		System.out.println("==예시 배열 짝수합 구하기=="); 
		int[] numbers = new int[10];

		for (int i = 0; i < numbers.length; i++) { // i에 0~9(numbers 길이)까지
			numbers[i] = (int) (Math.random() * 30) + 1; // 30까지의 정수값 랜덤으로 넣음
		}
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				sum += numbers[i];
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]+"\t");
		}
		System.out.println("\n---------------------------"+"\n배열의 짝수합 : "+sum);
		
		System.out.println("\n==연습 배열 홀수합 구하기=="); 
		int[] oddNum = new int[10];

		for (int j=0; j<oddNum.length; j++) {         // j에 배열의 길이만큼
			oddNum[j] = (int)(Math.random()*30)+1; // 30까지의 정수값 랜덤으로 넣기
		}
		int sumOdd = 0;
		for (int j=0; j<oddNum.length; j++) {
			if (oddNum[j]%2!=0) {
				sumOdd += oddNum[j];
			}
		}
		for (int j=0; j<oddNum.length; j++) {
			System.out.print(oddNum[j]+"\t");
		}
		System.out.println("\n---------------------------"+"\n배열의 홀수합 : "+sumOdd);
		
		System.out.println("\n==다차원 배열=="); 
		int[][] scoreArr= {
				{100,90,80},
				{70,60,50},
				{40,30,20}
		};
//		System.out.println(scoreArr[2][0]);  // 앞은 행, 뒤는 열 -> 2행 0열 -> 40
		for (int i=0; i<scoreArr.length; i++) {
			for (int j=0; j<scoreArr[i].length; j++) {
				System.out.print(scoreArr[i][j]+"\t");
			}
		}
		
		System.out.println("\n==ExArray1 다섯개의 문자열 배열에 저장 후 출력=="); 
		int[] intArr = {1,2,3,4,5};
		for (int i:intArr) {   //  배열의 요소를 순차적으로 꺼내오기 위한 구문
			System.out.print(i+"\t");
		} System.out.println();
		for (int i=0; i<intArr.length; i++) { //  배열의 요소를 순차적으로 꺼내오기 위한 구문2
			System.out.print(intArr[i]+"\t");
		}
		
	} // main

}  // class
