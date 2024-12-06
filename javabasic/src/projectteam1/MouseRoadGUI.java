package projectteam1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// 게임 GUI
public class MouseRoadGUI {

	private static final int CENTER = 0;
	Block[][] gameMap; // 게임맵
	int blockSize = 28; // 블록 하나당 size
	boolean gameStarted = false;
	List<Point> pointList;
	JButton endButton;
	
	TimeNum timer;
	Thread timerThread;
	Thread threadbar;
	int second = 20; // 남은 시간 (초 단위)

	MouseRoadLogic logic = new MouseRoadLogic();
	JPanel mazepanel;
	MouseCheckTimer mouseCheckTimer;
	Sound sound;
	Thread soundThread;

	public MouseRoadGUI() {

		JFrame frame = new JFrame("Mouse Road"); // 프레임만들기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼 누르면 닫히도록 설정
		frame.setSize(800, 1000); // 프레임 크기 설정

		JPanel basicPanel = new JPanel(new BorderLayout()); // 기본 패널
		frame.add(basicPanel); // 기본 패널 프레임에 붙이기

		pointList = new ArrayList<Point>();
		sound = new Sound();
		soundThread = new Thread();

		// 룰 팝업
		String rule = "GAME RULE\n①\s초록색\s버튼을\s누르고\s시작\n②\s맵과,\s흰선을\s벗어나지 \s않게함\n③\s빨간색\s도착버튼까지\s이동";
		JOptionPane.showMessageDialog(null, rule);

		JPanel topPanel = new JPanel(new BorderLayout()); // 상단 고정 패널 (랭킹, 타이머, 로고 틀)
		topPanel.setPreferredSize(new Dimension(800, 150)); // 크기 설정

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

		timer = new TimeNum(20);
		timer.setBounds(250, 50, 100, 50); // 위치와 크기 설정
		timer.setHorizontalAlignment(CENTER); // 텍스트 중앙 정렬
		timer.setFont(new Font("맑은 고딕", Font.BOLD, 60));
		
		centerPanel.setBackground(Color.WHITE);
		centerPanel.add(timer);
		topPanel.add(centerPanel, BorderLayout.CENTER);

		// [Timer Bar] 가운데 패널 아래 직사각 패널
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(800, 25)); // 긴 직사각형 패널 크기
		bottomPanel.setLayout(null);

		TimeBar timebar = new TimeBar(second);
		bottomPanel.add(timebar);

		topPanel.add(bottomPanel, BorderLayout.SOUTH);

		basicPanel.add(topPanel, BorderLayout.NORTH);

		soundThread = new Thread(sound);
		soundThread.start();
//		System.out.println("노래재생");

		// 맵로더에서 인덱스 0번의 맵을 호출
		MapLoader mapLoader = new MapLoader();
		gameMap = mapLoader.loadingMap(0);

		// 맵 그리기
		mazepanel = new JPanel() {
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

		JButton startButton = new JButton(); // 시작 버튼
		startButton.setBounds(blockSize, 0, blockSize, blockSize);
		startButton.setBackground(Color.GREEN);
		startButton.setBorderPainted(false);

		startButton.addActionListener(e -> {
			if (!gameStarted) { // 게임 시작 누를때마다 스레드 새로 시작
				gameStarted = true;

				sound.playStart();  // 시작 사운드
				mouseCheckTimer.setGameStared(true);  // 마우스 체크
				mouseCheckTimer.start();

				endButton.setEnabled(true);
				
				timer.reset(20);
				
				if (timerThread == null || !timerThread.isAlive()) {  // 타이머, 타이머바 시작
					timerThread = new Thread(timer);
					timerThread.start();
					System.out.println("타이머");

					threadbar = new Thread(timebar);
					threadbar.start();
					System.out.println("바");
					
					 // 상태 확인 스레드
                    new Thread(() -> {
                        while (true) {
                            try {
                                Thread.sleep(50); // 50ms 간격으로 상태 확인
                                if (timer.isTimeOver()) { // 시간이 0인지 확인
                                    SwingUtilities.invokeLater(this::gameOver); // UI 스레드에서 gameOver 호출
                                    break; // 확인 스레드 종료
                                }
                            } catch (InterruptedException ex) {
                                break; // 스레드가 종료되면 루프 종료
                            }
                        }
                    }).start();
				}
			}
		});
		mazepanel.add(startButton); // 시작버튼 맵위에 추가

		endButton = new JButton(); // 도착 버튼
		endButton.setBounds(26 * blockSize, 28 * blockSize, blockSize, blockSize);
		endButton.setBackground(Color.RED);
		endButton.setBorderPainted(false);

		endButton.addActionListener(e -> {
			if(!gameStarted) {
				System.out.println("게임 실행중 아님");
				return;
			}
			gameStarted = false;
			clear();
		});
		endButton.setEnabled(false);
		mazepanel.add(endButton); // 시작버튼 맵위에 추가
		frame.add(basicPanel); // 기본 패널 프레임추가
		

		// 마우스 모션 리스너
		mazepanel.addMouseMotionListener(new MouseAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				if (!gameStarted)
					return;

				pointList.add(e.getPoint());
				mazepanel.repaint();

				// System.out.println(e.getPoint()); // 위치 출력`
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

	// 게임오버
	private void gameOver() {
		if (timerThread != null && timerThread.isAlive()) {
			timerThread.interrupt(); // 종료
			System.out.println("타이머 종료");
			threadbar.interrupt();
			System.out.println("타임바 종료");
		}

		mouseCheckTimer.stop();
		gameStarted = false;
		sound.playGameOver();
		endButton.setEnabled(false);
		JOptionPane.showMessageDialog(null, "-GAME OVER-");
		pointList.clear();
	}

	// 게임 클리어
	private void clear() {
		if (timerThread != null && timerThread.isAlive()) {
			timerThread.interrupt(); // 종료
			System.out.println("타이머 종료");
			threadbar.interrupt();
			System.out.println("타임바 종료");
		}
		mouseCheckTimer.stop();
		gameStarted = false;
		sound.playClear();
		JOptionPane.showMessageDialog(null, "-CLEAR!-");
		pointList.clear();
	}

} // class
