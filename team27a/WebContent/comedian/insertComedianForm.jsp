<!-- [�����] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>insertComedianForm.jsp</title>
	</head>
	<body>
		<h1>��� ȭ��</h1>
		<form action="<%= request.getContextPath() %>/comedian/insertComedianAction.jsp" method="post">
			<table border="1">
				<tr>
					<td>�ڸ޵�� �̸�</td>
					<td><input type="text" name="comedianName"></td>
				</tr>
				<tr>
					<td>�ڸ޵�� ����</td>
					<td><input type="text" name="comedianAge"></td>
				</tr>
			</table>
			<input type="submit" value="���">
		</form>	
	</body>
</html>