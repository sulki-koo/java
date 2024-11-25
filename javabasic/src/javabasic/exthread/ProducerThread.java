package javabasic.exthread;

import java.nio.file.attribute.AclEntry;
import java.util.Random;

public class ProducerThread extends Thread {

	private int pn = 0;
	TVFactory tvFactory = new TVFactory();

	@Override
	public void run() {
		while (true) {
			int tvNum = tvFactory.getTvNum();
			pn = (int) (Math.random() * (10 - 5) + 1) + 5;
			System.out.println((tvNum - pn) + "대 판매" + tvFactory);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();

			}
		}
	}

}
