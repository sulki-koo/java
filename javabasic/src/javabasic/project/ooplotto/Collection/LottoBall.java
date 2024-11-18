package javabasic.project.ooplotto.Collection;

//로또 볼
public class LottoBall {

	int ball; // 볼 수

	// 생성자 생성 - 호출을 안하면 에러가 나지않음
	public LottoBall() {
	}

	public LottoBall(int ball) {
		this.ball = ball;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

}
