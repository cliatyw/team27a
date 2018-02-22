<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="service.AnaunseoDao" %>
<%@ page import="service.Anaunseo" %>
<%@ page import="java.util.ArrayList" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>anaunseoList.jsp</title>
	</head>
	<body>
		<%
		AnaunseoDao anaunseoDao = new AnaunseoDao();
		ArrayList<Anaunseo> list = anaunseoDao.selectAnaunseoList();
		//매서드 실행 후 리턴값을 배열에 대입
		%>
		<h1>아나운서 목록</h1>
		<a href="<%= request.getContextPath() %>/insertAnaunseoForm.jsp">등록</a>
		
		<!-- table에 thead와 tbody 삽입 -->
		<table border="1">
			<thead>
				<tr>
					<th>아나운서 순서</th>
					<th>아나운서 이름</th>
					<th>아나운서 나이</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<!-- jsp에서 맞추기는 힘들지만 for문 등을 사용할때 테이블 안에 있으면 들여 놓는것이 좋다. -->
				<%
				for (Anaunseo anaunseo : list) {
				%>
					<tr>
						<td><%= anaunseo.getAnaunseoId() %></td>
						<td><%= anaunseo.getAnaunseoName() %></td>
						<td><%= anaunseo.getAnaunseoAge() %></td>
						<td><a href="updateAnaunseoForm.jsp?anaunseoId=<%= anaunseo.getAnaunseoId() %>">수정</a></td>
						<td><a href="deleteAnaunseoAction.jsp?anaunseoId=<%= anaunseo.getAnaunseoId() %>">삭제</a></td>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="index.jsp">홈으로</a>
	</body>
</html>