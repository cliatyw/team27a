<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Rapper" %>
<%@ page import = "service.RapperDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> updateRapperForm.jsp </title>
	</head>
	<body>
		<%
		RapperDao rapperDao = new RapperDao();
		Rapper rapper = rapperDao.selectRapperOne(Integer.parseInt(request.getParameter("rapperId")));
		%>
		<h1>수정 화면</h1>
		<form action="<%= request.getContextPath() %>/rapper/updateRapperAction.jsp" method="post">
			<input type = "hidden" name="rapperId" value=<%= rapper.getRapperId() %>>
			<table border="1">
				<tr>
					<td>래퍼 이름</td>
					<td><input type="text" name="rapperName" value=<%= rapper.getRapperName() %>></td>
				</tr>
				<tr>
					<td>래퍼 나이</td>
					<td><input type="text" name="rapperAge" value=<%= rapper.getRapperAge() %>></td>
				</tr>
			</table>
			<input type="submit" value="수정">
		</form>
	</body>
</html>