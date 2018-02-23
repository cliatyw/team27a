<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.MemberDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		MemberDao memberDao = new MemberDao();
		memberDao.deleteMember(Integer.parseInt(request.getParameter("memberNo")));
		response.sendRedirect(request.getContextPath() + "/member/memberList.jsp");
		%>
	</body>
</html>