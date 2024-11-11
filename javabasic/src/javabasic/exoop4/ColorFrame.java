package javabasic.exoop4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorFrame extends JFrame {

	// 상속받은 JFrame의 필요값 가져옴
	JFrame jFrame;
	JPanel jPanel;
	JPanel jBtnPanel;
	JButton redButton;
	JButton blueButton;
	JButton orangeButton;

	public ColorFrame() {
		init();
	}

	void init() {
		jFrame = new JFrame("배경색 변경 프로그램");
		jFrame.setLayout(new BorderLayout());
		jFrame.setBounds(100, 100, 400, 400);

		jPanel = new JPanel(); // 컨테이너(무언가를 붙일수 있는 패널)
		jPanel.setLayout(new BorderLayout());

		jBtnPanel = new JPanel();

		redButton = new JButton("RED");
		blueButton = new JButton("BLUE");
		orangeButton = new JButton("ORANGE");
		
		addListener(redButton,jPanel,Color.RED);
		addListener(blueButton,jPanel,Color.BLUE);
		addListener(orangeButton,jPanel,Color.ORANGE);

		jBtnPanel.add(redButton);
		jBtnPanel.add(blueButton);
		jBtnPanel.add(orangeButton);
		jPanel.add(jBtnPanel, BorderLayout.SOUTH);
		jFrame.add(jPanel, BorderLayout.CENTER);

		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 닫기 창 누르면 닫힘
		jFrame.setVisible(true);
	}

	public static void addListener(JButton jButton, JPanel jPanel, Color color) {
		// Listener -> 이벤트 감지 / ActionListener 인터페이스를 익명클래스로 사용
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jPanel.setBackground(color);
			}
		});
	}

	public static void main(String[] args) {
		new ColorFrame();
	}

} // class
