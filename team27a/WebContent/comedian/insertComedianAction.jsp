<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>insertComedianAction.jsp</title>
	</head>
	<body>
		<%
		/*아무것도 입력하지 않았을때는 홈으로 돌아간다. 
		경고창을 띄우고 싶었지만 자바스크립트를 안배운 관계로....
		*/
		if(!request.getParameter("comedianName").equals("") && !request.getParameter("comedianAge").equals("")){
			Comedian comedian = new Comedian();
			ComedianDao comedianDao = new ComedianDao();
			/* 받은 데이터를 바로 객체에 셋팅하고 인서트 메서드 실행! 
			나중에는 이를 이용하여, result값을 받아서 입력에 성공했다,
			혹은 실패했다를 출력해주고 싶다~
			*/
			comedian.setComedianName(request.getParameter("comedianName"));
			comedian.setComedianAge(Integer.parseInt(request.getParameter("comedianAge")));
			comedianDao.insertComedian(comedian);
		}
		response.sendRedirect(request.getContextPath() + "/comedian/comedianList.jsp");
		%>
	</body>
</html>