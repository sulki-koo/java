package javabasic.thread;

public class ThreadTest3 {

	public static void main(String[] args) {

		Thread hongTread = new HongThread();
		hongTread.start();

		Thread kangTread = new KangThread();
		kangTread.start();
		
		// hongTread는 hongAccount를 가지고 있고
		// kangTread는 kangAccount를 가지고 있다
		// 두 개의 쓰레드가 서로 다른 객체를 사용한다 => 동기화 할 필요 없음
		// 동기화는 각은 객체(자원)을 공유할때 사용해야 한다

	} // main

} // class
