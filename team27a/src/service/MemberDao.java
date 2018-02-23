package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.Member;

public class MemberDao {
	
	public String loginMember(Member member) {
		String login = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT member_id AS memberId, member_pw AS memberPw FROM member where member_id = ? and member_pw = ?";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setString(1, member.getMemberId());
			statement.setString(2, member.getMemberPw());
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				login = "ÀÏÄ¡";
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if( resultSet != null ) try { resultSet.close(); } catch(SQLException ex) {}
			if( connection != null ) try { connection.close(); } catch(SQLException ex) {}
			if( statement != null ) try { statement.close(); } catch(SQLException ex) {}
		}
		return login;
	}
}
