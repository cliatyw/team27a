<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="service.Singer" %>
<%@ page import="service.SingerDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateSingerAction.jsp</title>
	</head>
	<body>
		<%
		Singer singer = new Singer();
		SingerDao dao = new SingerDao();
		//업데이트 폼에서 가져온 값을 int와 string형으로 바꿔서 값을 세팅해줌.
		singer.setSingerId(Integer.parseInt(request.getParameter("singerId")));
		singer.setSingerName(request.getParameter("singerName"));
		singer.setSingerAge(Integer.parseInt(request.getParameter("singerAge")));
		dao.updateSinger(singer);
		response.sendRedirect(request.getContextPath() + "/singer/singerList.jsp");
		%>
	</body>
</html>