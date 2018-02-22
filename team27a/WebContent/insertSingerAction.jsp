<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="service.SingerDao"%>
<%@page import="service.Singer"%>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>insertActorAction.jsp</title>
</head>
	<body>
	<%
	String singerName = request.getParameter("singerName");
	int singerAge = Integer.parseInt(request.getParameter("singerAge"));

	Singer singer = new Singer();
	singer.setSingerName(singerName);
	singer.setSingerAge(singerAge);


	SingerDao singerDao = new SingerDao();
	singerDao.insertSinger(singer);

	response.sendRedirect(request.getContextPath() + "/singerList.jsp");
	%>
	</body>
</html>