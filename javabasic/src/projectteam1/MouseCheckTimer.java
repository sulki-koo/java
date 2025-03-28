package projectteam1;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MouseCheckTimer {

	private Timer mouseCheckTimer;
	private Runnable onGameOver; // 게임오버시 알려줌
	private JPanel mazepanel;
	private boolean gameStared;

	public MouseCheckTimer(Runnable onGameOver, JPanel mazepanel) {
		this.onGameOver = onGameOver;
		this.mazepanel = mazepanel;
		this.gameStared = false;

		mouseCheckTimer = new Timer(30, e -> MouseLocation());
	}

	// 시작상태 설정
	public void setGameStared(boolean gameStared) {
		this.gameStared = gameStared;
	}

	public void start() {
		mouseCheckTimer.start();
	}

	public void stop() {
		mouseCheckTimer.stop();
	}

	// 마우스 좌표 확인
	private void MouseLocation() {
		if (!gameStared)
			return;

		PointerInfo pointerInfo = MouseInfo.getPointerInfo();
		if (pointerInfo == null) {
			System.out.println("마우스 좌표 확인불가");
			onGameOver.run();
			return;
		}

		Point mouseLocation = pointerInfo.getLocation();
		Point panelLocation = mazepanel.getLocationOnScreen();

		int panelX = panelLocation.x;
		int panelY = panelLocation.y;
		int panelWidth = mazepanel.getWidth();
		int panelHeight = mazepanel.getHeight();

		if (mouseLocation.x < panelX || mouseLocation.y < panelY || mouseLocation.x >= panelX + panelWidth
				|| mouseLocation.y >= panelY + panelHeight) {
			System.out.println("maze패널을 벗어남");
			onGameOver.run();
		}

	}

} // class
