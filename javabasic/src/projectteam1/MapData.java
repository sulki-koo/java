package projectteam1;

// 맵 모양, 경로설정
public class MapData {

	private MouseRoadMap mrm = new MouseRoadMap(22, 22);

	private int row = mrm.getSizex(); // 행
	private int col = mrm.getSizey(); // 열
	Path path;

	// 블록 2차원 배열로 공간 설정
	private Block[][] gameMap = new Block[row][col];

	public MapData() {

		path = new Path();
		
		int rowSize = gameMap.length;
		int colSize = gameMap[0].length;

		// 검은 블록 배치 - 마우스 닿으면 안됨
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				gameMap[i][j] = new Block(i, j, false);
			}
		}

		int pathRowSize = path.getPathArr().length;

		for (int i = 0; i < pathRowSize; i++) {
			int x = path.getPathArr()[i][0];
			int y = path.getPathArr()[i][1];
			gameMap[x][y] = new Block(x, y, true);
		}

	} // 생성자

	public Block[][] getGameMap() {
		return gameMap;
	}

} // class
