package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnaunseoDao {
	public Anaunseo selectAnaunseoList() throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		pstmt = conn.prepareStatement("select * from tb_member");
		rs = pstmt.executeQuery();
		
		return null;
	}
}
