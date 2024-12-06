package projectteam1;

// 맵 모양, 경로설정
public class MapData {

	private MouseRoadMap mrm = new MouseRoadMap(29,28);

	private int row = mrm.getSizex(); // 행
	private int col = mrm.getSizey(); // 열
	Wall wall;

	// 블록 2차원 배열로 공간 설정
	private Block[][] gameMap = new Block[row][col];

	public MapData() {

		wall = new Wall();
		
		int rowSize = gameMap.length;
		int colSize = gameMap[0].length;

		// 마우스 지나다닐수 있는 길
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				gameMap[i][j] = new Block(i, j, true);
			}
		}

		
		// 벽
		int pathRowSize = wall.getWallArr().length;

		for (int i = 0; i < pathRowSize; i++) {
			int x = wall.getWallArr()[i][0];
			int y = wall.getWallArr()[i][1];
			gameMap[x][y] = new Block(x, y, false);
		}

	} // 생성자

	public Block[][] getGameMap() {
		return gameMap;
	}

} // class