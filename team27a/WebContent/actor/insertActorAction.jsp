<!-- [�赵��] -->
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
		//ȭ�鿡�� �޾ƿ� ���� �������ش�
		Actor actor = new Actor();
		actor.setActorName(request.getParameter("actorName"));
		actor.setActorAge(Integer.parseInt(request.getParameter("actorAge")));
		
		ActorDao actorDao = new ActorDao();
		actorDao.insertActor(actor);
		//actorList ȭ������ �Ѿ��
		response.sendRedirect(request.getContextPath()+"/actor/actorList.jsp");
		%>
	</body>
</html>