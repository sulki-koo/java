package javabasic.exthread;

public class ExThread1 {

	public static void main(String[] args) {

		Thread threeThread = new ThreeThread();
		threeThread.start();

		Thread fiveThread = new FiveThread();
		fiveThread.start();

	}

}
