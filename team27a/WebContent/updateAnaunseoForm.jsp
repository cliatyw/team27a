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
		<h1>���� ȭ��</h1>
		<form action="<%= request.getContextPath() %>/updateAnaunseoAction.jsp" method="post">
			<table border="1">
				<tr>
					<td>�Ƴ�� �̸�</td>
					<td><input type="text" name="anaunseoName" value=""></td>
				</tr>
				<tr>
					<td>�Ƴ�� ����</td>
					<td><input type="text" name="anaunseoAge" value=""></td>
				</tr>
			</table>
			<input type="submit" value="����">
		</form>	
	</body>
</html>