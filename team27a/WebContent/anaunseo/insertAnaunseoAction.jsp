<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import ="service.Anaunseo" %>
<%@ page import ="service.AnaunseoDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>insertAnaunseoAction.jsp</title>
	</head>
	<body>
		<%
		String anaunseoName = request.getParameter("anaunseoName");
		int anaunseoAge = Integer.parseInt(request.getParameter("anaunseoAge"));
		
		//form에서 받은 값을 클래스에 넣는다.
		Anaunseo anaunseo = new Anaunseo();
		anaunseo.setAnaunseoName(anaunseoName);
		anaunseo.setAnaunseoAge(anaunseoAge);
		
		//값을 넣은 클래스의 객체참조변수를 매개변수로하여 매서드를 실행시킨다.
		AnaunseoDao anaunseoDao = new AnaunseoDao();
		anaunseoDao.insertAnaunseo(anaunseo);
		
		//리스트 화면으로 돌아감
		response.sendRedirect(request.getContextPath() + "/anaunseoList.jsp");
		%>
	</body>
</html>