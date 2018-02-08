package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class ActorDao {
	public static void main(String[] args) {
		
		ActorDao a = new ActorDao();
		a.selectActorList();
	}
	
	public Actor selectActorList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Actor actor = new Actor();
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
	
		
		String Driver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		
		conn = DriverManager.getConnection(Driver, dbUser, dbPass);
		pstmt = conn.prepareStatement("select * from actor");
		rs = pstmt.executeQuery();
		
		
		
		while(rs.next()){
			
			String actorId=rs.getString("actor_id");
			String actorName=rs.getString("actor_name");
			String actorAge=rs.getString("actor_age");
			System.out.println(actorId+"<--actorId");
			System.out.println(actorName+"<--actorName");
			System.out.println(actorAge+"<--actorAge");
			
			actor.setActorId(actorId);
			actor.setActorName(actorName);
			actor.setActorAge(actorAge);
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
		 return actor;
	}
		

}
