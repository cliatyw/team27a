<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.AnaunseoDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>deleteAnaunseoAction.jsp</title>
	</head>
	<body>
		<%
		AnaunseoDao anaunseoDao = new AnaunseoDao();
		//anaunseoId를 get방식으로 받아 int형식으로 변환후 매서드르를 실행시킨다.
		anaunseoDao.deleteAnaunseo(Integer.parseInt(request.getParameter("anaunseoId")));

		response.sendRedirect(request.getContextPath() + "/anaunseo/anaunseoList.jsp");
		%>
	</body>
</html>