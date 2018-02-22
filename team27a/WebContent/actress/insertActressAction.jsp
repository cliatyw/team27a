<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import ="service.Actress" %>
<%@ page import ="service.ActressDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> insertActressAction.jsp </title>
	</head>
	<body>
		<%			
		String actressName = request.getParameter("actressName");
		int actressAge = Integer.parseInt(request.getParameter("actressAge"));
			
		Actress actress = new Actress();	
		actress.setActressName(actressName);
		actress.setActressAge(actressAge);
				
		ActressDao actressDao = new ActressDao();
		actressDao.insertActress(actress);
				
		response.sendRedirect(request.getContextPath() + "/actress/actressList.jsp");
		%>	
	</body>
</html>
 
