/*[��⼺]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnaunseoDao {
	//����� �����ִ� �ż��� ArrayList<Anaunseo>�� ���ϰ��� �޴´�.
	public ArrayList<Anaunseo> selectAnaunseoList() {
		//collection �� ��ǥ���·� ������������ �����ϸ� �ȴ�. ex) ArrayList -> list
		//�������� �ѹ��� ��ġ�� ���ؼ� ���콺 ������ refactor rename���� ���� �ѹ��� ��ĥ���ִ�. ����� : alt shift R
		ArrayList<Anaunseo> list = new ArrayList<Anaunseo>();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		//finally������ ������ ���� ���̴�.
		try {
			/*����̹� �ε�
			 *�ֽ��� ��Ȯ�� �ľ��� ������ ���� �ʴ´�. �����ؼ� Ȯ���غ���
			 *������ �Է¹��� ���� ������ ������ ���� ����.
			 *Ŭ������ �ִ� ������ �÷����� ��ġ�ϱ� ���ؼ� ������ �����Ѵ�. as
			 *�������� �ִ� select�� from ���� �����ϱ� ���� �빮�ڷ� �ϴ°��� ����.
			*/
			Class.forName("com.mysql.jdbc.Driver");
			//db����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			//ananunseo ���̺� �÷�3���� select�Ѵ�
			String sql = "SELECT anaunseo_id AS anaunseoId, anaunseo_name AS anaunseoName, anaunseo_age AS anaunseoAge FROM anaunseo ORDER BY anaunseo_id ASC";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//���� ���� �غ� �� ����
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			//������ ���� ������ �迭�� ����
			while(resultSet.next()) {
				Anaunseo anaunseo = new Anaunseo();
				
				anaunseo.setAnaunseoId(resultSet.getInt("anaunseoId"));
				anaunseo.setAnaunseoName(resultSet.getString("anaunseoName"));
				anaunseo.setAnaunseoAge(resultSet.getInt("anaunseoAge"));
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
		//�迭 ����
		return list;
	}
	//Anaunseo type���� �Ű������� �޾� �Ƴ�� �̸��� ���̸� �����ϴ� �ż���
	public void insertAnaunseo(Anaunseo anaunseo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			//(���̵�, �̸�, ����)�� insert�ϴ� ������
			String sql = "INSERT INTO anaunseo VALUES (NULL, ?, ?)";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			/*form���� ���� class��ü �ּҰ��� �ִ� �̸��� ���̸� db�� �ִ´�
			id�� �ڵ����� �����ϱ� ������ null�� �Ͽ���.*/
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, anaunseo.getAnaunseoName());
			preparedStatement.setInt(2, anaunseo.getAnaunseoAge());
			preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{ 
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
	}
	//���̵��� �޾� �ش��ϴ� �����͸� �����ϱ� ���� �ż���
	public void deleteAnaunseo(int anaunseoId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM anaunseo WHERE anaunseo_id=?";

			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, anaunseoId);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{ 
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
	}
	//���̵��� �޾� �Ѱ��� �̸��� ���̸� Anaunseo Ŭ������ �����Ͽ� anaunseo�� �����ϴ� �ż���
	public Anaunseo selectAnaunseoOne(int anaunseoId) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Anaunseo anaunseo = new Anaunseo();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT anaunseo_id AS anaunseoId, anaunseo_name AS anaunseoName, anaunseo_age AS anaunseoAge FROM anaunseo WHERE anaunseo_id=?";

			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, anaunseoId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				anaunseo.setAnaunseoId(resultSet.getInt("anaunseoId"));
				anaunseo.setAnaunseoName(resultSet.getString("anaunseoName"));
				anaunseo.setAnaunseoAge(resultSet.getInt("anaunseoAge"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
		return anaunseo;
	}
	//Anaunseo type�� �Ű������� �޾� �Է¹��� �̸��� ���̸� �����ϴ� �ż���
	public void updateAnaunseo(Anaunseo anaunseo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "UPDATE anaunseo SET anaunseo_name=?, anaunseo_age=? WHERE anaunseo_id=?";

			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, anaunseo.getAnaunseoName());
			preparedStatement.setInt(2, anaunseo.getAnaunseoAge());
			preparedStatement.setInt(3, anaunseo.getAnaunseoId());
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
	}
}
