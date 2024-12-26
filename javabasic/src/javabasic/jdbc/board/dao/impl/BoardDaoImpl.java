package javabasic.jdbc.board.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabasic.jdbc.board.dao.BoardDao;
import javabasic.jdbc.board.model.Board;
import javabasic.jdbc.board.util.ConnectionUtil;

public class BoardDaoImpl implements BoardDao {

	static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public BoardDaoImpl() {
		conn = connectionUtil.getConnection();
	}

	@Override
	public List<Board> listBoard() {
		String sql = " select * from board order by bid ";
		List<Board> boardList = new ArrayList<Board>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Board board = new Board();
					board.setBid(rs.getInt("bid"));
					board.setBname(rs.getString("bname"));
					board.setBregdate(rs.getTimestamp("bregdate"));
					board.setBdelyn(rs.getString("bdelyn"));
					boardList.add(board);
				}
				return boardList;
			} else {
				return null;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		} finally {
			connectionUtil.closeAll(rs, pstmt, conn);
		}

	}

	@Override
	public Board getBoard(int bid) {
		String sql = " select * from board where bid=? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				Board board = new Board();
				board.setBid(rs.getInt("bid"));
				board.setBname(rs.getString("bname"));
				board.setBregdate(rs.getTimestamp("bregdate"));
				board.setBdelyn(rs.getString("bdelyn"));
				return board;
			} else {
				return null;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		} finally {
			connectionUtil.closeAll(rs, pstmt, conn);
		}
	}

	@Override
	public int registBoard(Board board) {
		String sql = " insert into board values(seq_board.nextval, ?, sysdate, 'N') ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBname());
			return pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 0;
		} finally {
			connectionUtil.closeAll(rs, pstmt, conn);
		}
	}

	@Override
	public int modifyBoard(Board board) {
		String sql = " update board set bname=? where bid=? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBname());
			pstmt.setInt(2, board.getBid());
			return pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 0;
		} finally {
			connectionUtil.closeAll(rs, pstmt, conn);
		}
	}

	@Override
	public int removeBoard(int bid) {
		String sql = " delete board where bid=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			return pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 0;
		} finally {
			connectionUtil.closeAll(rs, pstmt, conn);
		}
	}

} // class
