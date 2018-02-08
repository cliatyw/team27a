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

for(int i=0;i<arrayActor.size();i++){
	Actor actor = arrayActor.get(i);
%>	
	<tr>
	<td><%=actor.getActorId() %></td>
	<td><%=actor.getActorName() %></td>
	<td><%=actor.getActorAge()%></td>
	</tr>
<%} %>
	
</table>
</body>
</html>