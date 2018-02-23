<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Actress" %>
<%@ page import = "service.ActressDao" %>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> updateActressAction.jsp </title>
	</head>
	<body>
		<%
		Actress actress = new Actress();
		actress.setActressId(Integer.parseInt(request.getParameter("actressId")));
		actress.setActressName(request.getParameter("actressName"));
		actress.setActressAge(Integer.parseInt(request.getParameter("actressAge")));
		ActressDao actressdao = new ActressDao();
		actressdao.updateActress(actress);
		response.sendRedirect(request.getContextPath() + "/actress/actressList.jsp");
		%>
	</body>
</html>