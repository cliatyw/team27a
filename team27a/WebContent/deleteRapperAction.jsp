<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.RapperDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> deleteRapperAction.jsp </title>
	</head>
	<body>
		<%
		RapperDao rapperDao = new RapperDao();
		rapperDao.deleteRapper(Integer.parseInt(request.getParameter("rapperId")));
		response.sendRedirect(request.getContextPath() + "/rapperList.jsp");
		%>
	</body>
</html>