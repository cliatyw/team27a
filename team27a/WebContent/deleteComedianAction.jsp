<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>deleteComedianAction.jsp</title>
	</head>
	<body>
		<%
		ComedianDao comedianDao = new ComedianDao();
		comedianDao.deleteComedian(Integer.parseInt(request.getParameter("comedianId")));
		response.sendRedirect(request.getContextPath() + "/comedianList.jsp");
		%>
	</body>
</html>