<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		/* updateComedian메서드를 호출하기 위해 매개변수로 필요한 comedian객체를 생성한다. */
		Comedian comedian = new Comedian();
		/* post방식으로 받은 comedian의 정보들을 comedian객체에 setting한다. */
		comedian.setComedianId(Integer.parseInt(request.getParameter("comedianId")));
		comedian.setComedianName(request.getParameter("comedianName"));
		comedian.setComedianAge(Integer.parseInt(request.getParameter("comedianAge")));
		
		ComedianDao comedianDao = new ComedianDao();
		/* comedianDao객체의 updateComedian메서드를 호출한다.
		매개변수는 위에서 setting해놓은 comedian을 보낸다. */
		comedianDao.updateComedian(comedian);
		response.sendRedirect(request.getContextPath() + "/comedian/comedianList.jsp");
		%>
	</body>
</html>