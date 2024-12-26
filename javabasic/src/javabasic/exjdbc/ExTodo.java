package javabasic.exjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExTodo {

	static Connection conn = ConnectionUtil.getConnection();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			menu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
			ConnectionUtil.closeConnection(conn);
		}
	} // main

	public static void menu() throws Exception {

		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("    ☞메뉴(1.목록 2.등록 3.삭제 4.완료처리 5.종료)");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		String choice = scan.nextLine();

		switch (choice) {
		case "1": select();			break; // 1. 목록 select
		case "2": {
			System.out.println("작성자 이름과 내용을 입력해 주세요!(형식:홍길동,바벨2000회)");

			String input = scan.nextLine();
			String inputName = input.substring(0, input.indexOf(","));
			String inputConcent = input.substring(input.indexOf(",") + 1);

			TODO todo = new TODO(0, null, inputName, inputConcent, null);

			insert(todo);
		}
		case "3": {
			System.out.println("삭제하실 TODO 번호를 입력해주세요!");
			String tdno = scan.nextLine();
			delete(tdno);
		}
		case "4": {
			System.out.println("완료처리하실 TODO 번호를 입력해 주세요!");
			String tdno = scan.nextLine();
			complete(tdno);
		}
		case "5":
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}

	}

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
		menu();
	}

	public static void insert(TODO todo) throws Exception {
		String insertSQL = " insert into TODO values(TODO_SEQ.nextval, sysdate, ?, ?, 'N') ";
		PreparedStatement pstmt = conn.prepareStatement(insertSQL);

		pstmt.setString(1, todo.getTdwriter());
		pstmt.setString(2, todo.getTdcontent());

		pstmt.executeUpdate();

		select();
	}

	public static void delete(String tdno) throws Exception {
		String deleteSQL = " delete TODO where tdno=? ";
		PreparedStatement pstmt = conn.prepareStatement(deleteSQL);

		pstmt.setString(1, tdno);
		pstmt.executeUpdate();

		select();
	}

	public static void complete(String tdno) throws Exception {
		String updateSQL = " update TODO set tdyn='Y' where tdno=? ";
		PreparedStatement pstmt = conn.prepareStatement(updateSQL);

		pstmt.setString(1, tdno);
		pstmt.executeUpdate();

		select();
	}

} // class