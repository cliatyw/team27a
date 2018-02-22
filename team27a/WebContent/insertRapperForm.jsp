<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> insertRapperForm.jsp </title>
	</head>
	<body>
		<h1>등록 화면</h1>
		<form action="<%= request.getContextPath() %>/insertRapperAction.jsp" method="post">
			<table border="1">
				<tr>
					<td>래퍼 이름</td>
					<td><input type="text" name="rapperName"></td>
				</tr>
				<tr>
					<td>래퍼 나이</td>
					<td><input type="text" name="rapperAge"></td>
				</tr>
			</table>
			<input type="submit" value="등록">
		</form>	
	</body>
</html>