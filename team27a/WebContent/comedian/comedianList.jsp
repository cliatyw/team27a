<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Comedian" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>comedianList.jsp</title>
	</head>
	<body>
		<%
		ComedianDao comedianDao = new ComedianDao();
		ArrayList<Comedian> list = comedianDao.selectComedianList();
		%>
		<h1>코메디언 목록</h1>
		<a href="<%= request.getContextPath() %>/comedian/insertComedianForm.jsp">등록</a>
		<table border="1">
			<thead>
				<tr>
					<th>코메디언 순서</th>
					<th>코메디언 이름</th>
					<th>코메디언 나이</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<%
				for(Comedian comedian : list){
				%>
					<tr>
						<td><%= comedian.getComedianId() %></td>
						<td><%= comedian.getComedianName() %></td>
						<td><%= comedian.getComedianAge() %></td>
						<td><a href="<%= request.getContextPath() %>/comedian/updateComedianForm.jsp?comedianId=<%= comedian.getComedianId() %>">수정</a></td>
						<td><a href="<%= request.getContextPath() %>/comedian/deleteComedianAction.jsp?comedianId=<%= comedian.getComedianId() %>">삭제</a></td>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="<%= request.getContextPath() %>/index.jsp">홈으로</a>
	</body>
</html>