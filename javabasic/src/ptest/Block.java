package ptest;

import java.awt.Color;

import javax.swing.JButton;

public class Block extends JButton{

	private int x; // 가로
	private int y; // 세로
	private Color bgColor; // 블록 컬러
	private boolean pathYN; // 길 여부

	public Block(int x, int y, boolean pathYN) {
		this.x = x;
		this.y = y;
		this.bgColor = pathYN == true ? bgColor.WHITE : bgColor.BLACK;
		this.pathYN = pathYN;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public boolean isPathYN() {
		return pathYN;
	}

	public void setPathYN(boolean pathYN) {
		this.pathYN = pathYN;
	}
	
}
