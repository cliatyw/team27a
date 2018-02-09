package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class SingerDao {
	
	
	public ArrayList<Singer> selectSingerList(){
		//객체참조변수 선언.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<Singer> arraySinger = new ArrayList<Singer>();
		
		
		try {
			//드라이버 로딩 후 db접속을 위해 포트번호, db명 아이디 비밀번호 ip값을 적어준다.
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			//쿼리 문장 실행.
			pstmt = conn.prepareStatement("select * from singer order by singer_id");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {//그 다음 값이있을때까지 실행
				//singer의 참조변수에 db값을 가져온다.
				Singer singer = new Singer();
				singer.setSingerId(rs.getInt("singer_id"));
				singer.setSingerName(rs.getString("singer_name"));
				singer.setSingerAge(rs.getInt("singer_age"));
				arraySinger.add(singer);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)	try {rs.close();} catch (SQLException ex) {}
			if (pstmt != null)try {pstmt.close();	} catch (SQLException ex) {}
			if (conn != null)try {conn.close();	} catch (SQLException ex) {}
		}
		return arraySinger;
	}
	
}
