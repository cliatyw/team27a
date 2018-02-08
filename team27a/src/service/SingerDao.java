package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class SingerDao {
	public ArrayList<Singer> selectSingerList(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<Singer> arraySinger = new ArrayList<Singer>();
		Singer singer = new Singer();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			pstmt = conn.prepareStatement("select * from singer");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String singerId = rs.getString("singer_id");
				String singerName = rs.getString("singer_name");
				String singerAge = rs.getString("singer_age");

				singer.setSingerAge(singerAge);
				singer.setSingerId(singerId);
				singer.setSingerName(singerName);
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
