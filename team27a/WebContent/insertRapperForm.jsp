<!-- [������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��� ȭ��</h1>
	<form action="<%= request.getContextPath() %>/insertRapperAction.jsp" method="post">
		<table border="1">
			<tr>
				<td>���� �̸�</td>
				<td><input type="text" name="rapperName"></td>
			</tr>
			<tr>
				<td>���� ����</td>
				<td><input type="text" name="rapperAge"></td>
			</tr>
		</table>
		<input type="submit" value="���">
	</form>	
</body>
</html>