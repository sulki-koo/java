package javabasic.exthread;

public class ProducerThread extends Thread {

	private int pn = 0;
	private TVFactory ProducerThread;

	public ProducerThread(TVFactory tvFactory) {
		this.ProducerThread = tvFactory;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (ProducerThread) {
				pn = (int) (Math.random() * (10 - 4) + 1) + 4;
				int i = ProducerThread.getTvNum() + pn;
				ProducerThread.setTvNum(i);
				System.out.println(pn + "대 생산/재고:" + i);
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

	} // run

} // class