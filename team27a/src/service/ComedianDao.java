package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ComedianDao {
	
	public ComedianDao() {
		
	}

	public ArrayList<Comedian> selectActorList() {
		ArrayList<Comedian> cd = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
	
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			pstmt = conn.prepareStatement("select * from comedian");
			rs = pstmt.executeQuery();
			
			cd = new ArrayList<Comedian>();
			while(rs.next()){
				Comedian c = new Comedian();
				String comedianId = rs.getString("comedianId");
				String comedianName = rs.getString("comedianName");
				String comedianAge = rs.getString("comedianAge");
	
				c.setComedianId(Integer.parseInt(comedianId));
				c.setComedianName(comedianName);
				c.setComedianAge(Integer.parseInt(comedianAge));
				cd.add(c);

			}

			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return cd;
	}
}
