<!-- [������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="service.ActressDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="service.Actress" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> actressList.jsp </title>
	</head>
	<body>
		<%
		ActressDao actressDao = new ActressDao();
		ArrayList<Actress> arrayActress = actressDao.selectActressList();
		%>
		<h1>���� ���</h1>	
		<a href="<%=request.getContextPath()%>/actress/insertActressForm.jsp">���</a>
		<table border="1">
			<thead>
				<tr>
					<th>����� ����</th>
					<th>����� �̸�</th>
					<th>����� ����</th>
					<th>����</th>
					<th>����</th>
				</tr>				
			</thead>
			<tbody>
				<%
				for (Actress actress : arrayActress) {
				%>
					<tr>
						<td><%=actress.getActressId()%></td>
						<td><%=actress.getActressName()%></td>
						<td><%=actress.getActressAge()%></td>
						<td><a href="<%=request.getContextPath()%>/index.jsp">����</a></td>
						<td><a href="<%=request.getContextPath()%>/actress/deleteActressAction.jsp?actressId=<%= actress.getActressId() %>">����</a></td>
					</tr>			
				<%
				}
				%>
			</tbody>
		</table>
		<a href="<%=request.getContextPath()%>/index.jsp">Ȩ����</a>
	</body>
</html>

 