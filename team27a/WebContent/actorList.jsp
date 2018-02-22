<!-- [김도희] -->
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
		// list는 actor의 id,name,age를 의미함
		ArrayList<Actor> list = actordao.selectActorList();
		%>	
		<h1>남배우 목록</h1>
		<a href = "<%= request.getContextPath() %>/insertActorForm.jsp">등록</a>
		<table border="1">
			<thead>
				<tr>
					<th>남배우 순서</th>
					<th>남배우 이름</th>
					<th>남배우 나이</th>
					<th>수정</th>
					<th>삭제</th>
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
					<td><a href = "<%= request.getContextPath() %>/updateActorForm.jsp?actorId=<%= actor.getActorId() %>">수정</a></td>
					<td><a href = "<%= request.getContextPath() %>/deleteActorAction.jsp?actorId=<%= actor.getActorId() %>">삭제</a></td>
				</tr>
			</tbody>	
		<%
			}
		%>
		</table>
		<a href = "index.jsp">홈으로</a>
	</body>
</html>