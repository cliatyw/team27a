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
	<table border="1">
		<tr>
			<th>���̵�</th>
			<th>�̸�</th>
			<th>����</th>
		</tr>
		<%
			ActorDao actordao = new ActorDao();
			// list�� actor�� id,name,age�� �ǹ���
			ArrayList<Actor> list = actordao.selectActorList();
		
			for(Actor actor : list) {
		%>	
				<tr>
					<td><%=actor.getActorId() %></td>
					<td><%=actor.getActorName() %></td>
					<td><%=actor.getActorAge()%></td>
				</tr>
		<%
			}
		%>
	</table>
</body>
</html>