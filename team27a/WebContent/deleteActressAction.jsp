<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ActressDao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> deleteActressAction.jsp </title>
	</head>
	<body>
		<%
		ActressDao actressDao = new ActressDao();
		actressDao.deleteActress(Integer.parseInt(request.getParameter("actress")));	
		response.sendRedirect(request.getContextPath() + "/actressList.jsp");
		%>
	
	</body>
</html>