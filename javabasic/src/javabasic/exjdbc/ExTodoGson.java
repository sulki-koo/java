package javabasic.exjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExTodoGson {

	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		Scanner scan = new Scanner(System.in);
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("    ☞메뉴(1.목록 2.등록 3.삭제 4.완료처리 5.종료)");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// 1. 목록 select
		String selectSQL = " select TDNO, TDDATE, TDWRITER, TDCOUNTENT, TDYN from TODO ";
		PreparedStatement pstmt1;
		ResultSet rs = null;
		try {
			List<TODO> todoList = new ArrayList<TODO>();
			pstmt1 = conn.prepareStatement(selectSQL);
			
			rs = pstmt1.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					TODO todo = new TODO();
					todo.setTdno(rs.getInt("TDNO"));
					todo.setTddate(rs.getTimestamp("TDDATE"));
					todo.setTdwriter(rs.getString("TDWRITER"));
					todo.setTdcontent(rs.getString("TDCOUNTENT"));
					todo.setTdyn(rs.getString("TDYN"));
					todoList.add(todo);
				}
			}
			System.out.println(gson.toJson(todoList));
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		scan.close();
		ConnectionUtil.closeConnection(conn);
		
	}  // main
	
}  // class
