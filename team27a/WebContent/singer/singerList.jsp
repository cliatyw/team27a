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
		<%
		if(session.getAttribute("memberId") != null){	
		%>
			<a href = "<%= request.getContextPath() %>/singer/insertSingerForm.jsp">등록</a>
		<%
		}
		%>
		<table border = "1">
			<thead>
				<tr>
					<th>가수 순서</th>
					<th>가수 이름</th>
					<th>가수 나이</th>
					<%
					//session에 아이디값이 있다면 수정 삭제 테이블 제목 활성화
					if(session.getAttribute("memberId") != null){
					%>
						<th>수정</th>
						<th>삭제</th>
					<%
					}
					%>
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
						<%
						//session에 아이디값이 있다면 수정, 삭제버튼 활성화
						if(session.getAttribute("memberId") != null){
						%>
						<td><a href = "<%= request.getContextPath() %>/singer/updateSingerForm.jsp?singerId=<%= singer.getSingerId() %>">수정</a></td>
						<td><a href = "<%= request.getContextPath() %>/singer/deleteSingerAction.jsp?singerId=<%= singer.getSingerId() %>">삭제</a></td>
						<%
						}
						%>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="<%= request.getContextPath() %>/index.jsp">홈으로</a>
	</body>
</html>