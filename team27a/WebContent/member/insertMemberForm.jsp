<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<h1 align="center">ȸ������</h1>
		<br>
		<form action="<%= request.getContextPath() %>/member/insertMemberAction.jsp" method="post" align="center">
			<table border="1" align="center">
				<tr>
					<td>���̵�</td>
					<td><input type="text" name="memberId"></td>
				</tr>
				<tr>
					<td>��й�ȣ</td>
					<td><input type="text" name="memberPw"></td>
				</tr>
			</table>
			<a href="<%= request.getContextPath() %>/index.jsp">Ȩ����</a>
			<input type="submit" value="����">
		</form>
	</body>
</html>