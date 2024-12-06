package projectteam1;

import javax.swing.SwingUtilities;

public class MouseRoadMain {
	
	public static void main(String[] args) {
	
		// 게임 실행 - gui 클래스에서 만들어진 최종 실행 메소드 불러옴
		SwingUtilities.invokeLater(MouseRoadGUI :: new);
		
		
	}  // main

}  // class
