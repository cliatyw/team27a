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
	<title>Insert title here</title>
	</head>
	<body>
		<%
		ComedianDao comedianDao = new ComedianDao();
		ArrayList<Comedian> list = comedianDao.selectComedianList();
		%>
		<h1>�ڸ޵�� ���</h1>
		<a href="<%= request.getContextPath() %>/insertComedianForm.jsp">���</a>
		<table border="1">
			<thead>
				<td>�ڸ޵�� ����</td>
				<td>�ڸ޵�� �̸�</td>
				<td>�ڸ޵�� ����</td>
<!-- 				<td>����</td>
				<td>����</td> -->
			</thead>
			<tbody>
				<%
				for(Comedian comedian : list){
				%>
					<tr>
						<td><%= comedian.getComedianId() %></td>
						<td><%= comedian.getComedianName() %></td>
						<td><%= comedian.getComedianAge() %></td>
						<%-- <td><a href="<%= request.getContextPath() %>/updateComedianForm.jsp">����</a></td>
						<td><a href="<%= request.getContextPath() %>/deleteComedianAction.jsp">����</a></td> --%>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="index.jsp">Ȩ����</a>
	</body>
<html>