/*[������]*/
package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ActressDao {
	//���̵��� �޾� �Ѱ��� �̸��� ���̸� Actress Ŭ������ �����Ͽ� actress�� �����ϴ� �ż���
	public Actress selectActressOne(int actressId) {
		Actress actress = new Actress();
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //����̹��ε�
			// DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT actress_id AS actressId, actress_name AS actressName, actress_age AS actressAge FROM actress WHERE actress_id = ?";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, actressId);
			resultSet = statement.executeQuery();
			/*executeQuery�� ��������� ResultSet�� ��� ���� �޼ҵ�� �ַ� SELECT���� 
			���Ǹ� ,executeUpdate�� ���������� �����͸� �ٷ�� INSERT, UPDATE,
			DELETE���̳� ���̺��� �ٷ�� CREATAE, DROP, ALTER�� ���*/
			
			// �ϳ��� �ุ ��µǱ⶧���� while���� �ۼ����� ����.
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
		/* ��ü�������� ����, try�� �ȿ��� ���������� �ϸ� ���������� ����Ǳ⶧���� finally���� close()�� ���ϹǷ� try�� �ۿ��� ����*/
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");// ����̹��ε�
			// DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "UPDATE actress SET actress_name = ?, actress_age = ? WHERE actress_id = ?"; // Ư���ุ ������Ʈ �ϱ����� ������ actress_id�� ��.
			// DB���ӹ޴ºκп� Ŀ�ؼ��� �޴´�.
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			// ������ �ֱ�
			statement.setString(1, actress.getActressName());
			statement.setInt(2, actress.getActressAge());
			statement.setInt(3, actress.getActressId());
			statement.executeUpdate(); // ��������
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
		/* ��ü�������� ����, try�� �ȿ��� ���������� �ϸ� ���������� ����Ǳ⶧���� finally���� close()�� ���ϹǷ� try�� �ۿ��� ����*/
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ����̹��ε�
			// DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM actress WHERE actress_id=?";
			//DB���ӹ޴ºκп� Ŀ�ؼ��� �޴´�.
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, actressId); // �����ͳֱ�
			statement.executeUpdate(); // ��������
			
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
		/* ��ü�������� ����, try�� �ȿ��� ���������� �ϸ� ���������� ����Ǳ⶧���� finally���� close()�� ���ϹǷ� try�� �ۿ��� ����*/
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ����̹��ε�
			// DB����
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO actress(actress_name, actress_age) VALUES (?,?);";
			
			connection = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			statement=connection.prepareStatement(sql);
			statement.setString(1, actress.getActressName());
			statement.setInt(2, actress.getActressAge());
			/*executeQuery�� ��������� ResultSet�� ��� ���� �޼ҵ�� �ַ� SELECT���� 
			���Ǹ� ,executeUpdate�� ���������� �����͸� �ٷ�� INSERT, UPDATE,
			DELETE���̳� ���̺��� �ٷ�� CREATAE, DROP, ALTER�� ���*/
			statement.executeUpdate(); // ��������			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	} 
	/*
	 * select �� �� ���ϰ����� Comedian.class�� �迭�̳� List �޾ƾ� �Ѵ�.
	 * �迭�̳�, ArrayList, HashMap�� ����� �� �ִ�.
	 * ArrayList�� ���� ����غ���, HashMap�� �׽�Ʈ �غ���.
	 */
	public ArrayList<Actress> selectActressList() {
		/* ��ü�������� ����, try�� �ȿ��� ���������� �ϸ� ���������� ����Ǳ⶧���� finally���� close()�� ���ϹǷ� try�� �ۿ��� ����*/
		ArrayList<Actress> list = new ArrayList<Actress>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ����̹��ε�
			// DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT actress_id AS actressId, actress_name AS actressName,actress_age AS actressAge FROM actress";
			//db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			//select �ÿ��� executeQuery�� �����Ͽ�, ResultSet�� ���ϰ����� ����
			//update, delete, insert���� ���� executeUpdate
			resultSet = statement.executeQuery();
			
			//���⿡�� ��ü�� �����ϴ� ������ SQLException , ClassNotFoundException ���� ����ó���κп��� ������ ����쿡�� ��ü���� ���ϱ�����.
			while(resultSet.next()){
				Actress actress = new Actress();
	
				actress.setActressId(resultSet.getInt("actressId"));  
				actress.setActressName(resultSet.getString("actressName"));
				actress.setActressAge(resultSet.getInt("actressAge"));  
				list.add(actress);
			}
			// �����׽�Ʈ
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
