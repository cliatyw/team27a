<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Rapper" %>
<%@ page import = "service.RapperDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> updateRapperAction.jsp </title>
	</head>
	<body>
		<%
		Rapper rapper = new Rapper();
		rapper.setRapperId(Integer.parseInt(request.getParameter("rapperId")));
		rapper.setRapperName(request.getParameter("rapperName"));
		rapper.setRapperAge(Integer.parseInt(request.getParameter("rapperAge")));
		RapperDao rapperdao = new RapperDao();
		rapperdao.updateRapper(rapper);
		response.sendRedirect(request.getContextPath() + "/rapper/rapperList.jsp");
		%>
	</body>
</html>