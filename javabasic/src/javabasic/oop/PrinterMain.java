package javabasic.oop;

public class PrinterMain {

	public static void main(String[] args) {

		// 잉크젯 프린터 하나 생성해서 켜고, 프린트하고, 꺼 보세요.
		// InkjetPrinter inkjetPrinter = new InkjetPrinter("주식회사 잉크", "잉크 ver.1",
		// 200000);

//		inkjetPrinter.turnOn();
//		inkjetPrinter.print();
//		inkjetPrinter.turnOff();

		// 레이저 프린터 하나 생성해서 켜고, 프린트하고, 꺼 보세요.
		// RazorPrinter razorPrinter = new RazorPrinter("주식회사 레이저", "레이저 ver.1",
		// 300000);

//		razorPrinter.turnOn();
//		razorPrinter.print();
//		razorPrinter.turnOff();

		// 인터페이스를 구현한 클래스의 객체를 생성하면 "항상" 인터페이스 타입참조변수를 사용한다.
		// why??? 프로그램 구현이 유연하고 확장성 있어진다
//		IPrinter inkjet = new InkjetPrinter("주식회사 잉크", "잉크 ver.1", 200000);
//		IPrinter razor = new RazorPrinter("주식회사 레이저", "레이저 ver.1", 300000);
		IPrinter inkjet = new InkjetPrinter(null, null, 0);
		IPrinter razor = new RazorPrinter(null, null, 0);
//		operate(inkjet);
//		operate(razor);

		// 배열에서 다형성을 활용
		// 잉크젯프린터 500개와 레이져프린터 500개를 갖는 배열을 생성

		// 확장성에 문제가 있음 200개면 200줄....
//		IPrinter[] inkjetArr = new InkjetPrinter[500];
//		IPrinter[] razorArr = new RazorPrinter[500];

		IPrinter[] iPrinterArr = new IPrinter[1000];

		// 배열에 잉크젯프린터 객체 500개, 레이져프린터 객체 500개 저장
		int iPrinterArrLeng = iPrinterArr.length;
		for (int i = 0; i < iPrinterArrLeng; i++) {
			if (i % 2 == 0) {
				iPrinterArr[i] = new InkjetPrinter("제조사명" + (i + 1), "Inkjet" + (i + 1), 1000);
			} else {
				iPrinterArr[i] = new RazorPrinter("제조사명" + (i + 1), "Razor" + (i + 1), 2000);
			}
		}

		// 배열에 있는 것 모두 꺼내서 출력
		// 출력형태 : 잉크젯프린터 (제조사명1, Inkjet1, 1000원)
		// 레이져프린터 (제조사명1, Razor1, 2000원)
		// .....(1000개)

//		for (int i = 0; i < iPrinterArrLeng; i++) {
//			if (i % 2 == 0) {
//				System.out.print("잉크젯프린터");
//			} else {
//				System.out.print("레이저프린터");
//			}
//			System.out.println(((AbstractPrinter) iPrinterArr[i]));  // .toString() 은 생략..
//		}

		// 100점
		// toString() 오버라이딩을 이용해 보자!
		// company, name, price는 AbstractPrinter가 가지고 있다!
		// 그러므로, AbstractPrinter에 toString()을 오버라이딩 하자!

		for (IPrinter iprinter : iPrinterArr) {
			System.out.println((AbstractPrinter) iprinter);
		}
		
		
		// 80점 예시
		// InkjetPrinter ink = (InkjetPrinter) iPrinterArr[i]; -> 형변환하는 방법
		// RazorPrinter r = (RazorPrinter) iPrinterArr[i]; -> 형변환하는 방법
//		for (int i = 0; i < iPrinterArrLeng; i++) {
//			if (iPrinterArr[i] instanceof InkjetPrinter) {
//				System.out.println("잉크젯프린터");
//			} else if (iPrinterArr[i] instanceof RazorPrinter) {
//				System.out.println("레이져프린터");
//			}
//			print(iPrinterArr[i]);
//		}

	} // main

	// IPrinter인터페이스의 역할 : InkjetPrinter, RazorPrinter의 타입을 일원화
	static void operate(IPrinter iPrinter) {
		// iPrinter가 가지고 있는 참조값에 따라서 각 클래스이 메소드가 호출됨
		iPrinter.turnOn();
		iPrinter.print();
		iPrinter.turnOff();
	}

	// 80점 예시
	static void print(IPrinter iprinter) {
		System.out.println(((AbstractPrinter) iprinter).company);
	}

} // class
