package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ActorDao {
	public Connection selectActorList(){
		Connection recon = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdevdb?" +
				"useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		try {
			recon = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return recon;
	}
}
