package projectteam1;

// 게임맵 
//벽, 길
public class MouseRoadMap {

	private int sizex; // 맵 전체 크기의 x 축
	private int sizey; // y 축

	public MouseRoadMap() {
	}

	public MouseRoadMap(int sizex, int sizey) {
		this.sizex = sizex;
		this.sizey = sizey;
	}

	public int getSizex() {
		return sizex;
	}

	public void setSizex(int sizex) {
		this.sizex = sizex;
	}

	public int getSizey() {
		return sizey;
	}

	public void setSizey(int sizey) {
		this.sizey = sizey;
	}

}
