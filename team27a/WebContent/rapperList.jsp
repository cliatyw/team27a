<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="service.RapperDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="service.Rapper"%>
<!DOCTYPE html>
<html>
	<head>
	
	</head>
	<%
		request.setCharacterEncoding("euc-kr");
		RapperDao rapperDao = new RapperDao();
		ArrayList<Rapper> arrayRapper = rapperDao.selectRapperList();
	%>
	<body>
		<h1>래퍼 목록</h1>
		<a href="http://naver.com">등록</a>
		<table border="1">
			<tr>
				<td>래퍼 순서</td>
				<td>래퍼 이름</td>
				<td>래퍼 나이</td>
			</tr>
			<%
				for (Rapper rapper : arrayRapper) {
			%>
			<tr>
				<td><%=rapper.getRapperId()%></td>
				<td><%=rapper.getRapperName()%></td>
				<td><%=rapper.getRapperAge()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<a href="index.jsp">홈으로</a>
	</body>
</html>

 