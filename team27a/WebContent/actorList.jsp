<!-- [�赵��] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Actor" %>
<%@ page import = "service.ActorDao" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>actorList.jsp</title>
</head>
<body>
	<%
	request.setCharacterEncoding("euc-kr");
	ActorDao actordao = new ActorDao();
	// list�� actor�� id,name,age�� �ǹ���
	ArrayList<Actor> list = actordao.selectActorList();
	%>	
	<h1>����� ���</h1>
	<a href="<%=request.getContextPath()%>/insertActorForm.jsp">���</a>
	<table border="1">
		<tr>
			<th>����� ����</th>
			<th>����� �̸�</th>
			<th>����� ����</th>
		</tr>
	<% 
		for(Actor actor : list) {
	%>	
			<tr>
				<td><%=actor.getActorId()%></td>
				<td><%=actor.getActorName()%></td>
				<td><%=actor.getActorAge()%></td>
			</tr>
	<%
		}
	%>
	</table>
	<a href="index.jsp">Ȩ����</a>
</body>
</html>