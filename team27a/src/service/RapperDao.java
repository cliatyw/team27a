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
			/*executeQuery는 쿼리결과를 ResultSet을 얻기 위한 메소드로 주로 SELECT문에 
			사용되며 ,executeUpdate는 쿼리문으로 데이터를 다루는 INSERT, UPDATE,
			DELETE문이나 테이블을 다루는 CREATAE, DROP, ALTER에 사용*/
			
			resultSet.next(); // 하나의 행만 출력되기때문에 while문을 작성하지 않음.
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
		/* 객체참조변수 선언, try절 안에서 변수선언을 하면 지역변수로 선언되기때문에 finally에서 close()를 못하므로 try절 밖에서 선언*/
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
		/* 객체참조변수 선언, try절 안에서 변수선언을 하면 지역변수로 선언되기때문에 finally에서 close()를 못하므로 try절 밖에서 선언*/
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로딩
			// DB연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM rapper WHERE rapper_id=?";
			// DB접속받는부분 커넥션
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, rapperId);
			statement.executeUpdate(); // 쿼리실행 
			//update, delete, insert같은 경우는 executeUpdate다
			
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
		/* 객체참조변수 선언, try절 안에서 변수선언을 하면 지역변수로 선언되기때문에 finally에서 close()를 못하므로 try절 밖에서 선언*/
		ArrayList<Rapper> list = new ArrayList<Rapper>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로딩
			// DB연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			String sql = "SELECT rapper_id AS rapperId, rapper_name AS rapperName,rapper_age AS rapperAge FROM rapper";
			//db 접속을 받는 부분. 커넥션을 받는다!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			//select 시에는 executeQuery를 실행하여, ResultSet을 리턴값으로 받음
			//update, delete, insert같은 경우는 executeUpdate
			resultSet = statement.executeQuery();
			
			//여기에서 객체를 생성하는 이유는 SQLException , ClassNotFoundException 같은 예외처리부분에서 에러가 날경우에는 객체생성 안하기위함.
			while(resultSet.next()){
				Rapper rapper = new Rapper();
	
				rapper.setRapperId(resultSet.getInt("rapperId"));  
				rapper.setRapperName(resultSet.getString("rapperName"));
				rapper.setRapperAge(resultSet.getInt("rapperAge"));  
				list.add(rapper);
			}
			// 단위테스트
			System.out.println(list.size()+"7");
		} catch(ClassNotFoundException e) { 
			e.printStackTrace();
		} catch(SQLException e) { 
			e.printStackTrace();
		} finally {
			if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return list;
	}
	public void insertRapper(Rapper rapper) {
		/* 객체참조변수 선언, try절 안에서 변수선언을 하면 지역변수로 선언되기때문에 finally에서 close()를 못하므로 try절 밖에서 선언*/
			PreparedStatement statement = null;
			Connection connection = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); //드라이버로딩
				// DB연결
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				String sql = "INSERT INTO rapper VALUES (NULL, ?, ?)";		
				// DB접속받는부분 커넥션받음
				connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);			
				statement = connection.prepareStatement(sql);
				statement.setString(1, rapper.getRapperName());
				statement.setInt(2, rapper.getRapperAge());
				statement.executeUpdate(); 
				//select 시에는 executeQuery를 실행하여, ResultSet을 리턴값으로 받음
				//update, delete, insert같은 경우는 executeUpdate
		
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
