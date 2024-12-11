package javaprojectteam1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

// 게임 GUI
public class MouseRoadGUI {

	private Block[][] gameMap; // 게임맵
	private int blockSize = 28; // 블록 하나당 size
	private boolean gameStarted = false;
	private JButton endButton;

	private TimeBar timebar;
	private TimeNum timer;
	private Thread timerThread;
	private Thread threadbar;
	private int second = 20; // 남은 시간 (초 단위)

	private JPanel mazepanel;
	private MouseCheckTimer mouseCheckTimer;

	private Sound sound;
	private Thread soundThread;

	private List<Point> pointList;
	MouseRoadLogic logic = new MouseRoadLogic();

	public MouseRoadGUI() {

		// 프레임만들기
		JFrame frame = new JFrame("Mouse Road");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼 누르면 닫히도록 설정
		frame.setSize(800, 1000); // 프레임 크기 설정

		// 기본 패널
		JPanel basicPanel = new JPanel(new BorderLayout());
		frame.add(basicPanel); // 기본 패널 프레임에 붙이기

		// 초기화
		pointList = new ArrayList<Point>();
		sound = new Sound();
		soundThread = new Thread(sound);
		soundThread.start();
		MapLoader mapLoader = new MapLoader();
		gameMap = mapLoader.loadingMap(0);

		// 룰 팝업
		String rule = "GAME RULE\n①\s초록색\s버튼을\s누르고\s시작\n②\s맵과,\s흰선을\s벗어나지 \s않게함\n③\s빨간색\s도착버튼까지\s이동";
		JOptionPane.showMessageDialog(null, rule);

		// 상단 고정 패널 (랭킹, 타이머, 로고 틀)
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(800, 150)); // 크기 설정

		// 왼쪽 로고
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(200, 150));
		leftPanel.add(logic.chageImageLable("D:\\embededk\\files\\Mouse.png", 200, 150));

		// 오른쪽 로고
		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(200, 150));
		rightPanel.add(logic.chageImageLable("D:\\embededk\\files\\Road.png", 200, 150));

		// [Timer] 가운데 패널
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(400, 125));
		timer = new TimeNum(20);
		timer.setBounds(250, 50, 100, 50); // 위치와 크기 설정
		timer.setHorizontalAlignment(SwingConstants.CENTER); // 텍스트 중앙 정렬
		timer.setFont(new Font("맑은 고딕", Font.BOLD, 60));
		centerPanel.setBackground(Color.WHITE);
		centerPanel.add(timer);

		// [Timer Bar] 가운데 패널 아래 직사각 패널
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(800, 25)); // MouseRoadGUI에서 TimeBar 초기화 및 설정
		bottomPanel.setLayout(null);
		TimeBar timebar = new TimeBar(second);
		bottomPanel.add(timebar);

		topPanel.add(leftPanel, BorderLayout.WEST); // 왼쪽로고 추가
		topPanel.add(rightPanel, BorderLayout.EAST); // 오른쪽 로고 추가
		topPanel.add(centerPanel, BorderLayout.CENTER);
		topPanel.add(bottomPanel, BorderLayout.SOUTH);

		basicPanel.add(topPanel, BorderLayout.NORTH);

		// 맵 그리기
		mazepanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g); // 그리기 초기화

				for (int i = 0; i < gameMap.length; i++) {
					for (int j = 0; j < gameMap[i].length; j++) {
						Block block = gameMap[i][j];

						// 블록 그리기
						g.setColor(block.getBgColor()); // MapLoader클래스에서 설정된 색깔 가져오기
						g.fillRect(j * blockSize, i * blockSize, blockSize, blockSize);

					}
				}
				g.setColor(Color.BLUE); // 점 색상
				for (Point p : pointList) {
					g.fillOval(p.x - 5, p.y - 5, 10, 10); // 점의 크기 및 위치
				}

			}
		};
		mazepanel.setPreferredSize(new Dimension(28 * blockSize, 27 * blockSize));
		mazepanel.setLayout(null);
		basicPanel.add(mazepanel, BorderLayout.CENTER); // 그린 map 기본패널에 추가

		mouseCheckTimer = new MouseCheckTimer(() -> gameOver(), mazepanel);

		// 시작 버튼
		JButton startButton = new JButton();
		startButton.setBounds(blockSize, 0, blockSize, blockSize);
		startButton.setBackground(Color.GREEN);
		startButton.setBorderPainted(false);

		startButton.addActionListener(e -> {
			if (!gameStarted) {
				gameStarted = true;

				sound.playStart();
				mouseCheckTimer.setGameStared(true);
				mouseCheckTimer.start();

				endButton.setEnabled(true);

				timer.reset(20); // 타이머 초기화
				timebar.reset(20); // 타임바 초기화

				if (timerThread == null || !timerThread.isAlive()) {
					timerThread = new Thread(timer);
					timerThread.start();

					threadbar = new Thread(timebar);
					threadbar.start();
				}

				// 상태 확인 스레드
				new Thread(() -> {
					while (true) {
						try {
							Thread.sleep(50);
							if (timer.isTimeOver()) {
								SwingUtilities.invokeLater(this::gameOver);
								break;
							}
						} catch (InterruptedException ex) {
							break;
						}
					}
				}).start();
			}
		});

		mazepanel.add(startButton); // 시작버튼 맵위에 추가

		endButton = new JButton(); // 도착 버튼
		endButton.setBounds(26 * blockSize, 28 * blockSize, blockSize, blockSize);
		endButton.setBackground(Color.RED);
		endButton.setBorderPainted(false);

		endButton.addActionListener(e -> {
			if (!gameStarted) {
				return;
			}
			gameStarted = false;
			clear();
		});
		endButton.setEnabled(false);
		mazepanel.add(endButton); // 도착버튼 맵위에 추가
		frame.add(basicPanel); // 기본 패널 프레임추가

		// 마우스 모션 리스너
		mazepanel.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				if (!gameStarted)
					return;

				pointList.add(e.getPoint()); // 위치 추가
				mazepanel.repaint(); // 화면 갱신

				int blockX = e.getX() / blockSize; // x좌표
				int blockY = e.getY() / blockSize; // y좌표

				Block block = gameMap[blockY][blockX]; // 2차원배열은 반대로 들어감
				if (!block.isPathYN()) {
					gameOver();
					return;
				}
			}
		});

		frame.setVisible(true); // 프레임 보이기
	}

	// 게임오버 메서드 수정
	private void gameOver() {
		threadStop();

		// 시간초과시 게임오버
		if (timebar != null) {
			timebar.stop(); // 타임바 멈춤 (스레드 상태 점검 후 처리)
		}

		mouseCheckTimer.stop(); // 마우스 체크 타이머 중지
		gameStarted = false;
		sound.playGameOver();
		endButton.setEnabled(false); // 도착 버튼 비활성화
		JOptionPane.showMessageDialog(null, "-GAME OVER-");
		pointList.clear();
	}

	// 게임 클리어 메서드 수정
	private void clear() {
		threadStop();
		mouseCheckTimer.stop(); // 마우스 체크 타이머 중지
		gameStarted = false;
		sound.playClear();
		JOptionPane.showMessageDialog(null, "축하합니다!!!\nCLEAR!");
		pointList.clear();
	}

	// 게임오버, 클리어시 스레드 중지
	public void threadStop() {
		if (timerThread != null && timerThread.isAlive()) {
			timerThread.interrupt(); // 타이머 종료
		}

		if (threadbar != null && threadbar.isAlive()) {
			threadbar.interrupt(); // 타임바 종료
		}
	}

} // class
