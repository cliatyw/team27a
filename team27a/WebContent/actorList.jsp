<!-- [�赵��] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Actor" %>
<%@ page import = "service.ActorDao" %>
<%@ page import = "java.util.ArrayList" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>actorList.jsp</title>
	</head>
	<body>
		<%
		ActorDao actordao = new ActorDao();
		// list�� actor�� id,name,age�� �ǹ���
		ArrayList<Actor> list = actordao.selectActorList();
		%>	
		<h1>����� ���</h1>
		<a href = "<%= request.getContextPath() %>/insertActorForm.jsp">���</a>
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
		<% 
			for(Actor actor : list) {
		%>	
			<tbody>
				<tr>
					<td><%= actor.getActorId() %></td>
					<td><%= actor.getActorName() %></td>
					<td><%= actor.getActorAge() %></td>
					<td><a href = "<%= request.getContextPath() %>/updateActorForm.jsp?actorId=<%= actor.getActorId() %>">����</a></td>
					<td><a href = "<%= request.getContextPath() %>/deleteActorAction.jsp?actorId=<%= actor.getActorId() %>">����</a></td>
				</tr>
			</tbody>	
		<%
			}
		%>
		</table>
		<a href = "index.jsp">Ȩ����</a>
	</body>
</html>