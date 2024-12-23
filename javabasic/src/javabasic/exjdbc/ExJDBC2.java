package javabasic.exjdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

//실습 2. 이니셜 계정의 STUDENT 테이블
//          1) 한 행의 데이터를 입력하는 프로시져 PROC_INSERT_STUDENT 생성
//          2) STNO를 입력하면 이름을 반환하는 함수 FUNC_GET_STNAME 생성
//          3) 프로시져와 함수 호출하여 결과 출력
public class ExJDBC2 {
   
   public static void main(String[] args) {
      
			String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "ksk";
			String password = "ksk";
			
			Connection conn = null;
			CallableStatement cstmt = null;
			
			try {
				conn = DriverManager.getConnection(jdbcURL, username, password);
				cstmt = conn.prepareCall(" {call PROC_INSERT_STUDENT(?, ?, ?)} ");
				cstmt.registerOutParameter(1, Types.VARCHAR);
				cstmt.registerOutParameter(2, Types.VARCHAR);
				cstmt.registerOutParameter(3, Types.VARCHAR);
				cstmt.setString(1, "민");
				cstmt.setString(2, "min@mail.com");
				cstmt.setString(3, "010-777-7777");
				cstmt.execute();
				System.out.println("프로시져 : " + cstmt.getString(1)+" "+ cstmt.getString(2)+" "+ cstmt.getString(3));
				
				cstmt = conn.prepareCall(" {? = call FUNC_GET_STNAME(?)} ");
				cstmt.registerOutParameter(1, Types.VARCHAR);
				cstmt.setInt(2, 22);
				cstmt.execute();
				System.out.println("함수 : "+ cstmt.getString(1));
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
      
   } // main

} // class