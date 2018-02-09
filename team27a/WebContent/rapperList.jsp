<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Rapper" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.RapperDao" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("euc-kr");
	
		ArrayList<Rapper> array = null;
		RapperDao rapperDao = new RapperDao();
	%>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
		</tr>
	<%
		array = rapperDao.selectRapperList();
		for(Rapper rapper : array){
	%>
		<tr>
			<td><%= rapper.getRapperId() %></td>
			<td><%= rapper.getRapperName() %></td>
			<td><%= rapper.getRapperAge() %></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>