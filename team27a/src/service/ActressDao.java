/*[������]*/
package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ActressDao {
	
	/*
	 * default������ �̱� �ѵ�, public�����ָ� 
	 * not visible���°� �Ǳ� ������ ȣ�� �� �� ����. 
	 * ���� public�� �ٿ��� �������ش�.
	 */
	public ActressDao() {}
	
	
	public int insertActress(Actress actress) {
		//�����׽�Ʈ
		System.out.println(actress);
		return 0;
	}
	
	
	/*
	 * select �� �� ���ϰ����� Comedian.class�� �迭�̳� List �޾ƾ� �Ѵ�.
	 * �迭�̳�, ArrayList, HashMap�� ����� �� �ִ�.
	 * ArrayList�� ���� ����غ���, HashMap�� �׽�Ʈ �غ���.
	 */
	public ArrayList<Actress> selectActressList() {
		//�⺻���� ��ü�������� ����.
		ArrayList<Actress> list = new ArrayList<Actress>();
		
		// finally������ colose....
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
			String sql = "SELECT actress_id as actressId, actress_name as actressName,actress_age as actressAge FROM actress";
			//db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			//select �ÿ��� executeQuery�� �����Ͽ�, ResultSet�� ���ϰ����� �޴´�.
			//update, delete, insert���� ���� executeUpdate��~
			resultSet = statement.executeQuery();
			
			//���⿡�� ��ü�� �����ϴ� ������ SQLException , ClassNotFoundException ���� ����ó���κп��� ������ ����쿡�� ��ü���� ���ϱ� ����~
			while(resultSet.next()){
				Actress actress = new Actress();
				//���⿡�� ���������µ�, DB���̺�ȿ� �ִ� �÷����� �ܾ�� �ܾ� ���� '_'�� ���ٴ°��� �����Ұ�!! �츮 �ڵ�� �ι�° �ܾ���� �빮�ڴ�!!
				int actressId = resultSet.getInt("actressId");
				String actressName = resultSet.getString("actressName");
				int actressAge = resultSet.getInt("actressAge");
	
				//���� INT�� �س��� IntegerŬ������ parseInt�޼��带
				actress.setActressId(actressId);
				actress.setActressName(actressName);
				actress.setActressAge(actressAge);
				list.add(actress);
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
}
