package javabasic.project.ooplotto;

//데이터 클래스
// 사용하지 않더라도 JavaBeans 형태로 만들어놓는 것이 기본

// 로또 볼
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
