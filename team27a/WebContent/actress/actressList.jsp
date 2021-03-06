<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="service.ActressDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="service.Actress" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> actressList.jsp </title>
	</head>
	<body>
		<%
		ActressDao actressDao = new ActressDao();
		ArrayList<Actress> arrayActress = actressDao.selectActressList();
		%>
		<h1>여배우 목록</h1>
		<% if(session.getAttribute("memberId") != null){ %>	
			<a href="<%=request.getContextPath()%>/actress/insertActressForm.jsp">등록</a>
		<% } %>	
		<table border="1">
			<thead>
				<tr>
					<th>여배우 순서</th>
					<th>여배우 이름</th>
					<th>여배우 나이</th>
					<% if(session.getAttribute("memberId")!= null){ %>
						<th>수정</th>
						<th>삭제</th>
					<% } %>
				</tr>				
			</thead>
			<tbody>
				<%
				for (Actress actress : arrayActress) {
				%>
					<tr>
						<td><%=actress.getActressId()%></td>
						<td><%=actress.getActressName()%></td>
						<td><%=actress.getActressAge()%></td>
						<% if(session.getAttribute("memberId") != null){ %>
							<td><a href="<%=request.getContextPath()%>/actress/updateActressForm.jsp?actressId=<%= actress.getActressId() %>">수정</a></td>
							<td><a href="<%=request.getContextPath()%>/actress/deleteActressAction.jsp?actressId=<%= actress.getActressId() %>">삭제</a></td>
						<% } %>
					</tr>			
				<%
				}
				%>
			</tbody>
		</table>
		<a href="<%=request.getContextPath()%>/index.jsp">홈으로</a>
	</body>
</html>

 