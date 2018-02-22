<!-- [������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.RapperDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="service.Rapper"%>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>rapperList</title>
	</head>
	<body>
		<h1>���� ���</h1>
		<a href="<%= request.getContextPath() %>/insertRapperForm.jsp">���</a>
		<%
			RapperDao rapperDao = new RapperDao();
			ArrayList<Rapper> arrayRapper = rapperDao.selectRapperList();
		%>
		<table border="1">
			<thead>
				<tr>
					<th>���� ����</th>
					<th>���� �̸�</th>
					<th>���� ����</th>
					<th>����</th>
					<th>����</th>
				</tr>
			</thead>
			<tbody>	
				<%
				for (Rapper rapper : arrayRapper) {
				%>
				<tr>
					<td><%=rapper.getRapperId()%></td>
					<td><%=rapper.getRapperName()%></td>
					<td><%=rapper.getRapperAge()%></td>
					<td><a href="<%=request.getContextPath()%>/index.jsp">����</a></td>
					<td><a href="<%=request.getContextPath()%>/index.jsp">����</a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<a href="index.jsp">Ȩ����</a>
	</body>
</html>

 