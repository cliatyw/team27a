<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Actor" %>
<%@ page import = "service.ActorDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateActorAction.jsp</title>
	</head>
	<body>
		<%		
		//받아온 Id,Name,Age의 값을 세팅해준다 
		Actor actor = new Actor();
		actor.setActorId(Integer.parseInt(request.getParameter("actorId")));
		actor.setActorName(request.getParameter("actorName"));
		actor.setActorAge(Integer.parseInt(request.getParameter("actorAge")));
		
		ActorDao actordao = new ActorDao();
		actordao.updateActor(actor);
		//actorList화면으로 넘어간다
		response.sendRedirect(request.getContextPath()+"/actor/actorList.jsp");
		%>
	</body>
</html>