package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ActressDao {
	//default생성자 이긴 한데, public안해주면 not visible상태가 되기 때문에 호출 할 수 없다. 따라서 public만 붙여서 선언해준다.
	public ActressDao() {}
	
	//select 한 후 리턴값으로 Comedian.class를 받아야 한다. 배열이나, ArrayList, HashMap을 사용할 수 있다.
	//ArrayList를 지금 사용해보고, HashMap도 테스트 해볼것.
	public ArrayList<Actress> selectActressList() {
		//기본적인 객체참조변수 선언.
		ArrayList<Actress> arrayActress = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			//db접속을 위한 id,pw,주소 설정 코드인데, root관리자로 접속하라는 코드여서, 새로운 user를 추가하는것을 고려해야하지않을까?
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
	
			//db 접속을 받는 부분. 커넥션을 받는다!
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedStatement = connection.prepareStatement("select actress_id,actress_name,actress_age from Actress");
			//select 시에는 executeQuery를 실행하여, ResultSet을 리턴값으로 받는다.
			//update, delete, insert같은 경우는 executeUpdate다~
			resultSet = preparedStatement.executeQuery();
			
			//여기에서 객체를 생성하는 이유는 SQLException , ClassNotFoundException 같은 예외처리부분에서 에러가 날경우에는 객체생성 안하기 위해~
			arrayActress = new ArrayList<Actress>();
			while(resultSet.next()){
				Actress actress = new Actress();
				//여기에서 오류났엇는데, DB테이블안에 있는 컬럼명은 단어와 단어 사이 '_'를 쓴다는것을 주의할것!! 우리 코드는 두번째 단어부터 대문자다!!
				String actressId = resultSet.getString("actress_id");
				String actressName = resultSet.getString("actress_name");
				String actressAge = resultSet.getString("actress_age");
	
				//내가 INT형 해놔서 Integer클래스의 parseInt메서드를
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
