<!-- [������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="service.ActressDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="service.Actress"%>
<!DOCTYPE html>
<html>
	<head>
	
	</head>
	<%
		request.setCharacterEncoding("euc-kr");
		ActressDao actressDao = new ActressDao();
		ArrayList<Actress> arrayActress = actressDao.selectActressList();
	%>
	<body>
		<h1>���� ���</h1>
		<a href="http://naver.com">���</a>
		<table border="1">
			<tr>
				<td>����� ����</td>
				<td>����� �̸�</td>
				<td>����� ����</td>
			</tr>
			<%
				for (Actress actress : arrayActress) {
			%>
			<tr>
				<td><%=actress.getActressId()%></td>
				<td><%=actress.getActressName()%></td>
				<td><%=actress.getActressAge()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<a href="index.jsp">Ȩ����</a>
	</body>
</html>

 