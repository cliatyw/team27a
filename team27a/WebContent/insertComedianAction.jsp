<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("euc-kr");
		/* 
		아무것도 안쳤을때는 그냥 리스트로 돌아가게하기. 경고창을 띄우고 싶었지만 자바스크립트를 안배운 관계로....
		그리고 비밀번호에 문자 못쓰게 하고싶다. 
		*/
		if(!request.getParameter("comedianName").equals("") && !request.getParameter("comedianAge").equals("")){
			Comedian comedian = new Comedian();
			ComedianDao comedianDao = new ComedianDao();
			comedian.setComedianName(request.getParameter("comedianName"));
			comedian.setComedianAge(Integer.parseInt(request.getParameter("comedianAge")));
			comedianDao.insertComedian(comedian);
		}
		response.sendRedirect(request.getContextPath() + "/comedianList.jsp");
		
		%>
	</body>
</html>