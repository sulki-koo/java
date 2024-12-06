package ptest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// 게임 GUI
public class MouseRoadGUI {

	Block[][] gameMap; // 게임맵
	int blockSize = 28; // 블록 하나당 size
	boolean gameStarted = false;

	Thread timerThread;
	Thread threadbar;
	int timeLeft = 40; // 남은 시간 (초 단위)

	boolean gameRunning = false;

	MouseRoadLogic logic = new MouseRoadLogic();

	public MouseRoadGUI() {

		JFrame frame = new JFrame("Mouse Road"); // 프레임만들기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼 누르면 닫히도록 설정
		frame.setSize(800, 1000); // 프레임 크기 설정

		JPanel basicPanel = new JPanel(new BorderLayout()); // 기본 패널
		frame.add(basicPanel); // 기본 패널 프레임에 붙이기

		JPanel topPanel = new JPanel(new BorderLayout()); // 상단 고정 패널 (랭킹, 타이머, 로고 틀)
		topPanel.setPreferredSize(new Dimension(800, 150)); // 크기 설정
		topPanel.setBackground(Color.WHITE);

		JPanel leftPanel = new JPanel(); // 왼쪽 로고
		JPanel rightPanel = new JPanel(); // 오른쪽 로고
		leftPanel.setPreferredSize(new Dimension(200, 150));
		rightPanel.setPreferredSize(new Dimension(200, 150));
		leftPanel.add(logic.chageImageLable("D:\\embededk\\files\\Mouse.png", 200, 150));
		rightPanel.add(logic.chageImageLable("D:\\embededk\\files\\Road.png", 200, 150));

		leftPanel.setBackground(Color.YELLOW); // 확인용
		rightPanel.setBackground(Color.BLUE); // 확인용

		topPanel.add(leftPanel, BorderLayout.WEST); // 왼쪽로고 추가
		topPanel.add(rightPanel, BorderLayout.EAST); // 오른쪽 로고 추가

		// [Timer] 가운데 패널
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(400, 125));

		TimeNum timer = new TimeNum(40);
		timer.setBounds(250, 50, 100, 50); // 위치와 크기 설정
		
		centerPanel.setBackground(Color.WHITE);
		centerPanel.add(timer);
		topPanel.add(centerPanel, BorderLayout.CENTER);

		// [Timer Bar] 가운데 패널 아래 직사각 패널
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(800, 25)); // 긴 직사각형 패널 크기
		bottomPanel.setLayout(null);

		TimeBar timebar = new TimeBar(timeLeft);
		bottomPanel.add(timebar);

		topPanel.add(bottomPanel, BorderLayout.AFTER_LAST_LINE);

		basicPanel.add(topPanel, BorderLayout.NORTH);

		// 맵로더에서 인덱스 0번의 맵을 호출
		MapLoader mapLoader = new MapLoader();
		gameMap = mapLoader.loadingMap(0);

		// 맵 그리기
		JPanel mazepanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g); // 그리기 초기화

				for (int i = 0; i < gameMap.length; i++) {
					for (int j = 0; j < gameMap[i].length; j++) {
						Block block = gameMap[i][j];

						// 블록 그리기
						g.setColor(block.getBgColor()); // MapLoader클래스의 0번 인덱스(MapData의 맵)의 설정된 색깔 가져오기
						g.fillRect(j * blockSize, i * blockSize, blockSize, blockSize);

						// 테두리 - 블럭 확인용
						g.setColor(Color.CYAN);
						g.drawRect(j * blockSize, i * blockSize, blockSize, blockSize);
					}
				}

			}
		};

		mazepanel.setPreferredSize(new Dimension(gameMap[0].length * blockSize, gameMap.length * blockSize));
		mazepanel.setLayout(null);
		basicPanel.add(mazepanel, BorderLayout.CENTER); // 그린 map 기본패널에 추가

		JButton startButton = new JButton(); // 시작 버튼
		startButton.setBounds(blockSize, 0, blockSize, blockSize);
		startButton.setBackground(Color.GREEN);
		startButton.setBorderPainted(false);
		startButton.addActionListener(e -> {
			if (!gameStarted) { // 게임 시작 누를때마다 스레드 새로 시작
				gameStarted = true;

				timer.reset(40);

				if (timerThread == null || !timerThread.isAlive()) {
					timerThread = new Thread(timer);
					timerThread.start();
					System.out.println("타이머");

					threadbar = new Thread(new TimeBar(timeLeft));
					threadbar.start();
					System.out.println("바");
				}
			}
		});
		mazepanel.add(startButton); // 시작버튼 맵위에 추가

		JButton endButton = new JButton(); // 도착 버튼
		endButton.setBounds(26 * blockSize, 28 * blockSize, blockSize, blockSize);
		endButton.setBackground(Color.RED);
		endButton.setBorderPainted(false);
		endButton.addActionListener(e -> {
			gameStarted = false;
			if (timerThread != null) {
				timerThread.interrupt(); // 종료
				System.out.println("타이머 종료");
			}
			if (threadbar != null) {
				threadbar.interrupt();
				System.out.println("타임바 종료");
			}
			clear();
		});
		mazepanel.add(endButton); // 시작버튼 맵위에 추가
		frame.add(basicPanel); // 기본 패널 프레임추가

		// 마우스 모션 리스너
		mazepanel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (!gameStarted)
					return;

				int x = e.getX() / blockSize; // x좌표
				int y = e.getY() / blockSize; // y좌표

				if (x < 0 || y < 0 || x >= gameMap[0].length || y >= gameMap.length) {
					if (timerThread != null) {
						timerThread.interrupt(); // 종료
						System.out.println("타이머 종료");
					}
					if (threadbar != null) {
						threadbar.interrupt();
						System.out.println("타임바 종료");
					}
					gameOver();
					return;
				}

				Block block = gameMap[y][x]; // 2차원배열은 반대로 들어감
				if (!block.isPathYN()) {
					if (timerThread != null) {
						timerThread.interrupt(); // 종료
						System.out.println("타이머 종료");
					}
					if (threadbar != null) {
						threadbar.interrupt();
						System.out.println("타임바 종료");
					}
					gameOver();
					return;
				}
			}
		});
		frame.setVisible(true); // 프레임 보이기
	}

	// 게임오버
	private void gameOver() {
		gameStarted = false;
		JOptionPane.showMessageDialog(null, "-GAME OVER-");
	}

	private void clear() {
		gameStarted = false;
		JOptionPane.showMessageDialog(null, "-CLEAL!-");
	}

} // class
