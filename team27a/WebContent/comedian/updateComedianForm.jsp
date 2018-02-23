<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateComedianForm.jsp</title>
	</head>
	<body>
		<%
		ComedianDao comedianDao = new ComedianDao();
		Comedian comedian = comedianDao.selectComedianOne(Integer.parseInt(request.getParameter("comedianId")));
		%>
		<h1>수정 화면</h1>
		<form action="<%= request.getContextPath() %>/comedian/updateComedianAction.jsp" method="post">
			<input type ="hidden" name="comedianId" value=<%= comedian.getComedianId() %>>
			<table border="1">
				<tr>
					<td>코미디언 이름</td>
					<td><input type="text" name="comedianName" value=<%= comedian.getComedianName() %>></td>
				</tr>
				<tr>
					<td>코미디언 나이</td>
					<td><input type="text" name="comedianAge" value=<%= comedian.getComedianAge() %>></td>
				</tr>
			</table>
			<input type="submit" value="수정">
		</form>	
	</body>
</html>