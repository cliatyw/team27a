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
		<!-- memberId세션값을 가져와 null이 아닐경우 즉,로그인이 된경우 등록이 뜨게 된다 -->
		<%
		if (session.getAttribute("memberId") != null) {
		%>
		<a href = "<%= request.getContextPath() %>/actor/insertActorForm.jsp">등록</a>
		<%
		}
		%>
		<table border="1">
			<thead>
				<tr>
					<th>남배우 순서</th>
					<th>남배우 이름</th>
					<th>남배우 나이</th>
		<!-- memberId세션값을 가져와 null이 아닐경우 즉,로그인이 된경우 수정,삭제가 뜨게 된다 -->
		<%
		if (session.getAttribute("memberId") != null) {
		%>
					<th>수정</th>
					<th>삭제</th>
				</tr>
		<%
		}
		%>	
			</thead>
			<tbody>
			<% 
			for(Actor actor : list) {
			%>			
				<tr>
					<td><%= actor.getActorId() %></td>
					<td><%= actor.getActorName() %></td>
					<td><%= actor.getActorAge() %></td>
				<!-- memberId세션값을 가져와 null이 아닐경우 즉,로그인이 된경우 수정,삭제가 뜨게 된다 -->
				<%
				if (session.getAttribute("memberId") != null) {
				%>
	
					<td><a href = "<%= request.getContextPath() %>/actor/updateActorForm.jsp?actorId=<%= actor.getActorId() %>">수정</a></td>
					<td><a href = "<%= request.getContextPath() %>/actor/deleteActorAction.jsp?actorId=<%= actor.getActorId() %>">삭제</a></td>
				<%
				}
				%>
				</tr>
			<% 
			}
			%>
			</tbody>	
		</table>
		<a href = "<%= request.getContextPath() %>/index.jsp">홈으로</a>
	</body>
</html>