package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ComedianDao {
	
	public ComedianDao() {}

	public ArrayList<Comedian> selectComedianList() {
		ArrayList<Comedian> arrayComedian = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
	
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedStatement = connection.prepareStatement("select comedian_id,comedian_name,comedian_age from comedian");
			resultSet = preparedStatement.executeQuery();
			
			arrayComedian = new ArrayList<Comedian>();
			while(resultSet.next()){
				Comedian comedian = new Comedian();
				String comedianId = resultSet.getString("comedian_id");
				String comedianName = resultSet.getString("comedian_name");
				String comedianAge = resultSet.getString("comedian_age");
	
				comedian.setComedianId(Integer.parseInt(comedianId));
				comedian.setComedianName(comedianName);
				comedian.setComedianAge(Integer.parseInt(comedianAge));
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
