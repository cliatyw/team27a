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
			Class.forName("com.mysql.jdbc.Driver");  //드라이버 로딩
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" + "useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedStatement = connection.prepareStatement("select * from tb_member");
			resultSet = preparedStatement.executeQuery(); //쿼리 실행 준비 및 실행
			
			while(resultSet.next()) { //쿼리에 내용 있으면 배열에 대입
				Anaunseo anaunseo = new Anaunseo();
				anaunseo.setAnaunseoId(resultSet.getInt("AnaunseoId"));
				anaunseo.setAnaunseoName(resultSet.getString("AnaunseoName"));
				anaunseo.setAnaunseoAge(resultSet.getInt("AnaunseoAge"));
				array.add(anaunseo);
			}
		}catch (ClassNotFoundException e) { //예외 처리
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		
		return array; //배열 리턴
	}
}
