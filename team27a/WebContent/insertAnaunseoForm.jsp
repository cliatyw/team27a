<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��� ȭ��</h1>
	<form action="<%= request.getContextPath() %>/insertAnaunseoAction.jsp">
		<table border="1">
			<tr>
				<td>�Ƴ�� �̸�</td>
				<td><input type="text" name="anaunseoName"></td>
			</tr>
			<tr>
				<td>�Ƴ�� ����</td>
				<td><input type="text" name="anaunseoAge"></td>
			</tr>
		</table>
		<input type="submit" value="���">
	</form>	
</body>
</html>