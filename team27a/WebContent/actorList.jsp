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
		<th>���̵�</th>
		<th>�̸�</th>
		<th>����</th>
		</tr>
<%
ActorDao actordao = new ActorDao();
ArrayList<Actor> arrayActor =actordao.selectActorList();

	for(Actor a : arrayActor){
		
		Actor b = a;
		//Actor b = arrayActor.get(0);
		//Actor b = arrayActor.get(1);
%>	

		<!-- Actor b�� Id,name,Age ȭ�� ��� -->	
		<tr>
		<td><%=b.getActorId() %></td>
		<td><%=b.getActorName() %></td>
		<td><%=b.getActorAge()%></td>
		</tr>
<%} %>
	
	</table>
</body>
</html>