<!-- [김도희] -->
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
	<%  //입력창에서 getParameter로 한글값을 받을때 한글깨짐을 막아줌
		request.setCharacterEncoding("euc-kr");	
		//화면에서 입력한 값을 받아옴
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