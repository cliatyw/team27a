/*[김기성]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnaunseoDao {
	//목록을 보여주는 매서드 ArrayList<Anaunseo>로 리턴값을 받는다.
	public ArrayList<Anaunseo> selectAnaunseoList() {
		//collection 은 대표형태로 참조변수명을 설정하면 된다. ex) ArrayList -> list
		//변수명을 한번에 고치기 위해선 마우스 오른쪽 refactor rename으로 가서 한번에 고칠수있다. 단축기 : alt shift R
		ArrayList<Anaunseo> list = new ArrayList<Anaunseo>();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		//finally절에서 변수를 닫을 것이다.
		try {
			/*드라이버 로딩
			 *주스는 정확히 쳐야지 오류가 나지 않는다. 복사해서 확인해보자
			 *쿼리에 입력받은 값이 없을땐 빼놓는 것이 좋다.
			 *클래스에 있는 변수와 컬럼값이 일치하기 위해서 별명을 설정한다. as
			 *쿼리문에 있는 select나 from 등을 구별하기 쉽게 대문자로 하는것이 좋다.
			*/
			Class.forName("com.mysql.jdbc.Driver");
			//db연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			//ananunseo 테이블에 컬럼3개를 select한다
			String sql = "SELECT anaunseo_id AS anaunseoId, anaunseo_name AS anaunseoName, anaunseo_age AS anaunseoAge FROM anaunseo ORDER BY anaunseo_id ASC";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//쿼리 실행 준비 및 실행
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			//쿼리에 내용 있으면 배열에 대입
			while(resultSet.next()) {
				Anaunseo anaunseo = new Anaunseo();
				
				anaunseo.setAnaunseoId(resultSet.getInt("anaunseoId"));
				anaunseo.setAnaunseoName(resultSet.getString("anaunseoName"));
				anaunseo.setAnaunseoAge(resultSet.getInt("anaunseoAge"));
				list.add(anaunseo);
			}
			//단위테스트 : 배열이나 기타 리턴값에 값이 잘들어갔는지 확인하기 위한 테스트(입력만 할때 toString을 활용하여 활용할수있다.)
			System.out.println(list.size());
			//예외 처리
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		//에러가 발생해도 메모리누수를 방지하기 위해 종료한다.
		}finally{ 
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//배열 리턴
		return list;
	}
	//Anaunseo type으로 매개변수를 받아 아나운서 이름과 나이를 삽입하는 매서드
	public void insertAnaunseo(Anaunseo anaunseo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			//(아이디, 이름, 나이)를 insert하는 쿼리문
			String sql = "INSERT INTO anaunseo VALUES (NULL, ?, ?)";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			/*form에서 넣은 class객체 주소값에 있는 이름과 나이를 db에 넣는다
			id는 자동으로 증가하기 때문에 null로 하였다.*/
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, anaunseo.getAnaunseoName());
			preparedStatement.setInt(2, anaunseo.getAnaunseoAge());
			preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{ 
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//아이디값을 받아 해당하는 데이터를 삭제하기 위한 매서드
	public void deleteAnaunseo(int anaunseoId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM anaunseo WHERE anaunseo_id=?";

			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, anaunseoId);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{ 
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//아이디값을 받아 한개만 이름과 나이를 Anaunseo 클래스에 세팅하여 anaunseo를 리턴하는 매서드
	public Anaunseo selectAnaunseoOne(int anaunseoId) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Anaunseo anaunseo = new Anaunseo();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT anaunseo_id AS anaunseoId, anaunseo_name AS anaunseoName, anaunseo_age AS anaunseoAge FROM anaunseo WHERE anaunseo_id=?";

			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, anaunseoId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				anaunseo.setAnaunseoId(resultSet.getInt("anaunseoId"));
				anaunseo.setAnaunseoName(resultSet.getString("anaunseoName"));
				anaunseo.setAnaunseoAge(resultSet.getInt("anaunseoAge"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{ 
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return anaunseo;
	}
	//Anaunseo type을 매개변수로 받아 입력받은 이름과 나이를 수정하는 매서드
	public void updateAnaunseo(Anaunseo anaunseo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "UPDATE anaunseo SET anaunseo_name=?, anaunseo_age=? WHERE anaunseo_id=?";

			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, anaunseo.getAnaunseoName());
			preparedStatement.setInt(2, anaunseo.getAnaunseoAge());
			preparedStatement.setInt(3, anaunseo.getAnaunseoId());
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
