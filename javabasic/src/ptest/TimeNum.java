package ptest;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TimeNum extends JLabel implements Runnable {
	private int startTime;
	private boolean running = false;

	// 생성자
	public TimeNum(int startTime) {
		this.startTime = startTime; // 시작 시간 설정
		setText(String.valueOf(startTime)); // 초기 숫자 설정
		setHorizontalAlignment(CENTER); // 텍스트 중앙 정렬
		setFont(new Font("맑은 고딕", Font.BOLD, 60));
	}

	@Override
	public void run() {
		running = true;

		while (startTime > 0) {
			try {
				Thread.sleep(1000);
				SwingUtilities.invokeLater(() -> setText(String.valueOf(startTime) + "초"));
				startTime--; // 1초 감소

				//repaint(); // 갱신
			} catch (InterruptedException ie) {
				break; // 스레드 중단시 반복종료
			}
		}
		setText(String.valueOf(startTime) + "초 게임 끝");
	}
	
	public void reset(int newStartTime) {
		startTime = newStartTime;
		running = false;
		setText(String.valueOf(startTime));
	}
	
	public void stopTimer() {
		running = false;
	}
	
}
