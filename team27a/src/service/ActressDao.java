package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ActressDao {
	//default������ �̱� �ѵ�, public�����ָ� not visible���°� �Ǳ� ������ ȣ�� �� �� ����. ���� public�� �ٿ��� �������ش�.
	public ActressDao() {}
	
	//select �� �� ���ϰ����� Comedian.class�� �޾ƾ� �Ѵ�. �迭�̳�, ArrayList, HashMap�� ����� �� �ִ�.
	//ArrayList�� ���� ����غ���, HashMap�� �׽�Ʈ �غ���.
	public ArrayList<Actress> selectActressList() {
		//�⺻���� ��ü�������� ����.
		ArrayList<Actress> arrayActress = null;
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
			preparedStatement = connection.prepareStatement("select actress_id,actress_name,actress_age from Actress");
			//select �ÿ��� executeQuery�� �����Ͽ�, ResultSet�� ���ϰ����� �޴´�.
			//update, delete, insert���� ���� executeUpdate��~
			resultSet = preparedStatement.executeQuery();
			
			//���⿡�� ��ü�� �����ϴ� ������ SQLException , ClassNotFoundException ���� ����ó���κп��� ������ ����쿡�� ��ü���� ���ϱ� ����~
			arrayActress = new ArrayList<Actress>();
			while(resultSet.next()){
				Actress actress = new Actress();
				//���⿡�� ���������µ�, DB���̺�ȿ� �ִ� �÷����� �ܾ�� �ܾ� ���� '_'�� ���ٴ°��� �����Ұ�!! �츮 �ڵ�� �ι�° �ܾ���� �빮�ڴ�!!
				String actressId = resultSet.getString("actress_id");
				String actressName = resultSet.getString("actress_name");
				String actressAge = resultSet.getString("actress_age");
	
				//���� INT�� �س��� IntegerŬ������ parseInt�޼��带
				actress.setActressId(actressId);
				actress.setActressName(actressName);
				actress.setActressAge(actressAge);
				arrayActress.add(actress);

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
		return arrayActress;
	}
}
