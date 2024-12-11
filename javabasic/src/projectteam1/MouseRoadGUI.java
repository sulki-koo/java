package projectteam1;

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

// 게임 GUI
public class MouseRoadGUI {

	private TimerManager timerManager;
	private SoundManager soundManager;
	private MapLoader mapLoader;
	private MouseRoadLogic logic;

	int second = 20; // 남은 시간 (초 단위)
	private JPanel mazepanel;
	private List<Point> pointList;

	public MouseRoadGUI() {
		JFrame frame = new JFrame("Mouse Road");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 1000);

		// 매니저 초기화
		timerManager = new TimerManager(20);
		soundManager = new SoundManager();
		mapLoader = new MapLoader();
		logic = new MouseRoadLogic();

		// GUI 초기화
		JPanel basicPanel = new JPanel(new BorderLayout());
		frame.add(basicPanel);

		pointList = new ArrayList<>();

		// 룰 팝업
		String rule = "GAME RULE\n①\s초록색\s버튼을\s누르고\s시작\n②\s맵과,\s흰선을\s벗어나지 \s않게함\n③\s빨간색\s도착버튼까지\s이동";
		JOptionPane.showMessageDialog(null, rule);

		JPanel topPanel = new JPanel(new BorderLayout()); // 상단 고정 패널 (랭킹, 타이머, 로고 틀)
		topPanel.setPreferredSize(new Dimension(800, 150)); // 크기 설정

		JPanel leftPanel = new JPanel(); // 왼쪽 로고
		leftPanel.setPreferredSize(new Dimension(200, 150));
		leftPanel.add(logic.chageImageLable("D:\\embededk\\files\\Mouse.png", 200, 150));
		topPanel.add(leftPanel, BorderLayout.WEST); // 왼쪽로고 추가

		JPanel rightPanel = new JPanel(); // 오른쪽 로고
		rightPanel.setPreferredSize(new Dimension(200, 150));
		rightPanel.add(logic.chageImageLable("D:\\embededk\\files\\Road.png", 200, 150));
		topPanel.add(rightPanel, BorderLayout.EAST); // 오른쪽 로고 추가
		
		// 타이머 및 타임바 추가
		topPanel.add(timerManager.getTimerPanel(), BorderLayout.CENTER);
		basicPanel.add(topPanel, BorderLayout.NORTH);

		// 게임 맵 로드 및 그리기
		mapLoader.loadMap(0);
		mazepanel = createMazePanel(mapLoader.getGameMap());
		basicPanel.add(mazepanel, BorderLayout.CENTER);

		// 이벤트 추가
		addMouseListeners();
		addButtons(mazepanel);

		frame.setVisible(true);
	}

	private JPanel createMazePanel(Block[][] gameMap) {
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (int i = 0; i < gameMap.length; i++) {
					for (int j = 0; j < gameMap[i].length; j++) {
						Block block = gameMap[i][j];
						g.setColor(block.getBgColor());
						g.fillRect(j * 28, i * 28, 28, 28);
					}
				}
			}
		};
		panel.setPreferredSize(new Dimension(28 * 28, 27 * 28));
		panel.setLayout(null);
		return panel;
	}

	private void addMouseListeners() {
		mazepanel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (!logic.isGameStarted())
					return;

				pointList.add(e.getPoint());
				mazepanel.repaint();

				int blockX = e.getX() / 28;
				int blockY = e.getY() / 28;
				Block block = mapLoader.getGameMap()[blockY][blockX];

				if (!block.isPathYN()) {
					gameOver();
				}
			}
		});
	}

	private void addButtons(JPanel panel) {
		JButton startButton = new JButton();
		startButton.setBounds(28, 0, 28, 28);
		startButton.setBackground(Color.GREEN);
		startButton.setBorderPainted(false);

		startButton.addActionListener(e -> {
			if (!logic.isGameStarted()) {
				logic.startGame();
				timerManager.reset(20);
				timerManager.start();
				soundManager.playStart();
			}
		});
		panel.add(startButton);

		JButton endButton = new JButton();
		endButton.setBounds(26 * 28, 28 * 28, 28, 28);
		endButton.setBackground(Color.RED);
		endButton.setBorderPainted(false);

		endButton.addActionListener(e -> clear());
		panel.add(endButton);
	}

	private void gameOver() {
		timerManager.stop();
		soundManager.playGameOver();
		JOptionPane.showMessageDialog(null, "-GAME OVER-");
		pointList.clear();
		logic.endGame();
	}

	private void clear() {
		timerManager.stop();
		soundManager.playClear();
		JOptionPane.showMessageDialog(null, "-CLEAR!-");
		pointList.clear();
		logic.endGame();
	}
}