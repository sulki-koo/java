package projectteam1;

public class Wall {

	private int[][] wallArr = {
			{0,8}, {0,21},{1,1},{1,3},{1,5},{1,6},{1,8},{1,9},{1,10},{1,12},
			{1,13},{1,14},{1,16},{1,17},{1,19},{1,21},{1,22},{1,24},{1,26},{1,27},
			{2,1},{2,3},{2,6},{2,10},{2,13},{2,17},{2,22},{2,24},
			{3,3},{3,5},{3,7},{3,11},{3,13},{3,15},{3,17},{3,19},{3,21},{3,24},
			{4,1},{4,3},{4,5},{4,8},{4,15},{4,17},{4,20},{4,25},
			{5,2},{5,4},{5,6},{5,8},{5,10},{5,14},{5,16},{5,18},{5,20},{5,22},{5,24},
			{6,0},{6,4},{6,8},{6,13},{6,14},{6,18},{6,20},{6,22},{6,24},{6,26},{6,27},
			{7,0},{7,5},{7,6},{7,10},{7,11},{7,12},{7,13},{7,20},{7,21},{7,26},{7,27},
			{8,3},{8,5},{8,9},{8,10},{8,15},{8,16},{8,19},{8,20},{8,24},{8,25},
			{9,0},{9,3},{9,4},{9,9},{9,13},{9,14},{9,19},{9,20},{9,21},{9,25},{9,26},
			{10,3},{10,8},{10,9},{10,10},{10,15},{10,16},{10,18},{10,22},{10,23},{10,25},
			{11,1},{11,3},{11,5},{11,6},{11,10},{11,11},{11,16},{11,21},{11,22},{11,26},{11,27},
			{12,1},{12,3},{12,7},{12,8},{12,11},{12,15},{12,16},{12,20},{12,21},
			{13,0},{13,3},{13,6},{13,7},{13,14},{13,15},{13,19},{13,20},{13,24},
			{14,3},{14,8},{14,9},{14,13},{14,14},{14,18},{14,19},{14,23},{14,25},
			{15,1},{15,5},{15,7},{15,11},{15,12},{15,17},{15,19},{15,22},{15,23},{15,26},{15,27},
			{16,1},{16,7},{16,8},{16,9},{16,15},{16,16},{16,20},{16,24},
			{17,5},{17,8},{17,9},{17,16},{17,17},{17,20},{17,21},{17,24},{17,25},
			{18,4},{18,8},{18,9},{18,10},{18,11},{18,12},{18,21},{18,24},{18,25},
			{19,1},{19,7},{19,8},{19,14},{19,15},{19,19},{19,24},
			{20,1},{20,3},{20,5},{20,7},{20,9},{20,11},{20,13},{20,15},{20,19},{20,20},
			{21,1},{21,5},{21,7},{21,9},{21,12},{21,18},{21,19},{21,23},{21,24},{21,26},{21,27},
			{22,3},{22,5},{22,9},{22,12},{22,17},{22,18},{22,25},
			{23,0},{23,3},{23,7},{23,11},{23,15},{23,19},{23,22},{23,25},
			{24,3},{24,7},{24,11},{24,12},{24,15},{24,16},{24,17},{24,21},{24,22},{24,25},
			{25,1},{25,4},{25,9},{25,10},{25,13},{25,17},{25,20},{25,23},{25,26},
			{26,1},{26,3},{26,5},{26,10},{26,11},{26,16},{26,17},{26,22},{26,23},
			{27,1},{27,4},{27,8},{27,10},{27,13},{27,15},{27,19},{27,21},{27,24},
			{28,1},{28,4},{28,8},{28,10},{28,13},{28,15},{28,19},{28,21},{28,24}
		};
	
	public Wall() {
	}

	public Wall(int[][] wallArr) {
		this.wallArr = wallArr;
	}

	public int[][] getWallArr() {
		return wallArr;
	}

} // class