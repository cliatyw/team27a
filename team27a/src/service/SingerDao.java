package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class SingerDao {
	
	
	public ArrayList<Singer> selectSingerList(){
		//��ü�������� ����.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<Singer> arraySinger = new ArrayList<Singer>();
		
		
		try {
			//����̹� �ε� �� db������ ���� ��Ʈ��ȣ, db�� ���̵� ��й�ȣ ip���� �����ش�.
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			//���� ���� ����.
			pstmt = conn.prepareStatement("select * from singer order by singer_id");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {//�� ���� �������������� ����
				//singer�� ���������� db���� �����´�.
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
