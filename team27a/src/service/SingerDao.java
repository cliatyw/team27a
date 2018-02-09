/*[�ֻ��]*/
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
		ArrayList<Singer> list = new ArrayList<Singer>();
		
		// finally������ colose....
		PreparedStatement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			
			//����̹� �ε� �� db������ ���� ��Ʈ��ȣ, db�� ���̵� ��й�ȣ ip���� �����ش�.
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT singer_id AS singerId, singer_name AS singerName,singer_age AS singerAge FROM singer ORDER BY singer_id ASC";
			//db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);			
			//���� ���� ����.
			statement = connection.prepareStatement(sql);
			////select �ÿ��� executeQuery�� �����Ͽ�, ResultSet�� ���ϰ����� �޴´�.
			rs = statement.executeQuery();
			while (rs.next()) {//�� ���� �������������� ����
				//singer�� ���������� db���� �����´�.
				Singer singer = new Singer();
				singer.setSingerId(rs.getInt("singerId"));
				singer.setSingerName(rs.getString("singerName"));
				singer.setSingerAge(rs.getInt("singerAge"));
				list.add(singer);
			}
			// �����׽�Ʈ
			System.out.println(list.size()+"<---listsize");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)	try {rs.close();} catch (SQLException ex) {}
			if (statement != null)try {statement.close();	} catch (SQLException ex) {}
			if (connection != null)try {connection.close();	} catch (SQLException ex) {}
		}
		return list;
	}
	
	public void insertSinger(Singer singer) {
		
		// finally������ close
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			
			//����̹� �ε� �� db������ ���� ��Ʈ��ȣ, db�� ���̵� ��й�ȣ ip���� �����ش�.
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";

			//���� ���� ����.INSERT INTO singer VALUES (?, ?, ?)
			String sql = "INSERT INTO singer VALUES (NULL, ?, ?)";		
	
			//db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);			

			//���� ���� ����. singer Ŭ������ getsingerid,name,age�޾ƿ´�.
			statement = connection.prepareStatement(sql);
			statement.setString(1, singer.getSingerName());
			statement.setInt(2, singer.getSingerAge());
			
			////select �ÿ��� executeQuery�� ���������� update, delete, insert���� ���� executeUpdate��~
			statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//�ݱ�
			if (statement != null)try {statement.close();	} catch (SQLException ex) {}
			if (connection != null)try {connection.close();	} catch (SQLException ex) {}
		}
		
	}
}
