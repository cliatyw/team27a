<!-- [��⼺] -->
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
		
		//form���� ���� ���� Ŭ������ �ִ´�.
		Anaunseo anaunseo = new Anaunseo();
		anaunseo.setAnaunseoName(anaunseoName);
		anaunseo.setAnaunseoAge(anaunseoAge);
		
		//���� ���� Ŭ������ ��ü���������� �Ű��������Ͽ� �ż��带 �����Ų��.
		AnaunseoDao anaunseoDao = new AnaunseoDao();
		anaunseoDao.insertAnaunseo(anaunseo);
		
		//����Ʈ ȭ������ ���ư�
		response.sendRedirect(request.getContextPath() + "/anaunseoList.jsp");
		%>
	</body>
</html>