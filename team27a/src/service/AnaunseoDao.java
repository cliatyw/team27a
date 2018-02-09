/*[김기성]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnaunseoDao {
	public ArrayList<Anaunseo> selectAnaunseoList() {
		//collection 은 대표형태로 참조변수명을 설정하면 된다. ex) ArrayList -> list
		//변수명을 한번에 고치기 위해선 마우스 오른쪽 refactor rename으로 가서 한번에 고칠수있다. 단축기 : alt shift R
		ArrayList<Anaunseo> list = new ArrayList<Anaunseo>();
		//finally절에서 변수를 닫을 것이다.
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*드라이버 로딩
			 *주스는 정확히 쳐야지 오류가 나지 않는다. 복사해서 확인해보자
			 *쿼리에 입력받은 값이 없을땐 빼놓는 것이 좋다.
			 *클래스에 있는 변수와 컬럼값이 일치하기 위해서 별명을 설정한다. as
			 *쿼리문에 있는 select나 from 등 구별하기 쉽게 대문자로 하는것이 좋다.
			*/
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" + "useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT anaunseo_id AS AnaunseoId, anaunseo_name AS AnaunseoName, anaunseo_age AS AnaunseoAge FROM anaunseo";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//db연결
			
			preparedStatement = connection.prepareStatement(sql);
			//ananunseo 테이블에 컬럼3개를 select한다
			resultSet = preparedStatement.executeQuery();
			//쿼리 실행 준비 및 실행
			
			while(resultSet.next()) {
				//쿼리에 내용 있으면 배열에 대입
				Anaunseo anaunseo = new Anaunseo();
				
				anaunseo.setAnaunseoId(resultSet.getInt("AnaunseoId"));
				anaunseo.setAnaunseoName(resultSet.getString("AnaunseoName"));
				anaunseo.setAnaunseoAge(resultSet.getInt("AnaunseoAge"));
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
		return list;
		//배열 리턴
	}
}
