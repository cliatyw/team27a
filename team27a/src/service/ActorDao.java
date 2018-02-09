package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ActorDao {

	public ArrayList<Actor> selectActorList(){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Actor> arrayActor = null;
		Actor actor = null;
				
		try {
			
			//드라이버로딩
			Class.forName("com.mysql.jdbc.Driver");
		
	
			//DB연결
			String Driver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
		
		
			conn = DriverManager.getConnection(Driver, dbUser, dbPass);
			pstmt = conn.prepareStatement("select * from actor order by actor_id");
			//쿼리실행
			rs = pstmt.executeQuery();
			
		
			arrayActor = new ArrayList<Actor>();
			
			//DB쿼리문 읽어오기
			while(rs.next()){
				//DB 칼럼값 가져오기
				String actorId=rs.getString("actor_id");
				String actorName=rs.getString("actor_name");
				String actorAge=rs.getString("actor_age");
			
				//actor참조변수에 id,name,age 값을 set메소드를 사용해 담는다
				actor = new Actor();
				actor.setActorId(actorId);
				actor.setActorName(actorName);
				actor.setActorAge(actorAge);
				//actor의 값을 arrayActor배열에  추가한다.
				arrayActor.add(actor);
			}
		
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}  finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
			
		 return arrayActor;
	}
		

}
