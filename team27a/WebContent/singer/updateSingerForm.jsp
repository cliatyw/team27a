<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="service.Singer" %>
<%@ page import="service.SingerDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateSingerForm.jsp</title>
	</head>
	<body>
		<%
		SingerDao dao = new SingerDao();
		Singer singer = new Singer();
		singer = dao.selectSingerOne(Integer.parseInt(request.getParameter("singerId")));
		%>
		<h1>수정 화면</h1>
			<form action="<%= request.getContextPath() %>/singer/updateSingerAction.jsp" method="post">
				<input type ="hidden" name="singerId" value=<%= singer.getSingerId() %>>
				<table border="1">
					<tr>
						<td>가수 이름</td>
						<td><input type="text" name="singerName" value=<%= singer.getSingerName() %>></td>
					</tr>
					<tr>
						<td>가수 나이</td>
						<td><input type="text" name="singerAge" value=<%= singer.getSingerAge() %>></td>
					</tr>
				</table>
				<input type="submit" value="수정">
			</form>	
	</body>
</html>