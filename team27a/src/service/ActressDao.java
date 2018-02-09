/*[백지훈]*/
package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ActressDao {
	
	/*
	 * default생성자 이긴 한데, public안해주면 
	 * not visible상태가 되기 때문에 호출 할 수 없다. 
	 * 따라서 public만 붙여서 선언해준다.
	 */
	public ActressDao() {}
	
	
	public int insertActress(Actress actress) {
		//단위테스트
		System.out.println(actress);
		return 0;
	}
	
	
	/*
	 * select 한 후 리턴값으로 Comedian.class의 배열이나 List 받아야 한다.
	 * 배열이나, ArrayList, HashMap을 사용할 수 있다.
	 * ArrayList를 지금 사용해보고, HashMap도 테스트 해볼것.
	 */
	public ArrayList<Actress> selectActressList() {
		//기본적인 객체참조변수 선언.
		ArrayList<Actress> list = new ArrayList<Actress>();
		
		// finally절에서 colose....
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			//db접속을 위한 id,pw,주소 설정 코드인데, root관리자로 접속하라는 코드여서, 새로운 user를 추가하는것을 고려해야하지않을까?
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// 별명
			String sql = "SELECT actress_id as actressId, actress_name as actressName,actress_age as actressAge FROM actress";
			//db 접속을 받는 부분. 커넥션을 받는다!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			//select 시에는 executeQuery를 실행하여, ResultSet을 리턴값으로 받는다.
			//update, delete, insert같은 경우는 executeUpdate다~
			resultSet = statement.executeQuery();
			
			//여기에서 객체를 생성하는 이유는 SQLException , ClassNotFoundException 같은 예외처리부분에서 에러가 날경우에는 객체생성 안하기 위해~
			while(resultSet.next()){
				Actress actress = new Actress();
				//여기에서 오류났엇는데, DB테이블안에 있는 컬럼명은 단어와 단어 사이 '_'를 쓴다는것을 주의할것!! 우리 코드는 두번째 단어부터 대문자다!!
				int actressId = resultSet.getInt("actressId");
				String actressName = resultSet.getString("actressName");
				int actressAge = resultSet.getInt("actressAge");
	
				//내가 INT형 해놔서 Integer클래스의 parseInt메서드를
				actress.setActressId(actressId);
				actress.setActressName(actressName);
				actress.setActressAge(actressAge);
				list.add(actress);
			}
			// 단위테스트
			System.out.println(list.size()+"7");
		} catch(ClassNotFoundException e) { // Class.forName()
			e.printStackTrace();
		} catch(SQLException e) { // JDBC
			e.printStackTrace();
		} finally {
			if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return list;
	}
}
