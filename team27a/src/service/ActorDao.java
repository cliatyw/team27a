/*[�赵��]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ActorDao {

	public ArrayList<Actor> selectActorList() {
		
		ArrayList<Actor> list = new ArrayList<>();
		//close�� �ϱ����ؼ� null�� �ʱ�ȭ�� ���Ѿߵ�
		Connection connection = null;
		PreparedStatement Statement = null;
		ResultSet resultset = null;
								
		try {			
			//����̹��ε�
			Class.forName("com.mysql.jdbc.Driver");
			//DB����
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT actor_id as actorId,actor_name as actorName,actor_age as actorAge FROM actor ORDER BY actor_id";
				
			connection = DriverManager.getConnection(dbDriver,dbUser,dbPass);
			Statement = connection.prepareStatement(sql);
			//��������
			resultset = Statement.executeQuery();
			//DB������ �о����
			while(resultset.next()){
				//DB Į���� ��������
				int actorId=resultset.getInt("actorId");
				String actorName=resultset.getString("actorName");
				int actorAge=resultset.getInt("actorAge");
				//actor���������� id,name,age ���� set�޼ҵ带 ����� ��´�
				Actor actor = new Actor();
				actor.setActorId(actorId);
				actor.setActorName(actorName);
				actor.setActorAge(actorAge);
				//actor�� ���� list�迭��  �߰��Ѵ�.
				list.add(actor);
			}		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultset != null) try { resultset.close(); } catch(SQLException ex) {}
			if (Statement != null) try { Statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
 		 return list;
	}
}
