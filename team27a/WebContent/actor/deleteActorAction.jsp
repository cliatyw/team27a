<!-- [�赵��] -->
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
		//get������� ���۵� actorId�� ���� �޾ƿ´�.
		int actorId = Integer.parseInt(request.getParameter("actorId"));
		System.out.println("actorId:"+actorId);
		
		ActorDao actordao = new ActorDao();
		actordao.deleteActor(actorId);
		
		response.sendRedirect(request.getContextPath()+"/actorList.jsp");
		%>
	</body>
</html>