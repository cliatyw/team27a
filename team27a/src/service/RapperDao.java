/*[��⼺]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RapperDao {
	public ArrayList<Rapper> selectRapperList(){
		Connection connection = null; //�����̸��� �����Ѵ�
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Rapper> array = new ArrayList<Rapper>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //����̹� �ε�
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); //db����
			
			preparedStatement = connection.prepareStatement("select rapper_id, rapper_name, rapper_age from rapper"); //rapper ���̺� �÷�3���� select�Ѵ�
			resultSet = preparedStatement.executeQuery(); //���� ���� �غ� �� ����
			
			while(resultSet.next()) { //������ ���� ������ �迭�� ����
				Rapper rapper = new Rapper();
				rapper.setRapperId(resultSet.getInt("rapper_id"));
				rapper.setRapperName(resultSet.getString("rapper_name"));
				rapper.setRapperAge(resultSet.getInt("rapper_age"));
				array.add(rapper);
			}
			
		} catch (ClassNotFoundException e) { //���� ó��
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{ //������ �߻��ص� �޸𸮴����� �����ϱ� ���� �����Ѵ�.
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return array; //�迭 ����
		
	}
}
