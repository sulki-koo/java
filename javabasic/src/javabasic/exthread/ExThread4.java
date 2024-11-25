package javabasic.exthread;

public class ExThread4 {

	public static void main(String[] args) {

		Thread pt = new ProducerThread();
		
		pt.start();
		
	}

}
