package projectteam1;

// 맵 모양, 경로설정
public class MapData {
	
	public MapData() {
		
		Block[][] gameMap1 = new Block[16][16];
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {
				gameMap1[i][j]  = new Block(i,j);
			}
		}
		
		
		
	}  // 생성자
	
}  // class
