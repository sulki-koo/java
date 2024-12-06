package projectteam1;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.Font;

public class TimeNum extends JLabel implements Runnable {

	private int startTimeMillis; // 밀리세컨드 단위로 저장
	private boolean running = false;

	// 생성자
	public TimeNum(int startTimeSec) {
		this.startTimeMillis = startTimeSec * 1000; // 초를 밀리세컨드로 변환
		setText(formatTime(startTimeMillis)); // 초기 텍스트 설정 (밀리세컨드로 표시)
	}

	private String formatTime(int timeMillis) {
		int seconds = (timeMillis % 60000) / 1000;
		int millis = timeMillis % 1000;
		return String.format("%02d.%03d", seconds, millis); //
	}

	@Override
	public void run() {
		running = true;

		while (startTimeMillis > 0) {
			try {
				Thread.sleep(1); // 1밀리초마다 카운트다운
				startTimeMillis--; // 밀리세컨드 감소
				SwingUtilities.invokeLater(() -> setText(formatTime(startTimeMillis))); // UI 업데이트

			} catch (InterruptedException ie) {
				running = false;
				break; // 스레드 중단시 반복 종료
			}
		}

		// 타이머 종료 후 텍스트 설정
		setText(formatTime(startTimeMillis));
	}

	public void reset(int newStartTimeSec) {
		startTimeMillis = newStartTimeSec * 1000; // 초를 밀리세컨드로 변환하여 초기화
		running = false;
		setText(formatTime(startTimeMillis)); // 초기 시간으로 표시
	}
	
	public boolean isTimeOver() {
		return startTimeMillis <= 0;  // 0이하면 true
	}

}
