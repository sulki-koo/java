package javabasic.thread;

public class KangThread2 extends Thread {

	private Account2 kangAccount2;

	public KangThread2(Account2 account2) {
		this.kangAccount2 = account2;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			// 강계좌에서 500원을 입금
			// kangAccount2.setMoney(kangAccount2.getMoney() + 500);
			kangAccount2.deposit();

//			synchronized (kangAccount2) {
//				kangAccount2.setMoney(kangAccount2.getMoney() + 500);
//			}

			System.out.println("강감찬의 계좌에서 500원 입금!");
			System.out.println(kangAccount2 + "\n");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

	} // run

} // class
