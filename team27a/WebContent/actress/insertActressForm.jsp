<!-- [������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> insertActressFrom.jsp </title>
	</head>
	<body>
		<h1>��� ȭ��</h1>
		<form action="<%= request.getContextPath() %>/actress/insertActressAction.jsp" method="post">
			<table border="1">
				<tr>
					<td>����� �̸�</td>
					<td><input type="text" name="actressName"></td>
				</tr>
				<tr>
					<td>����� ����</td>
					<td><input type="text" name="actressAge"></td>
				</tr>
			</table>
			<input type="submit" value="���">
		</form>	
	</body>
</html>