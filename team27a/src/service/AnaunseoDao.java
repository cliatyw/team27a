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
		//collection �� ��ǥ���·� ������������ �����ϸ� �ȴ�. ex) ArrayList -> list
		//�������� �ѹ��� ��ġ�� ���ؼ� ���콺 ������ refactor rename���� ���� �ѹ��� ��ĥ���ִ�. ����� : alt shift R
		ArrayList<Anaunseo> list = new ArrayList<Anaunseo>();
		//finally������ ������ ���� ���̴�.
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*����̹� �ε�
			 *�ֽ��� ��Ȯ�� �ľ��� ������ ���� �ʴ´�. �����ؼ� Ȯ���غ���
			 *������ �Է¹��� ���� ������ ������ ���� ����.
			 *Ŭ������ �ִ� ������ �÷����� ��ġ�ϱ� ���ؼ� ������ �����Ѵ�. as
			 *�������� �ִ� select�� from �� �����ϱ� ���� �빮�ڷ� �ϴ°��� ����.
			*/
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" + "useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT anaunseo_id AS AnaunseoId, anaunseo_name AS AnaunseoName, anaunseo_age AS AnaunseoAge FROM anaunseo";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//db����
			
			preparedStatement = connection.prepareStatement(sql);
			//ananunseo ���̺� �÷�3���� select�Ѵ�
			resultSet = preparedStatement.executeQuery();
			//���� ���� �غ� �� ����
			
			while(resultSet.next()) {
				//������ ���� ������ �迭�� ����
				Anaunseo anaunseo = new Anaunseo();
				
				anaunseo.setAnaunseoId(resultSet.getInt("AnaunseoId"));
				anaunseo.setAnaunseoName(resultSet.getString("AnaunseoName"));
				anaunseo.setAnaunseoAge(resultSet.getInt("AnaunseoAge"));
				list.add(anaunseo);
			}
			//�����׽�Ʈ : �迭�̳� ��Ÿ ���ϰ��� ���� �ߵ����� Ȯ���ϱ� ���� �׽�Ʈ(�Է¸� �Ҷ� toString�� Ȱ���Ͽ� Ȱ���Ҽ��ִ�.)
			System.out.println(list.size());
			//���� ó��
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		//������ �߻��ص� �޸𸮴����� �����ϱ� ���� �����Ѵ�.
		}finally{ 
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
		return list;
		//�迭 ����
	}
}
