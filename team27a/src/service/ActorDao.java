/*[김도희]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ActorDao {
	/*Actor Id,Name,Age를 모두 검색하여 조회하는 메소드로서,
	actor의 Id,Name,Age의 값을 담은 list 배열을 리턴한다.*/
	public ArrayList<Actor> selectActorList() {
		
		ArrayList<Actor> list = new ArrayList<>();
		/*실행이 끝난후 데이터가 쌓이는것을 막기위해 finally를 이용해 close한다*/ 
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
								
		try {			
			/*드라이버로딩*/
			Class.forName("com.mysql.jdbc.Driver");
			/*DB연결*/
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT actor_id AS actorId,actor_name AS actorName,actor_age AS actorAge FROM actor ORDER BY actor_id ASC";
				
			connection = DriverManager.getConnection(dbDriver,dbUser,dbPass);
			statement = connection.prepareStatement(sql);
			/*쿼리실행*/
			resultset = statement.executeQuery();
			/*DB쿼리문 읽어오기*/
			while(resultset.next()) {
				/*actor참조변수에 actorId칼럼에서 가져온id값,actorName칼럼에서 가져온name값,
				 * actorAge칼럼에서 가져온age 값을 set메소드를 사용해 담는다*/
				Actor actor = new Actor();
				actor.setActorId(resultset.getInt("actorId"));
				actor.setActorName(resultset.getString("actorName"));
				actor.setActorAge(resultset.getInt("actorAge"));
				/*actor의 값을 list배열에  추가한다.*/
				list.add(actor);
			}		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultset != null) try { resultset.close(); } catch(SQLException ex) {}
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		} return list;
	}
	/*actor의 Name, Age를 INSERT쿼리문을 이용하여 추가하는 메소드*/
	public void insertActor(Actor actor) {
		/*실행이 끝난후 데이터가 쌓이는것을 막기위해 finally를 이용해 close한다*/ 
		Connection connection = null;
		PreparedStatement statement = null;
		/*드라이버로딩*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*DB연결*/
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO actor(actor_name, actor_age) VALUES (?, ?)";
			
			connection = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			statement=connection.prepareStatement(sql);
			statement.setString(1, actor.getActorName());
			statement.setInt(2, actor.getActorAge());
			/*쿼리실행*/
			statement.executeUpdate();			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	}
	/*매개변수가 int type인 actorId를 입력받아 해당 id의 쿼리문장을 DELETE을 이용하여 삭제하는 메소드*/
	public void deleteActor(int actorId) {
		/*실행이 끝난후 데이터가 쌓이는것을 막기위해 finally를 이용해 close한다*/ 
		Connection connection = null;
		PreparedStatement statement = null;
		/*드라이버로딩*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*DB연결*/
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM actor WHERE actor_id=?";
						
			connection = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			statement=connection.prepareStatement(sql);
			statement.setInt(1, actorId);
			/*쿼리실행*/
			statement.executeUpdate();
		} catch (ClassNotFoundException |  SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	}
	/*수정화면에서 Name과 Age의 값을 받아오기 위해서 SELECT쿼리문을 이용해 검색하는 메소드로서,
	actor의 Id,Name , Age를 리턴한다.*/
	public Actor selectActorOne(int actorId) {
		/*실행이 끝난후 데이터가 쌓이는것을 막기위해 finally를 이용해 close한다*/ 
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		Actor actor = new Actor();
		/*드라이버로딩*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*DB연결*/
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT actor_id AS actorId,actor_name AS actorName,actor_age AS actorAge FROM actor WHERE actor_id=?";
						
			connection = DriverManager.getConnection(dbDriver,dbUser,dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, actorId);
			/*쿼리실행*/
			resultset = statement.executeQuery();
			/*DB쿼리문 읽어오기*/
			while(resultset.next()) {
				/*actor참조변수에 actorId칼럼에서 가져온id값,actorName칼럼에서 가져온name값,
				 * actorAge칼럼에서 가져온age 값을 set메소드를 사용해 담는다*/
				actor.setActorId(Integer.parseInt(resultset.getString("actorId")));
				actor.setActorName(resultset.getString("actorName"));
				actor.setActorAge(Integer.parseInt(resultset.getString("actorAge")));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
			if (resultset != null) try { resultset.close(); } catch(SQLException ex) {}
		} return actor;
	}
	/*UPDATE쿼리문을 이용해서 수정처리를 하는 메소드*/
	public void updateActor(Actor actor) {
		/*실행이 끝난후 데이터가 쌓이는것을 막기위해 finally를 이용해 close한다*/ 
		Connection connection = null;
		PreparedStatement statement = null;
		/*드라이버로딩*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*DB연결*/
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "UPDATE actor SET actor_id=?,actor_name=?,actor_age=? WHERE actor_id=?";
						
			connection = DriverManager.getConnection(dbDriver,dbUser,dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, actor.getActorId());
			statement.setString(2, actor.getActorName());
			statement.setInt(3, actor.getActorAge());
			statement.setInt(4, actor.getActorId());
			/*쿼리실행*/
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	}
}
