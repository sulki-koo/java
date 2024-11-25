package javabasic.exthread;

public class ThreeThread extends Thread {

	private int i = 3;

	public void run() {

		while (true) {

			System.out.println("ThreeThread : " + i);
			i += 3;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

	}

}
