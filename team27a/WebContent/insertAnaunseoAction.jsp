<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import ="service.Anaunseo" %>
<%@ page import ="service.AnaunseoDao" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");	

	String anaunseoName = request.getParameter("anaunseoName");
	int anaunseoAge = Integer.parseInt(request.getParameter("anaunseoAge"));
	
	//form에서 받은 값을 클래스에 넣는다.
	Anaunseo anaunseo = new Anaunseo();
	anaunseo.setAnaunseoName(anaunseoName);
	anaunseo.setAnaunseoAge(anaunseoAge);
	
	AnaunseoDao anaunseoDao = new AnaunseoDao();
	anaunseoDao.insertAnaunseo(anaunseo);
	
	response.sendRedirect(request.getContextPath() + "/anaunseoList.jsp");
%>
</body>
</html>