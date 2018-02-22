/*[�赵��]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ActorDao {
	/*Actor Id,Name,Age�� ��� �˻��Ͽ� ��ȸ�ϴ� �޼ҵ�μ�,
	Actor�� Id,Name,Age�� ���� ���� list �迭�� �����Ѵ�.*/
	public ArrayList<Actor> selectActorList() {
		
		ArrayList<Actor> list = new ArrayList<>();
		//close�� �ϱ����ؼ� null�� �ʱ�ȭ�� ���Ѿߵ�
		Connection connection = null;
		PreparedStatement statement = null;
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
			statement = connection.prepareStatement(sql);
			//��������
			resultset = statement.executeQuery();
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
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
 		 return list;
	}
    /*Dao(Data Access Object) DB�� ����� �����͸� ��ȸ�ϰų� �����ϴ� ����� �����ϵ��� ���� ����̹Ƿ�
	insertActorAction.jsp�� �ƴ� ActorDao�� insert�κ��� ����� �߰��ؾ���*/
	/*Actor�� Name, Age�� INSERT�������� �̿��Ͽ� �߰��ϴ� �޼ҵ�*/
	public void insertActor(Actor actor) {
		/*������ ������ �����Ͱ� ���̴°��� �������� finally�� �̿��� close�Ѵ�*/ 
		Connection connection = null;
		PreparedStatement statement = null;
		/*����̹��ε�*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*DB����*/
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO actor(actor_name, actor_age) VALUES (?, ?)";
			
			connection = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			statement=connection.prepareStatement(sql);
			statement.setString(1, actor.getActorName());
			statement.setInt(2, actor.getActorAge());
			/*executeQuery�� ��������� ResultSet�� ��� ���� �޼ҵ�� �ַ� SELECT���� 
			���Ǹ� ,executeUpdate�� ���������� �����͸� �ٷ�� INSERT, UPDATE,
			DELETE���̳� ���̺��� �ٷ�� CREATAE, DROP, ALTER�� ���*/
			statement.executeUpdate();			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	}
	/*�Ű������� int type�� actorId�� �Է¹޾� �ش� id�� ���������� DELETE�� �̿��Ͽ� �����ϴ� �޼ҵ�*/
	public void deleteActor(int actorId) {
		/*������ ������ �����Ͱ� ���̴°��� �������� finally�� �̿��� close�Ѵ�*/ 
		Connection connection = null;
		PreparedStatement statement = null;
		/*����̹��ε�*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*DB����*/
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM actor WHERE actor_id=?";
						
			connection = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			statement=connection.prepareStatement(sql);
			statement.setInt(1, actorId);
			statement.executeUpdate();
		} catch (ClassNotFoundException |  SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	}
	public Actor selectActorOne(int actorId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		Actor actor = new Actor();
		/*����̹��ε�*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT actor_id AS actorId,actor_name AS actorName,actor_age AS actorAge FROM actor WHERE actor_id=?";
						
			connection = DriverManager.getConnection(dbDriver,dbUser,dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, actorId);
			resultset = statement.executeQuery();
			
			while(resultset.next()) {
				actor.setActorId(Integer.parseInt(resultset.getString("actorId")));
				actor.setActorName(resultset.getString("actorName"));
				actor.setActorAge(Integer.parseInt(resultset.getString("actorAge")));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
			if (resultset != null) try { resultset.close(); } catch(SQLException ex) {}
		} return actor;
	}
	public void updateActor(Actor actor) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "UPDATE actor SET actor_id=?,actor_name=?,actor_age=? WHERE actor_id=?";
						
			connection = DriverManager.getConnection(dbDriver,dbUser,dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, actor.getActorId());
			statement.setString(2, actor.getActorName());
			statement.setInt(3, actor.getActorAge());
			statement.setInt(4, actor.getActorId());
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	}
}
