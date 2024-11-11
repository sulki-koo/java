package javabasic.project.ooplotto;

public class LottoUser {
	
	private String name;  // 이름
	
	LottoBuyInfo lottoBuyInfo;  // 구매정보
	
	public LottoUser() {
	}

	public LottoUser(LottoBuyInfo lottoBuyInfo) {
		this.lottoBuyInfo = lottoBuyInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LottoBuyInfo getLottoBuyInfo() {
		return lottoBuyInfo;
	}

	public void setLottoBuyInfo(LottoBuyInfo lottoBuyInfo) {
		this.lottoBuyInfo = lottoBuyInfo;
	}
	

}