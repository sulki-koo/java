package projectteam1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 게임 GUI
public class MouseRoadGUI {

	Block[][] gameMap;

	public MouseRoadGUI() {
		// 프레임만들기
		JFrame frame = new JFrame("Mouse Road");

		// X버튼 누르면 닫히도록 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임 크기 설정
		// JFrame 사이즈
		frame.setSize(800, 1000);

		// 기본 패널 만들기
		JPanel basicPanel = new JPanel();
		basicPanel.setLayout(new BorderLayout());

		// 상단 고정 패널 (랭킹, 타이머, 로고 틀)
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(700, 150)); // 크기 설정

		// [Ranking] 왼쪽 패널
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(200, 150));
		leftPanel.setBackground(new Color(200, 200, 255));
		leftPanel.add(new JLabel("Ranking"));
		// leftPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 5)); // 테두리
		topPanel.add(leftPanel, BorderLayout.WEST);

		// [Timer] 가운데 패널
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(300, 125));
		centerPanel.add(new JLabel("Timer"));
		topPanel.add(centerPanel, BorderLayout.CENTER);

		TimeNum timer = new TimeNum(40); // 40초
		timer.setBounds(250, 50, 100, 50); // 위치와 크기 설정
		centerPanel.add(timer);

		Thread timerThread = new Thread(timer);
		timerThread.start();

		// [Logo] 오른쪽 패널
		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(200, 150));
		rightPanel.setBackground(new Color(200, 255, 200));
		rightPanel.add(new JLabel("Logo"));
		topPanel.add(rightPanel, BorderLayout.EAST);

		// [Timer Bar] 가운데 패널 아래 직사각 패널
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(300, 25)); // 긴 직사각형 패널 크기
		bottomPanel.setBackground(new Color(200, 255, 100)); // 색상 설정
		bottomPanel.add(new JLabel("Time Bar"));

		bottomPanel.setLayout(null);

		int second = 40;
		TimeBar timebar = new TimeBar(second);
		Thread threadbar = new Thread(timebar);

		bottomPanel.add(timebar);
		threadbar.start();

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
				int blockSize = 35; // 블록 하나당 size

				int wigth = getWidth(); // frame 너비
				int height = getHeight(); // frame 높이

				int startX = (wigth - gameMap[0].length * blockSize) / 2; // 시작위치 X(가로)는 (너비 - 인덱스 길이*블록 하나당 사이즈)/2
				int startY = (height - gameMap.length * blockSize) / 2; // 시작위치 Y(세로)는 (높이 - 인덱스 길이*블록 하나당 사이즈)/2

				for (int i = 0; i < gameMap.length; i++) {
					for (int j = 0; j < gameMap[i].length; j++) {
						Block block = gameMap[i][j];

						// 블록 그리기
						g.setColor(block.getBgColor()); // MapLoader클래스의 0번 인덱스(MapData의 맵)의 설정된 색깔 가져오기
						g.fillRect(startX + j * blockSize, startY + i * blockSize, blockSize, blockSize);

						// 테두리 - 블럭 확인용
						 g.setColor(Color.CYAN);
						 g.drawRect(startX+j*blockSize, startY+i*blockSize, blockSize, blockSize);
					}
				}

			}
		};

		// 그린 map 기본패널에 추가
		basicPanel.add(mazepanel, BorderLayout.CENTER);

		// 각 셀에 버튼 추가 (이후 기능 추가 가능)

		// 마우스 리스너 패널
//      JPanel mouseListenerPanel = new JPanel();
//      JLabel mouseLabel = new JLabel("마우스 상태: 대기 중");
//      mouseListenerPanel.addMouseListener(new MouseAdapter() {
//         @Override
//         public void mouseEntered(MouseEvent e) {
//            mouseLabel.setText("마우스 상태: 영역 안");
//         }
//         
//         @Override
//         public void mouseExited(MouseEvent e) {
//            mouseLabel.setText("마우스 상태: 영역 밖");
//         }
//      });
//      mouseListenerPanel.add(mouseLabel); // 마우스 리스너
		// 팝업창

		// 맵보드의 블럭들 만들기

		// 맵보드의 시작, 종료 버튼
		// 버튼 클릭시 이벤트 발생

		// 검은 화면 - black 클래스
		// 시작버튼 클릭시 사라지고, 종료버튼 클릭시 다시 발생

		// 검은블럭에 마우스가 닿으면 gameover 되는 이벤트 발생 만들기

		// 검은 화면이 맵을 가린동안 마우스 에리어 이벤트 발생시키지 않도록하기

		// 종료버튼 클릭시 랭킹보드 랭킹갱신
		// 메인 프레임 설정
		// frame.setLayout(new BorderLayout());

		frame.add(basicPanel); // 상단 패널
		frame.setVisible(true); // 프레임 보이기

	}
}
