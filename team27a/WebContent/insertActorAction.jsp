<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>insertActorAction.jsp</title>
</head>
<body>
	<%  //입력창에서 getParameter로 한글값을 받을때 한글깨짐을 막아줌
		request.setCharacterEncoding("euc-kr");	
	
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		String actorName = request.getParameter("actorName");
		String actorAge = request.getParameter("actorAge");
		System.out.println(actorName);
		System.out.println(actorAge);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			/* try { */
			String dbDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(dbDriver,dbUser,dbPass);
			System.out.println(connection+"<--connection");
			
			statement = connection.prepareStatement("INSERT INTO actor(actor_name, actor_age) VALUES (?, ?)");
			statement.setString(1,actorName);
			statement.setString(2,actorAge);
			System.out.println(statement+"<--statement");
			
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultset != null) try {resultset.close();} catch(SQLException ex) {}
			if (statement != null) try {statement.close();} catch(SQLException ex) {}
			if (connection != null) try {connection.close();} catch(SQLException ex) {}
		}
		response.sendRedirect(request.getContextPath()+"/actorList.jsp");
	%>
</body>
</html>