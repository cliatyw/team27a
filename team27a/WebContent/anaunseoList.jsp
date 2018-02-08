<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@ page import = "java.sql.DriverManager" %>
	<%@ page import = "java.sql.Connection" %>
	<%@ page import = "java.sql.ResultSet" %>
	<%
		Connection conn = null;
		ResultSet rs = null;
		
		Class.forName("com.mysql.jdbc.Driver"); //드라이버 로딩
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" + "useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); //db 연결
		
	%>
</body>
</html>