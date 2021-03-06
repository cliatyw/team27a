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
		//매서드 실행 후 리턴값을 배열에 대입
		ArrayList<Anaunseo> list = anaunseoDao.selectAnaunseoList();
		%>
		<h1>아나운서 목록</h1>
		<%
		//session에 아이디값이 있다면 등록버튼 활성화
		if(session.getAttribute("memberId") != null){
		%>
			<a href="<%= request.getContextPath() %>/anaunseo/insertAnaunseoForm.jsp">등록</a>
		<%
		}
		%>
		<!-- table에 thead와 tbody 삽입 -->
		<table border="1">
			<thead>
				<tr>
					<th>아나운서 순서</th>
					<th>아나운서 이름</th>
					<th>아나운서 나이</th>
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
				<!-- jsp에서 맞추기는 힘들지만 for문 등을 사용할때 테이블 안에 있으면 들여 놓는것이 좋다. -->
				<%
				for (Anaunseo anaunseo : list) {
				%>
					<tr>
						<td><%= anaunseo.getAnaunseoId() %></td>
						<td><%= anaunseo.getAnaunseoName() %></td>
						<td><%= anaunseo.getAnaunseoAge() %></td>
						<%
						//session에 아이디값이 있다면 수정, 삭제버튼 활성화
						if(session.getAttribute("memberId") != null){
						%>
						<td><a href="<%= request.getContextPath() %>/anaunseo/updateAnaunseoForm.jsp?anaunseoId=<%= anaunseo.getAnaunseoId() %>">수정</a></td>
						<td><a href="<%= request.getContextPath() %>/anaunseo/deleteAnaunseoAction.jsp?anaunseoId=<%= anaunseo.getAnaunseoId() %>">삭제</a></td>
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