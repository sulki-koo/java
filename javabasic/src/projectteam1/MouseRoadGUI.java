package projectteam1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// 게임 GUI
public class MouseRoadGUI extends JFrame implements MouseListener, MouseMotionListener {

	private static final int CENTER = 0;
	private Block[][] gameMap; // 게임 맵 데이터
	private boolean gameStarted = false; // 게임 시작 여부
	private int timeRemaining = 40; // 남은 시간 (초)
	private JLabel timerLabel; // 타이머 표시 레이블
	private boolean timeOverFlag = false; // 시간을 초과했는지 확인하는 플래그
	private Point gameStartButtonPos; // 게임 시작 버튼 위치 (시작 위치)
	private boolean gameOverFlag = false; // 게임 오버 후 다시 시작할 수 있는지 여부

	private final int BLOCK_SIZE = 20; // 블록 크기
	private final int BLOCK_XNUM = 27; // 가로 블록 개수
	private final int BLOCK_YNUM = 28; // 세로 블록 개수

	private int rankTime; // 랭킹 시간 저장용 변수
	private JLabel mousePositionLabel; // 마우스 좌표 표시용 레이블
	private JPanel mazepanel;

	public MouseRoadGUI() {
		// 프레임만들기
		// JFrame frame = new JFrame("Mouse Road");
		this.setTitle("Mouse Road");

		// X버튼 누르면 닫히도록 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 팝업창
		String rule = "GAME RULE\n①\s초록색\s버튼을\s누르고\s시작\n②\s맵과,\s흰선을\s벗어나지 \s않게함\n③\s빨간색\s도착버튼까지\s이동";
		JOptionPane.showMessageDialog(null, rule);

		// 프레임 크기 설정
		// JFrame 사이즈
		this.setSize(800, 1000);
		// frame.setPreferredSize(new Dimension(800,1000));

		// 바탕패널
		JPanel basicPanel = new JPanel();
		basicPanel.setLayout(new BorderLayout());
		basicPanel.setBackground(Color.RED);
		add(basicPanel);

		// 상단패널
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(800, 150));
		topPanel.setBackground(Color.BLUE);
		basicPanel.add(topPanel, BorderLayout.NORTH);

