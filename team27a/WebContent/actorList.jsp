<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "service.Actor" %>
<%@ page import = "service.ActorDao" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
ActorDao actordao = new ActorDao();
Actor actor =actordao.selectActorList();

String Id=actor.getActorId();
String Name=actor.getActorName();
String Age=actor.getActorAge();

%>



</body>
</html>