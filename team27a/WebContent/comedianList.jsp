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
	<title>Insert title here</title>
	</head>
	<body>
		<%
		ComedianDao comedianDao = new ComedianDao();
		ArrayList<Comedian> list = comedianDao.selectComedianList();
		%>
		<h1>코메디언 목록</h1>
		<a href="<%= request.getContextPath() %>/insertComedianForm.jsp">등록</a>
		<table border="1">
			<thead>
				<td>코메디언 순서</td>
				<td>코메디언 이름</td>
				<td>코메디언 나이</td>
<!-- 				<td>수정</td>
				<td>삭제</td> -->
			</thead>
			<tbody>
				<%
				for(Comedian comedian : list){
				%>
					<tr>
						<td><%= comedian.getComedianId() %></td>
						<td><%= comedian.getComedianName() %></td>
						<td><%= comedian.getComedianAge() %></td>
						<%-- <td><a href="<%= request.getContextPath() %>/updateComedianForm.jsp">수정</a></td>
						<td><a href="<%= request.getContextPath() %>/deleteComedianAction.jsp">삭제</a></td> --%>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="index.jsp">홈으로</a>
	</body>
<html>