<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
		String anaunseoId = request.getParameter("anaunseoId");
		AnaunseoDao anaunseoDao = new AnaunseoDao();
		anaunseoDao.deleteAnaunseo(anaunseoId);

		response.sendRedirect(request.getContextPath() + "/anaunseoList.jsp");
	%>
</body>
</html>