package javabasic.exthread;

public class ExThread4 {

	public static void main(String[] args) {

		TVFactory tvf  = new TVFactory();
		
		Thread pt = new ProducerThread(tvf);
		pt.start();
		
		Thread ct = new ConsumerThread(tvf);
		ct.start();
		
	}

}