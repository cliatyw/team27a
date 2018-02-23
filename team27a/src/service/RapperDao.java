/*[백지훈]*/
package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
public class RapperDao {
	public Rapper selectRapperOne(int rapperId) {
		Rapper rapper = new Rapper();
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버로딩
			// DB연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT rapper_id AS rapperId, rapper_name AS rapperName, rapper_age AS rapperAge FROM rapper WHERE rapper_id=?";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, rapperId);
			resultSet = statement.executeQuery();
			
			resultSet.next();
			rapper.setRapperId(rapperId);
			rapper.setRapperName(resultSet.getString("rapperName"));
			rapper.setRapperAge(resultSet.getInt("rapperAge"));
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if(statement != null) try { statement.close(); } catch(SQLException ex) {}
			if(connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return rapper;
	}
	
	public void updateRapper(Rapper rapper) {
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버로딩
			// DB연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "UPDATE rapper SET rapper_name = ?, rapper_age = ? WHERE rapper_id = ?"; // 특정행만 업데이트 하기 위해 조건은 rapper_id로 함.
			// DB접속받는부분 커넥션!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			// 데이터 넣기
			statement.setString(1, rapper.getRapperName());
			statement.setInt(2, rapper.getRapperAge());
			statement.setInt(3, rapper.getRapperId());
			statement.executeUpdate(); // 쿼리실행
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement != null) try { statement.close(); } catch(SQLException ex) {}
			if(connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	}
	public void deleteRapper(int rapperId) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM rapper WHERE rapper_id=?";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, rapperId);
			statement.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement != null) try { statement.close(); } catch(SQLException ex) {}
			if(connection != null) try { connection.close(); } catch(SQLException ex) {} 
		}
}
	/*
	 * select 한 후 리턴값으로 Rapper.class의 배열이나 List 받아야 한다.
	 * 배열이나, ArrayList, HashMap을 사용할 수 있다.
	 * ArrayList를 지금 사용해보고, HashMap도 테스트 해볼것.
	 */
	
	public ArrayList<Rapper> selectRapperList() {
		//기본적인 객체참조변수 선언.
		ArrayList<Rapper> list = new ArrayList<Rapper>();
		
		// finally절에서 close....
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			//db접속을 위한 id,pw,주소 설정 코드인데, root관리자로 접속하라는 코드여서, 새로운 user를 추가하는것을 고려해야하지않을까?
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// 별명
			String sql = "SELECT rapper_id AS rapperId, rapper_name AS rapperName,rapper_age AS rapperAge FROM rapper";
			//db 접속을 받는 부분. 커넥션을 받는다!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			//select 시에는 executeQuery를 실행하여, ResultSet을 리턴값으로 받는다.
			//update, delete, insert같은 경우는 executeUpdate다~
			resultSet = statement.executeQuery();
			
			//여기에서 객체를 생성하는 이유는 SQLException , ClassNotFoundException 같은 예외처리부분에서 에러가 날경우에는 객체생성 안하기 위해~
			while(resultSet.next()){
				Rapper rapper = new Rapper();
	
				//내가 INT형 해놔서 Integer클래스의 parseInt메서드를
				rapper.setRapperId(resultSet.getInt("rapperId"));  
				rapper.setRapperName(resultSet.getString("rapperName"));
				rapper.setRapperAge(resultSet.getInt("rapperAge"));  
				list.add(rapper);
			}
			// 단위테스트
			System.out.println(list.size()+"7");
		} catch(ClassNotFoundException e) { // Class.forName()
			e.printStackTrace();
		} catch(SQLException e) { // JDBC
			e.printStackTrace();
		} finally {
			if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return list;
	}
	public void insertRapper(Rapper rapper) {			
			PreparedStatement statement = null;
			Connection connection = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				String sql = "INSERT INTO rapper VALUES (NULL, ?, ?)";		
			
				connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);			
				statement = connection.prepareStatement(sql);
				statement.setString(1, rapper.getRapperName());
				statement.setInt(2, rapper.getRapperAge());
				statement.executeUpdate();
		
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
		
			} finally {
				if (statement != null)try {statement.close();	} catch (SQLException ex) {}
				if (connection != null)try {connection.close();	} catch (SQLException ex) {}
			}
			
		}
}
