package ptest;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GptGUI {

	Block[][] gameMap;
	boolean gameStarted = false;
	int timeLeft = 40; // 남은 시간 (초 단위)
	JLabel timerLabel; // 타이머 표시 레이블
	boolean gameRunning = false;

	public GptGUI() {
		JFrame frame = new JFrame("Mouse Road");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 1000);

		// 기본 패널
		JPanel basicPanel = new JPanel(new BorderLayout());
		frame.add(basicPanel);

		// 상단 패널
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(700, 150));
		topPanel.setBackground(Color.LIGHT_GRAY);

		// 상단 패널 - 게임오버 리스너
		topPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (gameRunning) {
					gameOver();
				}
			}
		});

		// [Logo] 왼쪽 패널
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(200, 150));
		ImageIcon logoIcon2 = new ImageIcon("D:\\embededk\\files\\Mouse.png");
		Image image2 = logoIcon2.getImage(); // 원본 이미지 가져오기
		// 패널 크기에 맞게 이미지 크기 조정
		Image resizedImage2 = image2.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon2 = new ImageIcon(resizedImage2); // 크기 조정된 이미지 아이콘 생성
		// 크기 조정된 이미지 아이콘을 JLabel에 설정
		JLabel logoLabel2 = new JLabel(resizedIcon2);
		leftPanel.add(logoLabel2); // 패널에 이미지 추가
		topPanel.add(leftPanel, BorderLayout.WEST);

		// 타이머 패널
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(400, 125));
		timerLabel = new JLabel("Time: " + timeLeft + "s");
		timerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 60));
		centerPanel.add(timerLabel);
		topPanel.add(centerPanel, BorderLayout.CENTER);

		TimeNum timerNum = new TimeNum(40); // 40초

		centerPanel.add(timerNum);

		topPanel.add(centerPanel, BorderLayout.CENTER);

		// [Logo] 오른쪽 패널
		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(200, 150));
		ImageIcon logoIcon = new ImageIcon("D:\\embededk\\files\\Road.png"); // 로고 이미지 로드
		Image image = logoIcon.getImage(); // 원본 이미지 가져오기
		// 패널 크기에 맞게 이미지 크기 조정
		Image resizedImage = image.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage); // 크기 조정된 이미지 아이콘 생성
		// 크기 조정된 이미지 아이콘을 JLabel에 설정
		JLabel logoLabel = new JLabel(resizedIcon);
		rightPanel.add(logoLabel); // 패널에 이미지 추가
		topPanel.add(rightPanel, BorderLayout.EAST);

		basicPanel.add(topPanel, BorderLayout.NORTH);

		// [Timer Bar] 가운데 패널 아래 직사각 패널
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(800, 30));
		bottomPanel.setLayout(null);

		int second = 40;
		TimeBar timebar = new TimeBar(second);

		bottomPanel.add(timebar);

		Thread barThread = new Thread(timebar);
		Thread numThread = new Thread(timerNum);

		topPanel.add(bottomPanel, BorderLayout.SOUTH);

		basicPanel.add(topPanel, BorderLayout.NORTH);

		// 맵 로더 호출
		MapLoader mapLoader = new MapLoader();
		gameMap = mapLoader.loadingMap(0);
		int blockSize = 28;

		// 맵 그리기 패널
		JPanel mazePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (int i = 0; i < gameMap.length; i++) {
					for (int j = 0; j < gameMap[i].length; j++) {
						Block block = gameMap[i][j];
						g.setColor(block.getBgColor());
						g.fillRect(j * blockSize, i * blockSize, blockSize, blockSize);
						g.setColor(Color.CYAN);
						g.drawRect(j * blockSize, i * blockSize, blockSize, blockSize);
					}
				}
			}
		};
		mazePanel.setPreferredSize(new Dimension(gameMap[0].length * blockSize, gameMap.length * blockSize));
		mazePanel.setLayout(null);
		basicPanel.add(mazePanel, BorderLayout.CENTER);

		// 시작 버튼 추가
		JButton startButton = new JButton();
		startButton.setBounds(blockSize, 0, blockSize, blockSize);
		startButton.setBackground(Color.GREEN);
		startButton.setBorderPainted(false);
		startButton.addActionListener(e -> {
			gameStarted = true;
			startTimer();
		});
		mazePanel.add(startButton);

		// 종료 버튼 추가
		JButton stopButton = new JButton();
		stopButton.setBounds(25 * blockSize, 27 * blockSize, blockSize, blockSize);
		stopButton.setBackground(Color.RED);
		stopButton.setBorderPainted(false);
		stopButton.addActionListener(e -> gameStarted = false);
		mazePanel.add(stopButton);

		// 마우스 이벤트 리스너
		mazePanel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (!gameStarted)
					return;

				int x = e.getX() / blockSize;
				int y = e.getY() / blockSize;

				if (x < 0 || y < 0 || x >= gameMap[0].length || y >= gameMap.length) {
					gameOver();
					return;
				}

				Block block = gameMap[y][x];
				if (block.getBgColor().equals(Color.BLACK)) {
					gameOver();
				}
			}
		});

		frame.setVisible(true);
	}

	// 타이머 시작
	private void startTimer() {
		Timer timer = new Timer(1000, e -> {
			timeLeft--;
			timerLabel.setText("Time: " + timeLeft + "s");
			if (timeLeft <= 0) {
				((Timer) e.getSource()).stop();
				gameOver();
			}
		});
		timer.start();
	}

	// 게임 오버 처리
	private void gameOver() {
		gameStarted = false;
		JOptionPane.showMessageDialog(null, "Game Over!", "Message", JOptionPane.ERROR_MESSAGE);
	}
}