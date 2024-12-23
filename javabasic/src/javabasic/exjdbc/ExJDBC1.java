package javabasic.exjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 실습 1) 이니셜 계정의 STUDENT 테이블
//          PreparedStatement 사용 CRUD (INSERT > UPDATE > DELETE > SELECT 순)
public class ExJDBC1 {

	public static void main(String[] args) {

		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "ksk";
		String password = "ksk";
		
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(jdbcURL, username, password);
			
			// insert
//			String insertSQL = " insert into student values(std_seq.nextval, ?, ?, ?) ";
//
//			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
//			pstmt.setString(1, "민");
//			pstmt.setString(2, "min@mail.com");
//			pstmt.setString(3, "010-5555-5555");
//			
//			int result = pstmt.executeUpdate();
//			if(result > 0) {
//				System.out.println("입력 완료");
//			}
			
			// update
//			String updateSQL = " update student set std_tel='010-777-7777' where std_number=? ";
//			PreparedStatement pstmt = conn.prepareStatement(updateSQL);
//			pstmt.setInt(1, 21);
//			int result = pstmt.executeUpdate();
//			if(result > 0) {
//				System.out.println("수정 완료");
//			}
			
			// delete
//			String deleteSQL = " delete student where std_number=? ";
//			PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
//			pstmt.setInt(1, 21);
//			int result = pstmt.executeUpdate();
//			if(result > 0) {
//				System.out.println("삭제 완료");
//			}
			
			// select
			String selectSQL = " select std_number,std_name,std_mail,std_tel from student ";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				while (rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "
							+rs.getString(3)+" "+rs.getString(4));
				}
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		

	} // main

} // class
