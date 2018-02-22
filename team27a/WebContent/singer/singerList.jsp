<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="service.Singer" %>
<%@ page import="service.SingerDao" %>
<%@ page import="java.util.ArrayList" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>singerList.jsp</title>
	</head>
	<body>
		<%
		SingerDao singerdao = new SingerDao();
		ArrayList<Singer> list = singerdao.selectSingerList();
		%>
		<h1>가수 목록</h1>
		<a href = "<%= request.getContextPath() %>/insertSingerForm.jsp">등록</a>
		<table border = "1">
			<thead>
				<tr>
					<th>가수 순서</th>
					<th>가수 이름</th>
					<th>가수 나이</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>	
			<tbody>			
				<%				
				for(Singer singer : list){			
				%>
					<tr>
						<td><%= singer.getSingerId() %></td>
						<td><%= singer.getSingerName() %></td>
						<td><%= singer.getSingerAge() %></td>
						<td><a href = "<%= request.getContextPath() %>/updateSingerForm.jsp?singerId=<%= singer.getSingerId() %>">수정</a></td>
						<td><a href = "<%= request.getContextPath() %>/deleteSingerAction.jsp?singerId=<%= singer.getSingerId() %>">삭제</a></td>
					</tr>
				<%		
				}
				%>	
			</tbody>		
		</table>
		<a href = "index.jsp">홈으로</a>
	</body>
</html>