package javabasic.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class LayoutTest {

	public static void main(String[] args) {

		// "Layout"란 타이틀을 가진 JFrame 생성
		JFrame frame = new JFrame("Layout");

		// X버튼 누르면 닫히도록 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JFrame 사이즈
		frame.setSize(800, 600);

		// 탭패널 생성
		JTabbedPane tabbedPane = new JTabbedPane();

		// 1. FlowLayout
		JPanel flowLayoutpJPanel = new JPanel(new FlowLayout());
		for (int i = 1; i <= 100; i++) {
			flowLayoutpJPanel.add(new JButton("버튼" + i));
		}
		tabbedPane.addTab("FlowLayout", flowLayoutpJPanel);

		// 2. BorderLayout
		JPanel borderLayoutPanel = new JPanel(new BorderLayout());
		borderLayoutPanel.add(new JButton("NORTH"), BorderLayout.NORTH);
		borderLayoutPanel.add(new JButton("SOUTH"), BorderLayout.SOUTH);
		borderLayoutPanel.add(new JButton("WEST"), BorderLayout.WEST);
		borderLayoutPanel.add(new JButton("EAST"), BorderLayout.EAST);
		borderLayoutPanel.add(new JButton("CENTER"), BorderLayout.CENTER);
		tabbedPane.addTab("BorderLayout", borderLayoutPanel);

		// 3. GridLayout
		JPanel gridLayoutPanel = new JPanel(new GridLayout(2, 3));
		for (int i = 1; i <= 6; i++) {
			gridLayoutPanel.add(new JButton("버튼" + i));
		}
		tabbedPane.addTab("GridLayout", gridLayoutPanel);

		// 4. CardLayout
		JPanel cardLayoutPanel = new JPanel(new CardLayout());
		CardLayout cardLayout = (CardLayout) cardLayoutPanel.getLayout();
		for (int i = 1; i <= 3; i++) {
			cardLayoutPanel.add(new JLabel("카드 " + i, SwingConstants.CENTER), // center 정렬
					"Card " + i);
		}
		JPanel cardControlPanel = new JPanel(new FlowLayout());
		JButton nextButton = new JButton("다음 카드");
		// 버튼 누르면 다음 카드를 보여줌
		nextButton.addActionListener(e -> cardLayout.next(cardLayoutPanel));
		cardControlPanel.add(nextButton);

		JPanel cardPanelContainer = new JPanel(new BorderLayout());
		cardPanelContainer.add(cardLayoutPanel, BorderLayout.CENTER);
		cardPanelContainer.add(cardControlPanel, BorderLayout.SOUTH);
		tabbedPane.addTab("CardLayout", cardPanelContainer);

		// 5. GridBagLayout
		JPanel gridbagLayoutPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.BOTH; // 양쪽 모두 채움
		gbc.weightx = 1.0; // x가중치
		gbc.weighty = 1.0; // y가중치

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gridbagLayoutPanel.add(new JButton("버튼1 (0,0,크기2*1)"), gbc);

		gbc.gridx = 31;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gridbagLayoutPanel.add(new JButton("버튼2 (1,0)"), gbc);

		gbc.gridx = 21;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gridbagLayoutPanel.add(new JButton("버튼3 (1,1)"), gbc);

		tabbedPane.addTab("GridBagLayout", gridbagLayoutPanel);

		/*
		 * GridBagConstraints : GridBagLayout에서 컴포넌트의 위치, 크기, 정렬방식을 제어 gridx, gridy :
		 * 컴포넌트가 배치될 격자의 열, 행 gridwidth, gridheight : 컴포넌트가 차지할 열의 수, 행의 수 weightx,
		 * weighty : 격자 공간이 남을 때 각 셀이 얼마나 공간을 더 가져갈지 fill : 컴포넌트가 셀 내에서 공간을 채우는 방식
		 * GridBagConstraints.NONE : 크기 고정, 확장하지 않음 (기본값) GridBagConstraints.HORIZONTAL
		 * : 가로로만 확장 GridBagConstraints.VERTICAL : 세로로만 확장 GridBagConstraints.BOTH : 가로,
		 * 세로 모두 확장 anchor : 컴포넌트가 셀 내에서 어디에 배치될지 GridBagConstraints.CENTER : 셀에서 센터에
		 * GridBagConstraints.NORTH : 셀에서 위쪽에 GridBagConstraints.SOUTH : 셀에서 아래쪽에
		 * GridBagConstraints.EAST : 셀에서 오른쪽에 GridBagConstraints.WEST : 셀에서 왼쪽에 insets :
		 * 셀과 컴포넌트 간의 여백 -> new insets를 만들어야됨 ipadx, ipady : 컴포넌트의 내부 여백
		 */

		// 6. BoxLayout
		JPanel boxLayoutPanel = new JPanel();
		boxLayoutPanel.setLayout(new BoxLayout(boxLayoutPanel, BoxLayout.Y_AXIS));
		for (int i = 1; i <= 5; i++) {
			boxLayoutPanel.add(new JButton("버튼" + i));
		}
		tabbedPane.addTab("BoxLayout", boxLayoutPanel);

		frame.add(tabbedPane);
		frame.setVisible(true);

	} // main

} // class
