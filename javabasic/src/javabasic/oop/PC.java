package javabasic.oop;

// PC객체를 생성하려면 Monitor, Desktop, Keyboard가 있어야 함
// *** has a 관계 (위임관계, delegation) : 값이 꼭 필요한 관계 (상속은 is a 관계)
// 상속받지 않아도 가지고 있음으로 사용할 수 있는 관계
// PC has a Monitor
// PC has a Desktop
// PC has a Keyboard
public class PC {

	String company; // 제조사
	int price; // 가격

	// 모듈화
	Monitor monitor;
	Desktop desktop;
	Keyboard keyboard;

	// 기본 생성자 - 만들지 않아도 자동으로 생성됨
	// 파라미터 있는 생성자를 만들려면 기본 생성자를 꼭 만들어야됨
	public PC() {
	}

	public PC(String company, Monitor monitor, Desktop desktop, Keyboard keyboard) {
		this.company = company;
		this.monitor = monitor;
		this.desktop = desktop;
		this.keyboard = keyboard;
	}

	public int getPrice() {
		return this.price;
	}

	// PC의 가격은 모니터 가격 + 데스크탑 가격 + 키보드 가격
	public void setPrice() {
		this.price = monitor.price + desktop.price + keyboard.price;
	}

} // class
