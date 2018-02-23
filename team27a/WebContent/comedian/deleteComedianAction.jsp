<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.ComedianDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>deleteComedianAction.jsp</title>
	</head>
	<body>
		<%
		ComedianDao comedianDao = new ComedianDao();
		/* comedianDao객체의 deleteCoemdian메서드를 호출한다.
		그러기 위해선 매개변수로 int형변수 하나를 보내야 하기 때문에, String 형으로 받은 값을 parseInt메서드로 형변환
		시켜줘서 호출한다. */
		comedianDao.deleteComedian(Integer.parseInt(request.getParameter("comedianId")));
		/* 지운다음 제대로 지워졌는지 확인하기위해 다시 리스트로 복귀한다. */
		response.sendRedirect(request.getContextPath() + "/comedian/comedianList.jsp");
		%>
	</body>
</html>