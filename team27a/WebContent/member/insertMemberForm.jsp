<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<h1 align="center">회원가입</h1>
		<br>
		<form action="<%= request.getContextPath() %>/member/insertMemberAction.jsp" method="post" align="center">
			<table border="1" align="center">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="memberId"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="memberPw"></td>
				</tr>
			</table>
			<a href="<%= request.getContextPath() %>/index.jsp">홈으로</a>
			<input type="submit" value="가입">
		</form>
	</body>
</html>