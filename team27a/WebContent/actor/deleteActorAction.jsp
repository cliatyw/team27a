<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.ActorDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>deleteActorAction.jsp</title>
	</head>
	<body>
		<%		
		ActorDao actordao = new ActorDao();
		actordao.deleteActor(Integer.parseInt(request.getParameter("actorId")));
		//actorList화면으로 넘어간다
		response.sendRedirect(request.getContextPath()+"/actor/actorList.jsp");
		%>
	</body>
</html>