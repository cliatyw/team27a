<!-- [������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="service.RapperDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="service.Rapper"%>
<!DOCTYPE html>
<html>
	<head>
	
	</head>
	<%
		request.setCharacterEncoding("euc-kr");
		RapperDao rapperDao = new RapperDao();
		ArrayList<Rapper> arrayRapper = rapperDao.selectRapperList();
	%>
	<body>
		<h1>���� ���</h1>
		<a href="http://naver.com">���</a>
		<table border="1">
			<tr>
				<td>���� ����</td>
				<td>���� �̸�</td>
				<td>���� ����</td>
			</tr>
			<%
				for (Rapper rapper : arrayRapper) {
			%>
			<tr>
				<td><%=rapper.getRapperId()%></td>
				<td><%=rapper.getRapperName()%></td>
				<td><%=rapper.getRapperAge()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<a href="index.jsp">Ȩ����</a>
	</body>
</html>

 