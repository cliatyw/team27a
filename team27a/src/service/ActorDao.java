/*[김도희]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ActorDao {

	public ArrayList<Actor> selectActorList() {
		
		ArrayList<Actor> list = new ArrayList<>();
		//close를 하기위해서 null로 초기화를 시켜야됨
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
								
		try {			
			//드라이버로딩
			Class.forName("com.mysql.jdbc.Driver");
			//DB연결
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT actor_id as actorId,actor_name as actorName,actor_age as actorAge FROM actor ORDER BY actor_id";
				
			connection = DriverManager.getConnection(dbDriver,dbUser,dbPass);
			statement = connection.prepareStatement(sql);
			//쿼리실행
			resultset = statement.executeQuery();
			//DB쿼리문 읽어오기
			while(resultset.next()){
				//DB 칼럼값 가져오기
				int actorId=resultset.getInt("actorId");
				String actorName=resultset.getString("actorName");
				int actorAge=resultset.getInt("actorAge");
				//actor참조변수에 id,name,age 값을 set메소드를 사용해 담는다
				Actor actor = new Actor();
				actor.setActorId(actorId);
				actor.setActorName(actorName);
				actor.setActorAge(actorAge);
				//actor의 값을 list배열에  추가한다.
				list.add(actor);
			}		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultset != null) try { resultset.close(); } catch(SQLException ex) {}
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
 		 return list;
	}
    /*Dao(Data Access Object) DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 기능이므로
	insertActorAction.jsp이 아닌 ActorDao에 insert부분의 기능을 추가해야함*/
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
			/*executeQuery는 쿼리결과를 ResultSet을 얻기 위한 메소드로 주로 SELECT문에 
			사용되며 ,executeUpdate는 쿼리문으로 데이터를 다루는 INSERT, UPDATE,
			DELETE문이나 테이블을 다루는 CREATAE, DROP, ALTER에 사용*/
			statement.executeUpdate();			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	} 
}
