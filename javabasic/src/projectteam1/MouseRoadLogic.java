package projectteam1;

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

}
