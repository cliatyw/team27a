<!-- [�����] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Comedian" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>comedianList.jsp</title>
	</head>
	<body>
		<%
		ComedianDao comedianDao = new ComedianDao();
		ArrayList<Comedian> list = comedianDao.selectComedianList();
		%>
		<h1>�ڸ޵�� ���</h1>
		<a href="<%= request.getContextPath() %>/comedian/insertComedianForm.jsp">���</a>
		<table border="1">
			<thead>
				<tr>
					<th>�ڸ޵�� ����</th>
					<th>�ڸ޵�� �̸�</th>
					<th>�ڸ޵�� ����</th>
					<th>����</th>
					<th>����</th>
				</tr>
			</thead>
			<tbody>
				<%
				for(Comedian comedian : list){
				%>
					<tr>
						<td><%= comedian.getComedianId() %></td>
						<td><%= comedian.getComedianName() %></td>
						<td><%= comedian.getComedianAge() %></td>
						<td><a href="<%= request.getContextPath() %>/comedian/updateComedianForm.jsp?comedianId=<%= comedian.getComedianId() %>">����</a></td>
						<td><a href="<%= request.getContextPath() %>/comedian/deleteComedianAction.jsp?comedianId=<%= comedian.getComedianId() %>">����</a></td>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="<%= request.getContextPath() %>/index.jsp">Ȩ����</a>
	</body>
</html>