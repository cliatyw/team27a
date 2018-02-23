<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Actress" %>
<%@ page import = "service.ActressDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> insertActressForm.jsp </title>
	</head>
	<body>
		<%
		ActressDao actressDao = new ActressDao();
		Actress actress = actressDao.selectActressOne(Integer.parseInt(request.getParameter("actressId")));
		%>
		<h1>수정 화면</h1>
		<form action="<%= request.getContextPath() %>/actress/updateActressAction.jsp" method="post">
			<input type = "hidden" name="actressId" value=<%= actress.getActressId() %>>
			<table border="1">
				<tr>
					<td>여배우 이름</td>
					<td><input type="text" name="actressName" value=<%= actress.getActressName() %>></td>
				</tr>
				<tr>
					<td>여배우 나이</td>
					<td><input type="text" name="actressAge" value=<%= actress.getActressAge() %>></td>
				</tr>
			</table>
			<input type="submit" value="수정">
		</form>
	</body>
</html>