package javabasic.project.ooplotto.Collection;
import java.util.ArrayList;
import java.util.List;

//로또 기계
public class LottoMachine {

	private boolean working; // 작동 여부

	
	// LottoBall 클래스 타입의 배열 lottoBalls를 초기화하고 45개 공간의 배열을 선언
	//LottoBall[] lottoBalls = new LottoBall[45]; // 로또볼 45개
	List<LottoBall> lottoBalls = new ArrayList<LottoBall>(45);
	
	
	public LottoMachine() {
	}

	public LottoMachine(List<LottoBall> lottoBalls) {
		this.lottoBalls = lottoBalls;
	}

	public LottoMachine(boolean working, List<LottoBall> lottoBalls) {
		super();
		this.working = working;
		this.lottoBalls = lottoBalls;
	}

	public boolean isWorking() {
		return working;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

	public List<LottoBall> getLottoBalls() {
		return lottoBalls;
	}

	public void setLottoBalls(List<LottoBall> lottoBalls) {
		this.lottoBalls = lottoBalls;
	}

}