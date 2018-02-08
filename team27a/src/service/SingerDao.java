package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class SingerDao {
	public void selectSingerList(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			pstmt = conn.prepareStatement("select * from singer");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString("singer_id"));
				System.out.print(rs.getString("singer_name"));
				System.out.println(rs.getString("singer_age"));
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
	}
	
}
