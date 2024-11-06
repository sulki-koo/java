package javabasic.project.ooplotto;

// 로또 아이템 정보
public class LottoItemInfo {

	private String itemName; // 품목명
	private int price; // 가격

	public LottoItemInfo() {
	}

	public LottoItemInfo(String itemName, int price) {
		this.itemName = itemName;
		this.price = price;
	}

	// 아이템명과 금액은 가져갈수는 있으나 변경은 불가
	public String getItemName() {
		return "로또";
	}

	public int getPrice() {
		return 5000;
	}
	
	// 아이템 정보 호출시 보이는 내용
	@Override
	public String toString() {
		return "로또의 가격은 5,000원 입니다.";
	}

}
