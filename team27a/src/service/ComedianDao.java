/*[�����]*/
package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ComedianDao {
	/*
	default������ �̱� �ѵ�, 
	public�����ָ� not visible���°� �Ǳ� ������ ȣ�� �� �� ����. 
	���� public�� �ٿ��� �������ش�.
	*/
	
	public ComedianDao() {}
	
	/*select �� �� ������Ÿ���� Comedian�� list�� �����ؾ� �Ѵ�.*/
	public ArrayList<Comedian> selectComedianList() {
		/*
		�⺻���� ��ü�������� ����, ���� try�� �ȿ��� ���� ������ �ϰԵǸ�
		���������� �����̵Ǿ finally������ colose�� ���� ���ϱ⶧����
		try�� �ۿ��� ������ ���ش�.
		*/
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
			
			/*������ �����Ϳ� ���̺��� ������ �κп��� ����ڸ� ������ָ� ���� �������� �پ��.*/
			String sql = "SELECT comedian_id AS comedianId, comedian_name AS comedianName, comedian_age AS comedianAge FROM comedian";
			
			/*db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!*/
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			
			/*
			select �ÿ��� executeQuery�� �����Ͽ�, ResultSet�� ���ϰ����� �޴´�.
			update, delete, insert���� ���� executeUpdate�޼��带 ����Ͽ�,
			��� ���� �����ǰų� �߰��ǰų� ������Ʈ �Ǿ����� Ȯ�� �� �� �ִ�.
			*/
			resultSet = statement.executeQuery();
			Comedian comedian;
			while(resultSet.next()){
				comedian = new Comedian();
				/*
				select������ �ٸ��ƽ��� ��ġ������� ������, �̸��� �Ȱ��� ����Ҽ��ִ�.
				���߿��� ��ġ���Ѿ߸� �ڵ带 ���� �� �ִ� ���� ��� �� �̱⶧���� �ʼ�!!
				*/
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
