package projectteam1;

// 맵 데이터의 맵을 불러오는 클래스
public class MapLoader {

	// mapData클래스의 맵들의 저장할 배열
	private MapData[] maps;

	public MapLoader() {

		maps = new MapData[3];  // 맵 3개 넣을 수 있음

		maps[0] = new MapData();
		//maps[1] = new Map클래스명();
		//maps[2] = new Map클래스명();

	}

	// gui에서 불러오기 위한 메서드
	public Block[][] loadingMap(int mapNum) {
		return maps[mapNum].getGameMap();
	}

} // class
