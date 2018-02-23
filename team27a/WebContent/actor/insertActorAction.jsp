<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Actor" %>
<%@ page import = "service.ActorDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>insertActorAction.jsp</title>
	</head>
	<body>
		<%	
		//화면에서 받아온 값을 세팅해준다
		Actor actor = new Actor();
		actor.setActorName(request.getParameter("actorName"));
		actor.setActorAge(Integer.parseInt(request.getParameter("actorAge")));
		
		ActorDao actorDao = new ActorDao();
		actorDao.insertActor(actor);
		//actorList 화면으로 넘어간다
		response.sendRedirect(request.getContextPath()+"/actor/actorList.jsp");
		%>
	</body>
</html>