		// [Logo] 왼쪽 패널
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(200, 120));
		ImageIcon logoIcon2 = new ImageIcon("D:\\embededk\\files\\Mouse.png");
		Image image2 = logoIcon2.getImage(); // 원본 이미지 가져오기
		// 패널 크기에 맞게 이미지 크기 조정
		Image resizedImage2 = image2.getScaledInstance(200, 120, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon2 = new ImageIcon(resizedImage2); // 크기 조정된 이미지 아이콘 생성
		// 크기 조정된 이미지 아이콘을 JLabel에 설정
		JLabel logoLabel2 = new JLabel(resizedIcon2);
		leftPanel.setBackground(Color.BLACK);
		leftPanel.add(logoLabel2); // 패널에 이미지 추가
		topPanel.add(leftPanel, BorderLayout.WEST);

		// [Logo] 오른쪽 패널
		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(200, 120));
		ImageIcon logoIcon = new ImageIcon("D:\\embededk\\files\\Road.png"); // 로고 이미지 로드
		Image image = logoIcon.getImage(); // 원본 이미지 가져오기
		// 패널 크기에 맞게 이미지 크기 조정
		Image resizedImage = image.getScaledInstance(200, 120, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage); // 크기 조정된 이미지 아이콘 생성
		// 크기 조정된 이미지 아이콘을 JLabel에 설정
		JLabel logoLabel = new JLabel(resizedIcon);
		rightPanel.setBackground(Color.WHITE);
		rightPanel.add(logoLabel); // 패널에 이미지 추가
		topPanel.add(rightPanel, BorderLayout.EAST);

		// [Timer] 가운데 패널
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(400, 125));

		TimeNum timerNum = new TimeNum(40); // 40초
		timerNum.setBounds(250, 50, 100, 50); // 위치와 크기 설정
		timerNum.setHorizontalAlignment(CENTER); // 텍스트 중앙 정렬
		timerNum.setFont(new Font("맑은 고딕", Font.BOLD, 60));

		centerPanel.add(timerNum);
		topPanel.add(centerPanel, BorderLayout.CENTER);

		// [Timer Bar] 가운데 패널 아래 직사각 패널
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(800, 30));
		bottomPanel.setLayout(null);

		TimeBar timebar = new TimeBar(40);

		bottomPanel.add(timebar);

		Thread barThread = new Thread(timebar);
		Thread numThread = new Thread(timerNum);

		topPanel.add(bottomPanel, BorderLayout.SOUTH);
		basicPanel.add(topPanel, BorderLayout.NORTH);

		// 맵로더에서 인덱스 0번의 맵을 호출
		MapLoader mapLoader = new MapLoader();
		gameMap = mapLoader.loadingMap(0);

		// 마우스 좌표 표시 레이블 추가
		mousePositionLabel = new JLabel("Mouse Position: ");
		mousePositionLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		mousePositionLabel.setPreferredSize(new Dimension(200, 30));
		topPanel.add(mousePositionLabel, BorderLayout.SOUTH); // 상단 패널에 추가

		// 맵 그리기 패널
		mazepanel = new JPanel(new GridLayout(BLOCK_YNUM, BLOCK_XNUM));
		mazepanel.setPreferredSize(new Dimension(800, 850));

		// 블록을 생성하고 맵에 추가
		for (int i = 0; i < gameMap.length; i++) {
			for (int j = 0; j < gameMap[i].length; j++) {
				Block block = gameMap[i][j];
				JButton blockButton = new JButton();
				blockButton.setBackground(block.getBgColor());
				// 버튼 완전 투명화
				// blockButton.setOpaque(true);
				// blockButton.setEnabled(false);

				// 시작 지점에 버튼 추가 (초록색)
				if (i == 0 && j == 1) {
					blockButton.setBackground(Color.GREEN);
					blockButton.setEnabled(true); // 클릭 가능
					blockButton.addActionListener(e -> {
						gameStarted = true;
						// 게임 시작 버튼 위치를 게임 시작 위치로 설정
						gameStartButtonPos = blockButton.getLocation(); // ! 버튼 클릭 시 위치 저장
						barThread.start();
						numThread.start();

					});
				}

				// 도착 지점에 버튼 추가 (^)
				if (i == 27 && j == 25) {
					blockButton.setBackground(Color.RED);
					blockButton.setEnabled(true); // 클릭 가능
					blockButton.addActionListener(e -> {
						if (gameStarted) {
							JOptionPane.showMessageDialog(this, "게임을 종료합니다! 축하합니다.");
							// barThread 종료
							// numThread 종료
							resetGame(); // 게임을 리셋하고 다시 시작
						}
					});
				}

				mazepanel.add(blockButton); // 버튼을 패널에 추가
			}
		}

		// 마우스 이벤트 추가
		mazepanel.addMouseListener(this);
		mazepanel.addMouseMotionListener(this);
		basicPanel.add(mazepanel, BorderLayout.CENTER);

		this.add(basicPanel, BorderLayout.CENTER);
		this.setVisible(true); // 프레임 표시
	}

	// 마우스 클릭 처리
	@Override
	public void mouseClicked(MouseEvent e) {
		if (!gameStarted)
			return;
	}

	// 게임 리셋
	private void resetGame() {
		// 게임을 리셋하는 코드
		timeRemaining = 40; // 남은 시간 초기화
		gameStarted = false; // 게임 상태 초기화
		gameOverFlag = false; // 게임 오버 상태 초기화
		timeOverFlag = false; // 시간 초과 플래그 초기화
		timerLabel.setText(String.valueOf(timeRemaining)); // 타이머 리셋
	}

	// 마우스 이동 처리
	@Override
	public void mouseMoved(MouseEvent e) {
		if (!gameStarted)
			return;

		// 정확한 블록 위치 계산
		int x = e.getX() / (mazepanel.getWidth() / BLOCK_XNUM);
		int y = e.getY() / (mazepanel.getHeight() / BLOCK_YNUM);

		// 현재 마우스 좌표 표시
		mousePositionLabel.setText("Mouse Position: (" + x + ", " + y + ")");

		// 게임 영역 벗어남 확인
		if (x < 0 || y < 0 || x >= BLOCK_XNUM || y >= BLOCK_YNUM ) {
			gameOver("게임 영역을 벗어났습니다! 게임 오버!");
			return;
		}

		// 현재 블록 검출 및 확인
		Block currentBlock = gameMap[y][x]; // 주의: 2D 배열은 gameMap[y][x]
		if (!currentBlock.isPathYN()) {
			gameOver("검은 블록에 닿았습니다! 게임 오버!");
		}

	}

	// 게임 오버 처리
	private void gameOver(String message) {
		// 게임 오버 메시지를 즉시 표시
		if (!gameOverFlag) {
			JOptionPane.showMessageDialog(this, message);
			gameOverFlag = true; // 한 번만 알림 표시
		}

		// 게임 종료 처리
		gameStarted = false;
	}

	// 사용하지 않는 마우스 이벤트 (빈 메서드)
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

}