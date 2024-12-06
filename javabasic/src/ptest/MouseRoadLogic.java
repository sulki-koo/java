package ptest;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// 게임 로직(실행 메소드 모음)
public class MouseRoadLogic {
	
	public MouseRoadLogic() {
	}
	
	// 이미지 로드 및 크기조정하여 JLabel로 반환 메서드
	public JLabel chageImageLable(String imagePath, int width, int height) {
		ImageIcon logoIcon = new ImageIcon(imagePath); // 이미지 경로 가져오기
		Image image = logoIcon.getImage(); // 원본 이미지 가져오기
		Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // 이미지크기조정
		ImageIcon resizedIcon = new ImageIcon(resizedImage); // 크기 조정된 이미지 아이콘 생성
		return new JLabel(resizedIcon);
	}
	

	
	
	// 시작버튼 클릭시 타이머 작동 - 완성
	
	// 시작버튼 클릭시 마우스감지
	
	
	
	// 게임 클리어 조건 - 시간이 0이 아닌경우 도착버튼을 누르면 클리어
	
	// 게임클리어 후 종료버튼 클릭시 팝업으로 클리어축하 메시지보여줌

	

	// 게임클리어 후 종료버튼 클릭시 타이머가 멈춤 - 완성
	
	// 게임클리어 후 종료버튼 클릭시 마우스감지 해제
	
	
	// 게임오버인 경우 1 - block에 닿음
	// 게임오버인 경우 2 - 맵을 벗어남
	// 게임오버인 경우 3 - 시간초과

	

}
