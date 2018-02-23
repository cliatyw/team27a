<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="service.AnaunseoDao" %>
<%@ page import="service.Anaunseo" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateAnaunseoForm.jsp</title>
	</head>
	<body>
		<%
		AnaunseoDao anaunseoDao = new AnaunseoDao();
		Anaunseo anaunseo = new Anaunseo();
		//id값을 받아 해당하는 이름과 나이를 input에 넣고 수정하면 updateAnaunseoAction.jsp 로 값들을 보낸다.
		anaunseo = anaunseoDao.selectAnaunseoOne(Integer.parseInt(request.getParameter("anaunseoId")));
		%>
		<h1>수정 화면</h1>
		<form action="<%= request.getContextPath() %>/anaunseo/updateAnaunseoAction.jsp" method="post">
			<!-- 화면에 표시하지 않고 아이디값을 updateAnaunseoAction으로 넘기기 위해 hidden을 사용하였다. -->
			<input type ="hidden" name="anaunseoId" value=<%= anaunseo.getAnaunseoId() %>>
			<table border="1">
				<tr>
					<td>아나운서 이름</td>
					<td><input type="text" name="anaunseoName" value=<%= anaunseo.getAnaunseoName() %>></td>
				</tr>
				<tr>
					<td>아나운서 나이</td>
					<td><input type="text" name="anaunseoAge" value=<%= anaunseo.getAnaunseoAge() %>></td>
				</tr>
			</table>
			<input type="submit" value="수정">
		</form>	
	</body>
</html>