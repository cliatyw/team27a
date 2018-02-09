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

	for(Actor a : arrayActor){
		
		Actor b = a;
		//Actor b = arrayActor.get(0);
		//Actor b = arrayActor.get(1);
%>	

		<!-- Actor b의 Id,name,Age 화면 출력 -->	
		<tr>
		<td><%=b.getActorId() %></td>
		<td><%=b.getActorName() %></td>
		<td><%=b.getActorAge()%></td>
		</tr>
<%} %>
	
	</table>
</body>
</html>