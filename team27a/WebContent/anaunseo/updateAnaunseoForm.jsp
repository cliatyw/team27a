<!-- [��⼺] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="service.AnaunseoDao" %>
<%@ page import="service.Anaunseo" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateAnaunseoForm.jsp</title>
	</head>
	<body>
		<%
		AnaunseoDao anaunseoDao = new AnaunseoDao();
		Anaunseo anaunseo = new Anaunseo();
		anaunseo = anaunseoDao.selectAnaunseoOne(Integer.parseInt(request.getParameter("anaunseoId")));
		%>
		<h1>���� ȭ��</h1>
		<form action="<%= request.getContextPath() %>/updateAnaunseoAction.jsp" method="post">
			<table border="1">
				<tr>
					<td>�Ƴ�� �̸�</td>
					<td><input type="text" name="anaunseoName" value=<%= anaunseo.getAnaunseoName() %>></td>
				</tr>
				<tr>
					<td>�Ƴ�� ����</td>
					<td><input type="text" name="anaunseoAge" value=<%= anaunseo.getAnaunseoAge() %>></td>
				</tr>
			</table>
			<input type="submit" value="����">
		</form>	
	</body>
</html>