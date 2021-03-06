/*[최상욱]*/
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
		ArrayList<Singer> list = new ArrayList<Singer>();
		// finally절에서 colse....
		PreparedStatement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			//드라이버 로딩 후 db접속을 위해 포트번호, db명 아이디 비밀번호 ip값을 적어준다.
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT singer_id AS singerId, singer_name AS singerName,singer_age AS singerAge FROM singer ORDER BY singer_id ASC";
			//db 접속을 받는 부분. 커넥션을 받는다!
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);			
			//쿼리 문장 실행.
			statement = connection.prepareStatement(sql);
			////select 시에는 executeQuery를 실행하여, ResultSet을 리턴값으로 받는다.
			rs = statement.executeQuery();
			while (rs.next()) {//그 다음 값이있을때까지 실행
				//singer의 참조변수에 db값을 가져온다.
				Singer singer = new Singer();
				singer.setSingerId(rs.getInt("singerId"));
				singer.setSingerName(rs.getString("singerName"));
				singer.setSingerAge(rs.getInt("singerAge"));
				list.add(singer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)	try {rs.close();} catch (SQLException ex) {}
			if (statement != null)try {statement.close();	} catch (SQLException ex) {}
			if (connection != null)try {connection.close();	} catch (SQLException ex) {}
		}
		return list;
	}
	//singer 등록
	public void insertSinger(Singer singer) {
		
		// finally절에서 close
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			
			//드라이버 로딩 후 db접속을 위해 포트번호, db명 아이디 비밀번호 ip값을 적어준다.
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO singer VALUES (NULL, ?, ?)";		
	
			//db 접속을 받는 부분. 커넥션을 받는다!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);			

			//쿼리 문장 실행. singer 클래스의 getsingerid,name,age받아온다.
			statement = connection.prepareStatement(sql);
			statement.setString(1, singer.getSingerName());
			statement.setInt(2, singer.getSingerAge());
			
			////select 시에는 executeQuery를 실행하지만 update, delete, insert같은 경우는 executeUpdate다~
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//닫기
			if (statement != null)try {statement.close();	} catch (SQLException ex) {}
			if (connection != null)try {connection.close();	} catch (SQLException ex) {}
		}
		
	}
	//singer 삭제
	public void deleteSinger(int singerId) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = " DELETE FROM singer WHERE singer_id =?";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);	
			statement = connection.prepareStatement(sql);
			statement.setInt(1, singerId);
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//닫기
			if (statement != null)try {statement.close();	} catch (SQLException ex) {}
			if (connection != null)try {connection.close();	} catch (SQLException ex) {}
		}
	}
	//singer 업데이트 폼
	public Singer selectSingerOne(int singerId) {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet rs = null;
		Singer singer = new Singer();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT singer_id AS singerId, singer_name AS singerName,singer_age AS singerAge FROM singer WHERE singer_id=?";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);	
			statement = connection.prepareStatement(sql);
			statement.setInt(1, singerId);
			System.out.println(singerId);
			rs = statement.executeQuery();	
			//id값을 받아와서 id,name,age를 조회후 값을 세팅.
			while (rs.next()) {
				singer.setSingerId(rs.getInt("singerId"));
				singer.setSingerName(rs.getString("singerName"));
				singer.setSingerAge(rs.getInt("singerAge"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null)try {statement.close();	} catch (SQLException ex) {}
			if (connection != null)try {connection.close();	} catch (SQLException ex) {}
		}
		return singer; 
	}
	
	//singer 업데이트 action
	public void updateSinger(Singer singer) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" + "useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "UPDATE singer SET singer_name=?, singer_age=? WHERE singer_id=? ";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);	
			statement = connection.prepareStatement(sql);
			//singer액션에서 세팅한 값들을 아이디, 이름, 나이값에 게팅해주고 그 값들을 다시 쿼리문에  세팅.
			statement.setString(1, singer.getSingerName());
			statement.setInt(2, singer.getSingerAge());
			statement.setInt(3, singer.getSingerId());
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null)try {statement.close();	} catch (SQLException ex) {}
			if (connection != null)try {connection.close();	} catch (SQLException ex) {}
		}
	}
}
