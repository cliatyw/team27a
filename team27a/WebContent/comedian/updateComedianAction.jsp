<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		Comedian comedian = new Comedian();
		comedian.setComedianId(Integer.parseInt(request.getParameter("comedianId")));
		comedian.setComedianName(request.getParameter("comedianName"));
		comedian.setComedianAge(Integer.parseInt(request.getParameter("comedianAge")));
		ComedianDao comedianDao = new ComedianDao();
		comedianDao.updateComedian(comedian);
		response.sendRedirect(request.getContextPath() + "/comedian/comedianList.jsp");
		%>
	</body>
</html>