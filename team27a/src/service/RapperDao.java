/*[������]*/
package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
public class RapperDao {
	/*
	 * default������ �̱� �ѵ�, public�����ָ� 
	 * not visible���°� �Ǳ� ������ ȣ�� �� �� ����. 
	 * ���� public�� �ٿ��� �������ش�.
	 */
	public RapperDao() {}
	
	public void deleteRapper(int rapperId) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM rapper WHERE rapper_id=?";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, rapperId);
			statement.executeUpdate();
			
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
		//�⺻���� ��ü�������� ����.
		ArrayList<Rapper> list = new ArrayList<Rapper>();
		
		// finally������ close....
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			//db������ ���� id,pw,�ּ� ���� �ڵ��ε�, root�����ڷ� �����϶�� �ڵ忩��, ���ο� user�� �߰��ϴ°��� ����ؾ�����������?
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// ����
			String sql = "SELECT rapper_id AS rapperId, rapper_name AS rapperName,rapper_age AS rapperAge FROM rapper";
			//db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			//select �ÿ��� executeQuery�� �����Ͽ�, ResultSet�� ���ϰ����� �޴´�.
			//update, delete, insert���� ���� executeUpdate��~
			resultSet = statement.executeQuery();
			
			//���⿡�� ��ü�� �����ϴ� ������ SQLException , ClassNotFoundException ���� ����ó���κп��� ������ ����쿡�� ��ü���� ���ϱ� ����~
			while(resultSet.next()){
				Rapper rapper = new Rapper();
	
				//���� INT�� �س��� IntegerŬ������ parseInt�޼��带
				rapper.setRapperId(resultSet.getInt("rapperId"));  
				rapper.setRapperName(resultSet.getString("rapperName"));
				rapper.setRapperAge(resultSet.getInt("rapperAge"));  
				list.add(rapper);
			}
			// �����׽�Ʈ
			System.out.println(list.size()+"7");
		} catch(ClassNotFoundException e) { // Class.forName()
			e.printStackTrace();
		} catch(SQLException e) { // JDBC
			e.printStackTrace();
		} finally {
			if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return list;
	}
	public void insertRapper(Rapper rapper) {			
			PreparedStatement statement = null;
			Connection connection = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				String sql = "INSERT INTO rapper VALUES (NULL, ?, ?)";		
			
				connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);			
				statement = connection.prepareStatement(sql);
				statement.setString(1, rapper.getRapperName());
				statement.setInt(2, rapper.getRapperAge());
				statement.executeUpdate();
		
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
