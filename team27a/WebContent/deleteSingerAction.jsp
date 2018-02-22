<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="service.SingerDao"%>
<%@page import="service.Singer"%>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>deleteSingerAction</title>
	</head>
	<body>
	<%
	int singer_id = Integer.parseInt(request.getParameter("singerId"));
	Singer singer = new Singer();
	singer.setSingerId(singer_id);
	
	SingerDao dao = new SingerDao();
	dao.deleteSinger(singer);
	
	response.sendRedirect(request.getContextPath() + "/singerList.jsp");
	%>
	</body>
</html>