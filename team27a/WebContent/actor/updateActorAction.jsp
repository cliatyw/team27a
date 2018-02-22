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
		int actorId = Integer.parseInt(request.getParameter("actorId"));
		System.out.println("updateActorAction.actorId:"+actorId);
		
		String actorName = request.getParameter("actorName");
		System.out.println("updateActorAction.actorName:"+actorName);
		
		int actorAge = Integer.parseInt(request.getParameter("actorAge"));
		System.out.println("updateActorAction.actorAge:"+actorAge);
		
		Actor actor = new Actor();
		actor.setActorId(actorId);
		actor.setActorName(actorName);
		actor.setActorAge(actorAge);
		
		ActorDao actordao = new ActorDao();
		actordao.UpdateActor(actor);
		
		response.sendRedirect(request.getContextPath()+"/actor/actorList.jsp");
		%>
	</body>
</html>