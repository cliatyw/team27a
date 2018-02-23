<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.ActorDao" %>
<%@ page import = "service.Actor" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateActorForm.jsp</title>
	</head>
	<body>
		<%		
		ActorDao actordao = new ActorDao();
		Actor actor = actordao.selectActorOne(Integer.parseInt(request.getParameter("actorId")));
		%>
		<h1>수정 화면</h1>
		<form action="<%= request.getContextPath() %>/actor/updateActorAction.jsp" method="post">
			<input type ="hidden" name="actorId" value=<%= actor.getActorId() %>>
			<table border="1">
				<tr>
					<td>남배우 이름</td>
					<td><input type="text" name="actorName" value="<%=actor.getActorName()%>"></td>
				</tr>
				<tr>
					<td>남배우 나이</td>
					<td><input type="text" name="actorAge" value="<%=actor.getActorAge()%>"></td>
				</tr>
			</table>
			<input type="submit" value="수정">
		</form>	
	</body>
</html>