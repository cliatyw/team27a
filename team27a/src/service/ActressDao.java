/*[백지훈]*/
package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ActressDao {
	//아이디값을 받아 한개만 이름과 나이를 Actress 클래스에 세팅하여 actress를 리턴하는 매서드
	public Actress selectActressOne(int actressId) {
		Actress actress = new Actress();
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //드라이버로딩
			// DB연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT actress_id AS actressId, actress_name AS actressName, actress_age AS actressAge FROM actress WHERE actress_id = ?";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, actressId);
			resultSet = statement.executeQuery();
			/*executeQuery는 쿼리결과를 ResultSet을 얻기 위한 메소드로 주로 SELECT문에 
			사용되며 ,executeUpdate는 쿼리문으로 데이터를 다루는 INSERT, UPDATE,
			DELETE문이나 테이블을 다루는 CREATAE, DROP, ALTER에 사용*/
			
			// 하나의 행만 출력되기때문에 while문을 작성하지 않음.
			resultSet.next();
			actress.setActressId(actressId);
			actress.setActressName(resultSet.getString("actressName"));
			actress.setActressAge(resultSet.getInt("actressAge"));

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if(statement != null) try { statement.close(); } catch(SQLException ex) {}
			if(connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return actress;
	}
	
	public void updateActress(Actress actress) {
		/* 객체참조변수 선언, try절 안에서 변수선언을 하면 지역변수로 선언되기때문에 finally에서 close()를 못하므로 try절 밖에서 선언*/
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");// 드라이버로딩
			// DB연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "UPDATE actress SET actress_name = ?, actress_age = ? WHERE actress_id = ?"; // 특정행만 업데이트 하기위해 조건을 actress_id로 함.
			// DB접속받는부분에 커넥션을 받는다.
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			// 데이터 넣기
			statement.setString(1, actress.getActressName());
			statement.setInt(2, actress.getActressAge());
			statement.setInt(3, actress.getActressId());
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
	
	public void deleteActress(int actressId) {
		/* 객체참조변수 선언, try절 안에서 변수선언을 하면 지역변수로 선언되기때문에 finally에서 close()를 못하므로 try절 밖에서 선언*/
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버로딩
			// DB연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM actress WHERE actress_id=?";
			//DB접속받는부분에 커넥션을 받는다.
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, actressId); // 데이터넣기
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
	public void insertActress(Actress actress) {
		/* 객체참조변수 선언, try절 안에서 변수선언을 하면 지역변수로 선언되기때문에 finally에서 close()를 못하므로 try절 밖에서 선언*/
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버로딩
			// DB연결
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO actress(actress_name, actress_age) VALUES (?,?);";
			
			connection = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			statement=connection.prepareStatement(sql);
			statement.setString(1, actress.getActressName());
			statement.setInt(2, actress.getActressAge());
			/*executeQuery는 쿼리결과를 ResultSet을 얻기 위한 메소드로 주로 SELECT문에 
			사용되며 ,executeUpdate는 쿼리문으로 데이터를 다루는 INSERT, UPDATE,
			DELETE문이나 테이블을 다루는 CREATAE, DROP, ALTER에 사용*/
			statement.executeUpdate(); // 쿼리실행			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	} 
	/*
	 * select 한 후 리턴값으로 Comedian.class의 배열이나 List 받아야 한다.
	 * 배열이나, ArrayList, HashMap을 사용할 수 있다.
	 * ArrayList를 지금 사용해보고, HashMap도 테스트 해볼것.
	 */
	public ArrayList<Actress> selectActressList() {
		/* 객체참조변수 선언, try절 안에서 변수선언을 하면 지역변수로 선언되기때문에 finally에서 close()를 못하므로 try절 밖에서 선언*/
		ArrayList<Actress> list = new ArrayList<Actress>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버로딩
			// DB접속
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT actress_id AS actressId, actress_name AS actressName,actress_age AS actressAge FROM actress";
			//db 접속을 받는 부분. 커넥션을 받는다!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			//select 시에는 executeQuery를 실행하여, ResultSet을 리턴값으로 받음
			//update, delete, insert같은 경우는 executeUpdate
			resultSet = statement.executeQuery();
			
			//여기에서 객체를 생성하는 이유는 SQLException , ClassNotFoundException 같은 예외처리부분에서 에러가 날경우에는 객체생성 안하기위함.
			while(resultSet.next()){
				Actress actress = new Actress();
	
				actress.setActressId(resultSet.getInt("actressId"));  
				actress.setActressName(resultSet.getString("actressName"));
				actress.setActressAge(resultSet.getInt("actressAge"));  
				list.add(actress);
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
	
	
}
