package projectteam1;

import java.awt.Point;

// 맵 데이터의 맵을 불러오는 클래스
public class MapLoader {

	// mapData클래스의 맵들의 저장할 배열
	private MapData[] maps;
	private Block[][] gameMap;

	public MapLoader() {
		maps = new MapData[1];
		maps[0] = new MapData();
		// maps[1] = new Map클래스명(); //예시
		// maps[2] = new Map클래스명();
	}

	// gui에서 불러오기 위한 메서드
	public Block[][] loadingMap(int mapNum) {
		return maps[mapNum].getGameMap();
	}

	public void loadMap(int mapIndex) {
		MapLoader mapLoader = new MapLoader();
		gameMap = mapLoader.loadingMap(mapIndex);
	}

	public Block[][] getGameMap() {
		return gameMap;
	}

	public Point getStartPosition() {
		// Return start position from gameMap
		return new Point(1, 0); // 예시 좌표
	}

	public Point getEndPosition() {
		// Return end position from gameMap
		return new Point(27, 25); // 예시 좌표
	}

} // class
