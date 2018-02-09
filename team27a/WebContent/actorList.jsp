<!-- 김도희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "service.Actor" %>
<%@ page import = "service.ActorDao" %>
<%@ page import = "java.util.ArrayList" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
		</tr>
<%
ActorDao actordao = new ActorDao();
ArrayList<Actor> arrayActor =actordao.selectActorList();

	for(Actor actor : arrayActor){
%>	

		<!-- Actor actor = actor.get(0);
			 Actor actor = actor.get(1);
			 actor의 Id,name,Age 화면 출력 -->	
		<tr>
		<td><%=actor.getActorId() %></td>
		<td><%=actor.getActorName() %></td>
		<td><%=actor.getActorAge()%></td>
		</tr>
<%} %>
	
	</table>
</body>
</html>