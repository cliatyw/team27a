package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public void insertMember(Member member) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO member (member_id, member_pw) VALUE (?, ?)";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setString(1, member.getMemberId());
			statement.setString(2, member.getMemberPw());
			statement.executeUpdate();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if( connection != null ) try { connection.close(); } catch(SQLException ex) {}
			if( statement != null ) try { statement.close(); } catch(SQLException ex) {}
		}
	}
	
	public void deleteMember(int memberNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM member WHERE member_no = ?";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, memberNo);
			statement.executeUpdate();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if( connection != null ) try { connection.close(); } catch(SQLException ex) {}
			if( statement != null ) try { statement.close(); } catch(SQLException ex) {}
		}
	}
	
	public ArrayList<Member> selectMemberAll(){
		ArrayList<Member> list = new ArrayList<Member>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT member_no AS memberNo, member_id AS memberId, member_pw AS memberPw FROM member";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Member member = new Member();
				member.setMemberNo(resultSet.getInt("memberNo"));
				member.setMemberId(resultSet.getString("memberId"));
				member.setMemberPw(resultSet.getString("memberPw"));
				list.add(member);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if( connection != null ) try { connection.close(); } catch(SQLException ex) {}
			if( statement != null ) try { statement.close(); } catch(SQLException ex) {}
		}
		return list;
	}
	
	
	public Member selectMemberOne(int memberNo) {
		Member member = new Member();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT member_no AS memberNo, member_id AS memberId, member_pw AS memberPw FROM member WHERE member_no = ?";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, memberNo);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				member.setMemberNo(resultSet.getInt("memberNo"));
				member.setMemberId(resultSet.getString("memberId"));
				member.setMemberPw(resultSet.getString("memberPw"));
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
		return member;
	}
	
	public void updateMember(Member member) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "UPDATE member SET member_id = ?, member_pw = ? WHERE member_no = ?";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setString(1, member.getMemberId());
			statement.setString(2, member.getMemberPw());
			statement.setInt(3, member.getMemberNo());
			statement.executeUpdate();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if( connection != null ) try { connection.close(); } catch(SQLException ex) {}
			if( statement != null ) try { statement.close(); } catch(SQLException ex) {}
		}
	}
	
	
}
