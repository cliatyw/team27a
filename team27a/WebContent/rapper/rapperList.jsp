<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="service.RapperDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="service.Rapper" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title> rapperList.jsp </title>
	</head>
	<body>
		<%
		RapperDao rapperDao = new RapperDao();
		ArrayList<Rapper> arrayRapper = rapperDao.selectRapperList();
		%>
		<h1>래퍼 목록</h1>
		<a href="<%= request.getContextPath() %>/rapper/insertRapperForm.jsp">등록</a>
		<table border="1">
			<thead>
				<tr>
					<th>래퍼 순서</th>
					<th>래퍼 이름</th>
					<th>래퍼 나이</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>	
				<%
				for (Rapper rapper : arrayRapper) {
				%>
					<tr>
						<td><%=rapper.getRapperId()%></td>
						<td><%=rapper.getRapperName()%></td>
						<td><%=rapper.getRapperAge()%></td>
						<td><a href="<%=request.getContextPath()%>/index.jsp">수정</a></td>
						<td><a href="deleteRapperAction.jsp?rapperId=<%= rapper.getRapperId() %>">삭제</a></td>
						
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="index.jsp">홈으로</a>
	</body>
</html>

 