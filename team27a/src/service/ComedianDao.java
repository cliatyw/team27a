/*[진경수]*/
package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ComedianDao {
	/*
	default생성자 이긴 한데, 
	public안해주면 not visible상태가 되기 때문에 호출 할 수 없다. 
	따라서 public만 붙여서 선언해준다.
	*/
	
	public ComedianDao() {}
	
	/*select 한 후 데이터타입이 Comedian인 list를 리턴해야 한다.*/
	public ArrayList<Comedian> selectComedianList() {
		/*
		기본적인 객체참조변수 선언, 만약 try절 안에서 변수 선언을 하게되면
		지역변수로 선언이되어서 finally절에서 colose를 하지 못하기때문에
		try절 밖에서 선언을 해준다.
		*/
		ArrayList<Comedian> list = new ArrayList<Comedian>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			/*db접속을 위한 id,pw,주소 설정 코드이며, String은 무조건 변수형태로 사용!*/
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			/*쿼리는 데이터와 테이블을 제외한 부분에서 대분자를 사용해주면 더욱 가독성이 뛰어나다.*/
			String sql = "SELECT comedian_id AS comedianId, comedian_name AS comedianName, comedian_age AS comedianAge FROM comedian";
			
			/*db 접속을 받는 부분. 커넥션을 받는다!*/
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			
			/*
			select 시에는 executeQuery를 실행하여, ResultSet을 리턴값으로 받는다.
			update, delete, insert같은 경우는 executeUpdate메서드를 사용하여,
			몇개의 행이 삭제되거나 추가되거나 업데이트 되었는지 확인 할 수 있다.
			*/
			resultSet = statement.executeQuery();
			Comedian comedian;
			while(resultSet.next()){
				comedian = new Comedian();
				/*
				select문에서 앨리아스를 일치시켜줬기 때문에, 이름을 똑같이 사용할수있다.
				나중에는 일치시켜야만 코드를 줄일 수 있는 툴을 배울 것 이기때문에 필수!!
				*/
				comedian.setComedianId(resultSet.getInt("comedianId"));
				comedian.setComedianName(resultSet.getString("comedianName"));
				comedian.setComedianAge(resultSet.getInt("comedianAge"));
				list.add(comedian);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return list;
	}
}
