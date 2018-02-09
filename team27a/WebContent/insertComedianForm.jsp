<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<% request.setCharacterEncoding("euc-kr"); %>
		<h1>등록 화면</h1>
		<form action="<%= request.getContextPath() %>/insertComedianAction.jsp" method="post">
			<table border="1">
				<tr>
					<td>코메디언 이름</td>
					<td><input type="text" name="comedianName"></td>
				</tr>
				<tr>
					<td>코메디언 나이</td>
					<td><input type="text" name="comedianAge"></td>
				</tr>
			</table>
			<input type="submit" value="등록">
		</form>	
	</body>
</html>