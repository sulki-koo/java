package projectteam1;

import java.awt.Color;

public class Block {
	
	private int x;
	private int y;
	private Color color;
	private boolean block;
	

	public Block(int x, int y) {
		this.x = x;
		this.y = y;
		this.color = color.BLACK;
		this.block = true;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

	@Override
	public String toString() {
		return "Block [x=" + x + ", y=" + y + ", color=" + color + ", block=" + block + "]";
	}

}
