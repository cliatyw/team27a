<!-- [��⼺] -->
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
		//anaunseoId�� get������� �޾� int�������� ��ȯ�� �ż��帣�� �����Ų��.
		anaunseoDao.deleteAnaunseo(Integer.parseInt(request.getParameter("anaunseoId")));

		response.sendRedirect(request.getContextPath() + "/anaunseo/anaunseoList.jsp");
		%>
	</body>
</html>