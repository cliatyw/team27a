/*[������]*/
package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
public class RapperDao {
	
	public Rapper selectRapperOne(int rapperId) {
		Rapper rapper = new Rapper();
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ����̹��ε�
			// DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT rapper_id AS rapperId, rapper_name AS rapperName, rapper_age AS rapperAge FROM rapper WHERE rapper_id=?";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, rapperId);
			resultSet = statement.executeQuery();
			/*executeQuery�� ��������� ResultSet�� ��� ���� �޼ҵ�� �ַ� SELECT���� 
			���Ǹ� ,executeUpdate�� ���������� �����͸� �ٷ�� INSERT, UPDATE,
			DELETE���̳� ���̺��� �ٷ�� CREATAE, DROP, ALTER�� ���*/
			
			resultSet.next(); // �ϳ��� �ุ ��µǱ⶧���� while���� �ۼ����� ����.
			rapper.setRapperId(rapperId);
			rapper.setRapperName(resultSet.getString("rapperName"));
			rapper.setRapperAge(resultSet.getInt("rapperAge"));
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if(statement != null) try { statement.close(); } catch(SQLException ex) {}
			if(connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return rapper;
	}
	
	public void updateRapper(Rapper rapper) {
		/* ��ü�������� ����, try�� �ȿ��� ���������� �ϸ� ���������� ����Ǳ⶧���� finally���� close()�� ���ϹǷ� try�� �ۿ��� ����*/
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ����̹��ε�
			// DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "UPDATE rapper SET rapper_name = ?, rapper_age = ? WHERE rapper_id = ?"; // Ư���ุ ������Ʈ �ϱ� ���� ������ rapper_id�� ��.
			// DB���ӹ޴ºκ� Ŀ�ؼ�!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			// ������ �ֱ�
			statement.setString(1, rapper.getRapperName());
			statement.setInt(2, rapper.getRapperAge());
			statement.setInt(3, rapper.getRapperId());
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
	public void deleteRapper(int rapperId) {
		/* ��ü�������� ����, try�� �ȿ��� ���������� �ϸ� ���������� ����Ǳ⶧���� finally���� close()�� ���ϹǷ� try�� �ۿ��� ����*/
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ����̹� �ε�
			// DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM rapper WHERE rapper_id=?";
			// DB���ӹ޴ºκ� Ŀ�ؼ�
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, rapperId);
			statement.executeUpdate(); // �������� 
			//update, delete, insert���� ���� executeUpdate��
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement != null) try { statement.close(); } catch(SQLException ex) {}
			if(connection != null) try { connection.close(); } catch(SQLException ex) {} 
		}
}
	/*
	 * select �� �� ���ϰ����� Rapper.class�� �迭�̳� List �޾ƾ� �Ѵ�.
	 * �迭�̳�, ArrayList, HashMap�� ����� �� �ִ�.
	 * ArrayList�� ���� ����غ���, HashMap�� �׽�Ʈ �غ���.
	 */
	
	public ArrayList<Rapper> selectRapperList() {
		/* ��ü�������� ����, try�� �ȿ��� ���������� �ϸ� ���������� ����Ǳ⶧���� finally���� close()�� ���ϹǷ� try�� �ۿ��� ����*/
		ArrayList<Rapper> list = new ArrayList<Rapper>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ����̹� �ε�
			// DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			String sql = "SELECT rapper_id AS rapperId, rapper_name AS rapperName,rapper_age AS rapperAge FROM rapper";
			//db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			//select �ÿ��� executeQuery�� �����Ͽ�, ResultSet�� ���ϰ����� ����
			//update, delete, insert���� ���� executeUpdate
			resultSet = statement.executeQuery();
			
			//���⿡�� ��ü�� �����ϴ� ������ SQLException , ClassNotFoundException ���� ����ó���κп��� ������ ����쿡�� ��ü���� ���ϱ�����.
			while(resultSet.next()){
				Rapper rapper = new Rapper();
	
				rapper.setRapperId(resultSet.getInt("rapperId"));  
				rapper.setRapperName(resultSet.getString("rapperName"));
				rapper.setRapperAge(resultSet.getInt("rapperAge"));  
				list.add(rapper);
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
	public void insertRapper(Rapper rapper) {
		/* ��ü�������� ����, try�� �ȿ��� ���������� �ϸ� ���������� ����Ǳ⶧���� finally���� close()�� ���ϹǷ� try�� �ۿ��� ����*/
			PreparedStatement statement = null;
			Connection connection = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); //����̹��ε�
				// DB����
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				String sql = "INSERT INTO rapper VALUES (NULL, ?, ?)";		
				// DB���ӹ޴ºκ� Ŀ�ؼǹ���
				connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);			
				statement = connection.prepareStatement(sql);
				statement.setString(1, rapper.getRapperName());
				statement.setInt(2, rapper.getRapperAge());
				statement.executeUpdate(); 
				//select �ÿ��� executeQuery�� �����Ͽ�, ResultSet�� ���ϰ����� ����
				//update, delete, insert���� ���� executeUpdate
		
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
		
			} finally {
				if (statement != null)try {statement.close();	} catch (SQLException ex) {}
				if (connection != null)try {connection.close();	} catch (SQLException ex) {}
			}
			
		}
}
