package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingerDao {
	public Connection driverDbcon() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");

		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" + "useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";

		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		return conn;

	}

}