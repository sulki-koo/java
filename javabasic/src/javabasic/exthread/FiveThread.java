package javabasic.exthread;

public class FiveThread extends Thread{

	private int i = 5;

	public void run() {

		while (true) {

			System.out.println("FiveThread : " + i);
			i += 5;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	
	
	}
}
