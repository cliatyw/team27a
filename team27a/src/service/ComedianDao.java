/*[�����]*/
package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ComedianDao {
	//default������ �̱� �ѵ�, public�����ָ� not visible���°� �Ǳ� ������ ȣ�� �� �� ����. ���� public�� �ٿ��� �������ش�.
	public ComedianDao() {}
	
	//select �� �� ���ϰ����� Comedian.class�� �޾ƾ� �Ѵ�. �迭�̳�, ArrayList, HashMap�� ����� �� �ִ�.
	//ArrayList�� ���� ����غ���, HashMap�� �׽�Ʈ �غ���.
	public ArrayList<Comedian> selectComedianList() {
		//�⺻���� ��ü�������� ����.
		ArrayList<Comedian> arrayComedian = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			//db������ ���� id,pw,�ּ� ���� �ڵ��ε�, root�����ڷ� �����϶�� �ڵ忩��, ���ο� user�� �߰��ϴ°��� ����ؾ�����������?
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
	
			//db ������ �޴� �κ�. Ŀ�ؼ��� �޴´�!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedStatement = connection.prepareStatement("select comedian_id,comedian_name,comedian_age from comedian");
			//select �ÿ��� executeQuery�� �����Ͽ�, ResultSet�� ���ϰ����� �޴´�.
			//update, delete, insert���� ���� executeUpdate��~
			resultSet = preparedStatement.executeQuery();
			
			//���⿡�� ��ü�� �����ϴ� ������ SQLException , ClassNotFoundException ���� ����ó���κп��� ������ ����쿡�� ��ü���� ���ϱ� ����~
			arrayComedian = new ArrayList<Comedian>();
			Comedian comedian;
			while(resultSet.next()){
				comedian = new Comedian();
				//���⿡�� ���������µ�, DB���̺�ȿ� �ִ� �÷����� �ܾ�� �ܾ� ���� '_'�� ���ٴ°��� �����Ұ�!! �츮 �ڵ�� �ι�° �ܾ���� �빮�ڴ�!!
				//���� INT�� �س��� getInt�� ��!! �׸��� ���� ������ �����ؼ� �ٸ��� ������� �ʱ⶧���� �ٷ� �����͸� �����ع�����.
				comedian.setComedianId(resultSet.getInt("comedian_id"));
				comedian.setComedianName(resultSet.getString("comedian_name"));
				comedian.setComedianAge(resultSet.getInt("comedian_age"));
				arrayComedian.add(comedian);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return arrayComedian;
	}
}
