package javaprojectteam1;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TimeNum extends JLabel implements Runnable {

	private long startTimeMillis; // 밀리세컨드 단위로 저장
	private long startTime;
	private boolean running = false;

	// 생성자
	public TimeNum(long startTimeSec) {
		this.startTimeMillis = startTimeSec * 1000; // 초를 밀리세컨드로 변환
		setText(formatTime(startTimeMillis)); // 초기 텍스트 설정 (밀리세컨드로 표시)
	}

	private String formatTime(long timeMillis) {
		long seconds = (timeMillis / 1000) % 60;
		long millis = timeMillis % 1000;
		return String.format("%02d.%03d", seconds, millis); //
	}

	@Override
	public void run() {
		running = true;
		startTime = System.currentTimeMillis(); // 타이머 시작 시간 기록
		while (startTimeMillis > 0) {
			try {
				long elapsedTime = System.currentTimeMillis() - startTime; // 경과 시간 계산
				startTimeMillis = Math.max(0, startTimeMillis - elapsedTime); // 남은 시간 계산
				startTime = System.currentTimeMillis(); // 시작 시간을 갱신
				SwingUtilities.invokeLater(() -> setText(formatTime(startTimeMillis))); // UI 업데이트

				Thread.sleep(10); // 1밀리초마다 카운트다운
			} catch (InterruptedException ie) {
				running = false;
				break; // 스레드 중단시 반복 종료
			}
		}

		// 타이머 종료 후 텍스트 설정
		setText(formatTime(startTimeMillis));
	}

	public void reset(long newStartTimeSec) {
		startTimeMillis = newStartTimeSec * 1000; // 초를 밀리세컨드로 변환하여 초기화
		running = false;
		setText(formatTime(startTimeMillis)); // 초기 시간으로 표시
	}

	public boolean isTimeOver() {
		return startTimeMillis <= 0; // 0이하면 true
	}

}
