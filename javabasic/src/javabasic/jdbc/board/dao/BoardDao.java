package javabasic.jdbc.board.dao;

import java.util.List;

import javabasic.jdbc.board.model.Board;

public interface BoardDao {
	
	public abstract List<Board> listBoard();

	public abstract Board getBoard(int bid); // 조회

	public abstract int registBoard(Board board); // 등록
	
	public abstract int modifyBoard(Board board); // 업데이트
	
	public abstract int removeBoard(int bid); // 삭제
	
}
