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
		member.setMemberNo(Integer.parseInt(request.getParameter("memberNo")));
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
		MemberDao memberDao = new MemberDao();
		memberDao.updateMember(member);
		response.sendRedirect(request.getContextPath() + "/member/memberList.jsp");
		%>
	</body>
</html>