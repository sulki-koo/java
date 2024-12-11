package javaprojectteam1;

// 맵 데이터의 맵을 불러오는 클래스
public class MapLoader {

	// mapData클래스의 맵들의 저장할 배열
	private MapData[] maps;

	public MapLoader() {
		maps = new MapData[1]; 
		maps[0] = new MapData();
	}

	// gui에서 불러오기 위한 메서드
	public Block[][] loadingMap(int mapNum) {
		return maps[mapNum].getGameMap();
	}
	
} // class
