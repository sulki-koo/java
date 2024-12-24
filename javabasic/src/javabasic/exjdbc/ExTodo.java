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

public class ExTodo {

	static Connection conn = ConnectionUtil.getConnection();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("    ☞메뉴(1.목록 2.등록 3.삭제 4.완료처리 5.종료)");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		switch (scan.nextLine()) {
		case "1":
			select();
			break; // 1. 목록 select
		case "2": {
		}
			;
		case "3": {
		}
			;
		case "4": {
		}
			;
		case "5":
			System.out.println("프로그램을 종료합니다");
			;
		}
		scan.close();
		ConnectionUtil.closeConnection(conn);

	} // main

	public static void select() throws Exception {
		// 1. 목록 select
		String selectSQL = " select TDNO, TDDATE, TDWRITER, TDCOUNTENT, TDYN from TODO ";
		PreparedStatement pstmt1;
		ResultSet rs = null;
		List<TODO> todoList = new ArrayList<TODO>();
		pstmt1 = conn.prepareStatement(selectSQL);

		rs = pstmt1.executeQuery();
		if (rs != null) {
			System.out.println("[Todo List]");
			while (rs.next()) {
				TODO todo = new TODO();
				todo.setTdno(rs.getInt("TDNO"));
				todo.setTddate(rs.getTimestamp("TDDATE"));
				todo.setTdwriter(rs.getString("TDWRITER"));
				todo.setTdcontent(rs.getString("TDCOUNTENT"));
				todo.setTdyn(rs.getString("TDYN"));
				todoList.add(todo);
			}
			for (TODO i : todoList) {
				System.out.println(i);
			}
		}
		rs.close();
	}
} // class
