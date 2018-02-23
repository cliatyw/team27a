<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Member" %>
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
		Member member = new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
		MemberDao memberDao = new MemberDao();
		if(memberDao.loginMember(member).equals("일치")){
			session.setAttribute("memberId", member.getMemberId());
		}
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		%>
	</body>
</html>