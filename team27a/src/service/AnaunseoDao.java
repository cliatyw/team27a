/*[��⼺]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnaunseoDao {
	public ArrayList<Anaunseo> selectAnaunseoList() {
		ArrayList<Anaunseo> array = new ArrayList<Anaunseo>();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  //����̹� �ε�
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" + "useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); //db����
			
			preparedStatement = connection.prepareStatement("select anaunseo_id, anaunseo_name, anaunseo_age from anaunseo"); //ananunseo ���̺� �÷�3���� select�Ѵ�
			resultSet = preparedStatement.executeQuery(); //���� ���� �غ� �� ����
			
			while(resultSet.next()) { //������ ���� ������ �迭�� ����
				Anaunseo anaunseo = new Anaunseo();
				
				System.out.println(resultSet.getInt("anaunseo_id"));
				anaunseo.setAnaunseoId(resultSet.getInt("anaunseo_id"));
				anaunseo.setAnaunseoName(resultSet.getString("anaunseo_name"));
				anaunseo.setAnaunseoAge(resultSet.getInt("anaunseo_age"));
				array.add(anaunseo);
			}
		}catch (ClassNotFoundException e) { //���� ó��
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{ //������ �߻��ص� �޸𸮴����� �����ϱ� ���� �����Ѵ�.
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
