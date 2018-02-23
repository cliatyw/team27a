<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Member" %>
<%@ page import = "service.MemberDao" %>
<%@ page import = "java.util.ArrayList" %>
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
		ArrayList<Member> list = memberDao.selectMemberAll();
		%>
		<h1  align="center">멤버 목록</h1>
		<table border="1" align="center">
			<thead>
				<tr>
					<th>멤버 순서</th>
					<th>멤버 이름</th>
					<th>멤버 나이</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<%
				for(Member member : list){
				%>
					<tr>
						<td><%= member.getMemberNo() %></td>
						<td><%= member.getMemberId() %></td>
						<td><%= member.getMemberPw() %></td>
						<td><a href="<%= request.getContextPath() %>/member/updateMemberForm.jsp?memberNo=<%= member.getMemberNo() %>">수정</a></td>
						<td><a href="<%= request.getContextPath() %>/member/deleteMemberAction.jsp?memberNo=<%= member.getMemberNo() %>">삭제</a></td>
					</tr>
				<%
				}
				%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5" align="center"><a href="<%= request.getContextPath() %>/index.jsp">홈으로</a><td>
				</tr>
			</tfoot>
		</table>
	</body>
</html>