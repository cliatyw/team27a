<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import ="service.Anaunseo" %>
<%@ page import ="service.AnaunseoDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateAnaunseoAction.jsp</title>
	</head>
	<body>
		<%
		AnaunseoDao anaunseoDao = new AnaunseoDao();
		Anaunseo anaunseo = new Anaunseo();
		anaunseo.setAnaunseoId(Integer.parseInt(request.getParameter("anaunseoId")));
		anaunseo.setAnaunseoName(request.getParameter("anaunseoName"));
		anaunseo.setAnaunseoAge(Integer.parseInt(request.getParameter("anaunseoAge")));
		anaunseoDao.updateAnaunseo(anaunseo);
		
		response.sendRedirect(request.getContextPath() + "/anaunseo/anaunseoList.jsp");
		%>
	</body>
</html>