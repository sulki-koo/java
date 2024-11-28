package javabasic.exgui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ExMemopad1 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("메모장 프로그램");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		frame.setLayout(new BorderLayout());
		
		JPanel listPanel = new JPanel();
		String[] memoList = {"1","2"};
		listPanel.add(new JList<String>(memoList));
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1,15));
		textPanel.add(new JTextArea("메모를 입력하세요"));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new JButton("메모 등록"));
		buttonPanel.add(new JButton("메모 수정"));
		buttonPanel.add(new JButton("메모 삭제"));
		
		
		frame.add(frame, BorderLayout.CENTER);
		frame.add(frame, BorderLayout.NORTH);
		frame.add(new JLayer(frame.add(listPanel)), BorderLayout.WEST);
		frame.add(new JLayer(frame.add(textPanel)), BorderLayout.EAST);
		frame.add(new JLayer(frame.add(buttonPanel)), BorderLayout.SOUTH);
		
		
		
		
		frame.setVisible(true);
		
	} // main

} // class
