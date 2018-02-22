<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.RapperDao" %>
<%@ page import = "service.Rapper" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>insertRapperAction</title>
	</head>
	<body>
		<%
		String rapperName = request.getParameter("rapperName");
		int rapperAge = Integer.parseInt(request.getParameter("rapperAge"));
	
		Rapper rapper = new Rapper();
		rapper.setRapperName(rapperName);
		rapper.setRapperAge(rapperAge);
	
	
		RapperDao rapperDao = new RapperDao();
		rapperDao.insertRapper(rapper);
	
		response.sendRedirect(request.getContextPath() + "/rapperList.jsp");
		%>
	</body>
</html>