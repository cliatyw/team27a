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
		//form에서 받은 값들을 anaunseo 객체에 셋팅한다.
		anaunseo.setAnaunseoId(Integer.parseInt(request.getParameter("anaunseoId")));
		anaunseo.setAnaunseoName(request.getParameter("anaunseoName"));
		anaunseo.setAnaunseoAge(Integer.parseInt(request.getParameter("anaunseoAge")));
		//셋팅한 객체를 매개변수로 하여 updateAnaunseo매서드를 실행한다.
		anaunseoDao.updateAnaunseo(anaunseo);
		
		response.sendRedirect(request.getContextPath() + "/anaunseo/anaunseoList.jsp");
		%>
	</body>
</html>