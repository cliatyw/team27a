<!-- [�赵��] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Actor" %>
<%@ page import = "service.ActorDao" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>insertActorAction.jsp</title>
</head>
<body>
	<%  //�Է�â���� getParameter�� �ѱ۰��� ������ �ѱ۱����� ������
		request.setCharacterEncoding("euc-kr");	
		//ȭ�鿡�� �Է��� ���� �޾ƿ�
		String actorName = request.getParameter("actorName");
		int actorAge = Integer.parseInt(request.getParameter("actorAge"));
		System.out.println(actorName);
		System.out.println(actorAge);
		
		Actor actor = new Actor();
		actor.setActorName(actorName);
		actor.setActorAge(actorAge);
		
		ActorDao actorDao = new ActorDao();
		actorDao.insertActor(actor);
		response.sendRedirect(request.getContextPath()+"/actorList.jsp");
	%>
</body>
</html>