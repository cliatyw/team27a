/*[�����]*/
package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ComedianDao {
	/*default������ �̱� �ѵ�, public�����ָ� not visible
	 * ���°� �Ǳ� ������ ȣ�� �� �� ����. 
	 * ���� public�� �ٿ��� �������ش�.
	 * */
	public ComedianDao() {}

	/*������Ʈ�� �ϱ� ���� select �ؼ� ȸ������ �ҷ����� �ϴ� �޼���*/
	public Comedian selectForUpdateComedian(int comedianId) {
		Comedian comedian = new Comedian();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			/*������ �ϳ��� �ุ ��µǱ� ������, order by ���� ������� �ʾҴ�.*/
			String sql = "SELECT comedian_id AS comedianId, comedian_name AS comedianName, comedian AS comedianAge FROM comedian where comedianId = ?";
			
			connection = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1,comedianId);
			resultSet = statement.executeQuery(sql);
			
			/*������ �ϳ��� �ุ ��µǾ while���� ������� �ʾҴ�.*/
			resultSet.next();
			comedian.setComedianId(comedianId);
			comedian.setComedianName(resultSet.getString("comedianName"));
			comedian.setComedianAge(resultSet.getInt("comedianAge"));
			
			/*������� ����� ����Ǿ�����, �����Ͱ� ����� ������ Ȯ��!*/
			System.out.println(comedian.toString());
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return comedian;
	}
	
	public void updateComedian(Comedian comedian) {
		/*�⺻���� ��ü�������� ����, ���� try�� �ȿ��� ���� ������ �ϰԵǸ����������� 
		 * �����̵Ǿ finally������ colose�� ���� ���ϱ⶧����try�� �ۿ��� ������ ���ش�.
		 * */
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			/*db������ ���� id,pw,�ּ� ���� �ڵ��̸�, String�� ������ �������·� ���!*/
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			/*Ư���ุ ������Ʈ�� �ϱ����� comedian_id�� �������� �־���.*/
			String sql = "UPDATE comedian SET comedian_name = ?, comedian_age = ? where comedian_id = ?";
			/*db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!*/
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			/*������ �ֱ�!*/
			statement.setString(1, comedian.getComedianName());
			statement.setInt(2, comedian.getComedianAge());
			statement.setInt(3, comedian.getComedianId());
			/*���� ����*/
			statement.executeUpdate();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	}
	
	public void deleteComedian(int comedianId) {
		/*�⺻���� ��ü�������� ����, ���� try�� �ȿ��� ���� ������ �ϰԵǸ����������� 
		 * �����̵Ǿ finally������ colose�� ���� ���ϱ⶧����try�� �ۿ��� ������ ���ش�.
		 * */
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			/*db������ ���� id,pw,�ּ� ���� �ڵ��̸�, String�� ������ �������·� ���!*/
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			/*������ �����Ϳ� ���̺��� ������ �κп��� ����ڸ� ������ָ� ���� �������� �پ��.*/
			String sql = "DELETE FROM comedian WHERE comedian_id = ?";
			/*db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!*/
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			/*������ �ֱ�!*/
			statement.setInt(1, comedianId);
			/*���� ����*/
			statement.executeUpdate();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	}
	
	public void insertComedian(Comedian comedian) {
		/*�⺻���� ��ü�������� ����, ���� try�� �ȿ��� ���� ������ �ϰԵǸ����������� 
		 * �����̵Ǿ finally������ colose�� ���� ���ϱ⶧����try�� �ۿ��� ������ ���ش�.
		 * */
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			/*db������ ���� id,pw,�ּ� ���� �ڵ��̸�, String�� ������ �������·� ���!*/
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			/*������ �����Ϳ� ���̺��� ������ �κп��� ����ڸ� ������ָ� ���� �������� �پ��.*/
			String sql = "INSERT INTO comedian (comedian_name, comedian_age) VALUES (?,?)";
			/*db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!*/
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			/*������ �ֱ�!*/
			statement.setString(1, comedian.getComedianName());
			statement.setInt(2, comedian.getComedianAge());
			/*���� ����*/
			statement.executeUpdate();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	}
	
	/*select �� �� ������Ÿ���� Comedian�� list�� �����ؾ� �Ѵ�.*/
	public ArrayList<Comedian> selectComedianList() {
		/*�⺻���� ��ü�������� ����, ���� try�� �ȿ��� ���� ������
		 * �ϰԵǸ����������� �����̵Ǿ finally������ colose��
		 * ���� ���ϱ⶧����try�� �ۿ��� ������ ���ش�.
		 * */
		ArrayList<Comedian> list = new ArrayList<Comedian>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			/*db������ ���� id,pw,�ּ� ���� �ڵ��̸�, String�� ������ �������·� ���!*/
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			/*������ �����Ϳ� ���̺��� ������ �κп��� ����ڸ� ������ָ� ���� �������� �پ��.
			 * ���� order by �� ���� "order by �÷��� [asc or desc]" ������ ����ϴµ�,
			 * ���ڷ� ��� �Ͽ��� ������, �������� ���� ���� �ϱ����Ͽ� �ٸ��ƽ� �� �̸��� ���ش�.
			 * */
			String sql = "SELECT comedian_id AS comedianId, comedian_name AS comedianName, comedian_age AS comedianAge FROM comedian ORDER BY comedianId ASC";
			
			/*db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!*/
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			
			/*select �ÿ��� executeQuery�� �����Ͽ�, 
			 *ResultSet�� ���ϰ����� �޴´�.update, delete, insert���� ����
			 *executeUpdate�޼��带 ����Ͽ�,��� ���� �����ǰų�
			 *�߰��ǰų� ������Ʈ �Ǿ����� Ȯ�� �� �� �ִ�.
			 * */
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Comedian comedian = new Comedian();
				/*select������ �ٸ��ƽ��� ��ġ������� ������, �̸��� 
				 * �Ȱ��� ����Ҽ��ִ�. ���߿��� ��ġ���Ѿ߸� �ڵ带 ���� �� �ִ� ���� 
				 * ��� �� �̱⶧���� �ʼ�!!
				 * */
				comedian.setComedianId(resultSet.getInt("comedianId"));
				comedian.setComedianName(resultSet.getString("comedianName"));
				comedian.setComedianAge(resultSet.getInt("comedianAge"));
				list.add(comedian);
			}
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
