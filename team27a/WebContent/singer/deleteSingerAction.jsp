<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="service.SingerDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>deleteSingerAction.jsp</title>
	</head>
	<body>
		<%
		SingerDao dao = new SingerDao();
		dao.deleteSinger(Integer.parseInt(request.getParameter("singerId")));	
		response.sendRedirect(request.getContextPath() + "/singerList.jsp");
		%>
	</body>
</html>