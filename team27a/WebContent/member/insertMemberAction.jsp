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
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		if( !memberId.equals("") && !memberId.equals("") ){
			Member member = new Member();
			member.setMemberId(memberId);
			member.setMemberPw(memberPw);
			MemberDao memberDao = new MemberDao();
			memberDao.insertMember(member);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else{
			response.sendRedirect(request.getContextPath() + "/login/login.jsp");
		}
		
		%>
		
	</body>
</html>