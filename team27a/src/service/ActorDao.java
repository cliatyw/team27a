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
		Class.forName("com.mysql.jdbc.Driver");
	
		
		String Driver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		
		conn = DriverManager.getConnection(Driver, dbUser, dbPass);
		pstmt = conn.prepareStatement("select * from actor order by actor_id");
		rs = pstmt.executeQuery();
		
		
		arrayActor = new ArrayList<Actor>();
		
		while(rs.next()){
			
			String actorId=rs.getString("actor_id");
			String actorName=rs.getString("actor_name");
			String actorAge=rs.getString("actor_age");
			/*System.out.println(actorId+"<--actorId");
			System.out.println(actorName+"<--actorName");
			System.out.println(actorAge+"<--actorAge");*/
			
			actor = new Actor();
			actor.setActorId(actorId);
			actor.setActorName(actorName);
			actor.setActorAge(actorAge);
			arrayActor.add(actor);
		}
		
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		 return arrayActor;
	}
		

}
