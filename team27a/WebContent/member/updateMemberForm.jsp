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
		MemberDao memberDao = new MemberDao();
		Member member = memberDao.selectMemberOne(Integer.parseInt(request.getParameter("memberNo")));
		%>
		<h1 align="center">수정화면</h1>
		<br>
		<form action="<%= request.getContextPath() %>/member/updateMemberAction.jsp" method="post" align="center">
			<table border="1" align="center">
				<input type="hidden" name="memberNo" value="<%= member.getMemberNo() %>">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="memberId" value="<%= member.getMemberId() %>"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="memberPw" value="<%= member.getMemberPw() %>"></td>
				</tr>
			</table>
			<a href="<%= request.getContextPath() %>/index.jsp">홈으로</a>
			<input type="submit" value="수정">
		</form>
	</body>
</html>