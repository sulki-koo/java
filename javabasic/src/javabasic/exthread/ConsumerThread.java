package javabasic.exthread;

public class ConsumerThread extends Thread {
	
	private int cn = 0;
	private TVFactory ConsumerThread;
	
	public ConsumerThread(TVFactory tvFactory) {
		 this.ConsumerThread = tvFactory;
		}

	@Override
	public void run() {
		
		while (true) {
			synchronized (ConsumerThread) {
				cn = (int) (Math.random() * (8 - 2) + 1) + 2;
				int i = ConsumerThread.getTvNum() - cn;
				ConsumerThread.setTvNum(i);
				System.out.println(cn + "대 판매/재고:" + i);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
	} // run
	
}