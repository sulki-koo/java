package projectteam1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TimerManager {
	private TimeNum timer;
	private TimeBar timeBar;
	private Thread timerThread;
	private Thread timeBarThread;

	public TimerManager(int seconds) {
		timer = new TimeNum(seconds);
		timer.setBounds(250, 50, 100, 50); // 위치와 크기 설정
		timer.setHorizontalAlignment(SwingConstants.CENTER); // 텍스트 중앙 정렬
		timer.setFont(new Font("맑은 고딕", Font.BOLD, 60));
		timeBar = new TimeBar(seconds);
	}

	public JPanel getTimerPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(400, 125));
		panel.add(timer, BorderLayout.CENTER);
		panel.add(timeBar, BorderLayout.SOUTH);
		return panel;
	}

	public void start() {
		stop(); // 기존 스레드 종료
		timerThread = new Thread(timer);
		timeBarThread = new Thread(timeBar);
		timerThread.start();
		timeBarThread.start();
	}

	public void stop() {
		if (timerThread != null && timerThread.isAlive()) {
			timerThread.interrupt();
		}
		if (timeBarThread != null && timeBarThread.isAlive()) {
			timeBarThread.interrupt();
		}
		timeBar.stop();
	}

	public void reset(int seconds) {
		timer.reset(seconds);
		timeBar.reset(seconds);
	}

	public boolean isTimeOver() {
		return timer.isTimeOver();
	}

}