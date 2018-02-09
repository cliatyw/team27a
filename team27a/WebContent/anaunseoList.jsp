<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "service.Anaunseo" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
	<h1>아나운서 목록</h1>
	<a href="<%= request.getContextPath() %>/insertAnaunseoForm.jsp">등록</a>
	<%
		request.setCharacterEncoding("euc-kr");
	
		AnaunseoDao anaunseoDao = new AnaunseoDao();
		ArrayList<Anaunseo> list = anaunseoDao.selectAnaunseoList();
		//매서드 실행 후 리턴값을 배열에 대입
	%>
	<!-- table에 thead와 tbody 삽입 -->
	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>age</th>
			</tr>
		</thead>
		<tbody>
			<!-- jsp에서 맞추기는 힘들지만 for문 등을 사용할때 테이블 안에 있으면 들여 놓는것이 좋다. -->
			<%
				for (Anaunseo anaunseo : list) {
			%>
					<tr>
						<td><%=anaunseo.getAnaunseoId()%></td>
						<td><%=anaunseo.getAnaunseoName()%></td>
						<td><%=anaunseo.getAnaunseoAge()%></td>
					</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<a href="index.jsp">홈으로</a>
</body>
</html>