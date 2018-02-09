/*[김기성]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RapperDao {
	public ArrayList<Rapper> selectRapperList(){
		Connection connection = null; //변수이름을 설정한다
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Rapper> array = new ArrayList<Rapper>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //드라이버 로딩
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); //db연결
			
			preparedStatement = connection.prepareStatement("select rapper_id, rapper_name, rapper_age from rapper"); //rapper 테이블에 컬럼3개를 select한다
			resultSet = preparedStatement.executeQuery(); //쿼리 실행 준비 및 실행
			
			while(resultSet.next()) { //쿼리에 내용 있으면 배열에 대입
				Rapper rapper = new Rapper();
				rapper.setRapperId(resultSet.getInt("rapper_id"));
				rapper.setRapperName(resultSet.getString("rapper_name"));
				rapper.setRapperAge(resultSet.getInt("rapper_age"));
				array.add(rapper);
			}
			
		} catch (ClassNotFoundException e) { //예외 처리
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{ //에러가 발생해도 메모리누수를 방지하기 위해 종료한다.
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
		return array; //배열 리턴
		
	}
}
