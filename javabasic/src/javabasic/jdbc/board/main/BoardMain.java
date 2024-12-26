package javabasic.jdbc.board.main;

import java.util.List;

import javabasic.jdbc.board.model.Board;
import javabasic.jdbc.board.service.BoardService;
import javabasic.jdbc.board.service.impl.BoardServiceImpl;

public class BoardMain {

	public static void main(String[] args) {
		
		BoardService boardService = new BoardServiceImpl();
		
//		List<Board> boardList = boardService.listBoard();
//		for(Board board:boardList) {
//			System.out.println(board);
//		}
		
//		System.out.println(boardService.getBoard(2));
		
//		boardService.registBoard(new Board(0, "영상게시판",null,null));
		
//		boardService.modifyBoard(new Board(21,"new영상게시판",null,null));
		
		boardService.removeBoard(21);
	}

}
