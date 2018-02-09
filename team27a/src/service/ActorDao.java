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
		PreparedStatement Statement = null;
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
			Statement = connection.prepareStatement(sql);
			//쿼리실행
			resultset = Statement.executeQuery();
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
			if (Statement != null) try { Statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
 		 return list;
	}
}
