<!-- [�ֻ��] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="service.Singer" %>
<%@ page import="service.SingerDao" %>
<%@ page import="java.util.ArrayList" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>singerList.jsp</title>
	</head>
	<body>
		<%
		SingerDao singerdao = new SingerDao();
		ArrayList<Singer> list = singerdao.selectSingerList();
		%>
		<h1>���� ���</h1>
		<%
		if(session.getAttribute("memberId") != null){	
		%>
			<a href = "<%= request.getContextPath() %>/singer/insertSingerForm.jsp">���</a>
		<%
		}
		%>
		<table border = "1">
			<thead>
				<tr>
					<th>���� ����</th>
					<th>���� �̸�</th>
					<th>���� ����</th>
					<%
					//session�� ���̵��� �ִٸ� ���� ���� ���̺� ���� Ȱ��ȭ
					if(session.getAttribute("memberId") != null){
					%>
						<th>����</th>
						<th>����</th>
					<%
					}
					%>
				</tr>
			</thead>	
			<tbody>			
				<%				
				for(Singer singer : list){			
				%>
					<tr>
						<td><%= singer.getSingerId() %></td>
						<td><%= singer.getSingerName() %></td>
						<td><%= singer.getSingerAge() %></td>
						<%
						//session�� ���̵��� �ִٸ� ����, ������ư Ȱ��ȭ
						if(session.getAttribute("memberId") != null){
						%>
						<td><a href = "<%= request.getContextPath() %>/singer/updateSingerForm.jsp?singerId=<%= singer.getSingerId() %>">����</a></td>
						<td><a href = "<%= request.getContextPath() %>/singer/deleteSingerAction.jsp?singerId=<%= singer.getSingerId() %>">����</a></td>
						<%
						}
						%>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="<%= request.getContextPath() %>/index.jsp">Ȩ����</a>
	</body>
</html>