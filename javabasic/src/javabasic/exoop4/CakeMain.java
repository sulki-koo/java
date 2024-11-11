package javabasic.exoop4;

public class CakeMain {

	public static void main(String[] args) {

		// Cake class의 메서드를 make메서드에 불러와서 호출
		make("모카");
		make("쵸콜릿");
		make("바나나");
		
		Cake moca = new Cake("모카") {
			@Override
			public String getName() {
				return super.getName();
			}
		};
		System.out.println(moca.getName());
		

	} // main
	
	public static void make(String name) {
		Cake mCake = new Cake() {
			@Override
			public void makeCake() {
				System.out.println(name + "케이크가 만들어 졌습니다");
			}
		};
		mCake.makeCake();
	}

} // class
