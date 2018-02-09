<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.Singer"%>
<%@ page import="service.SingerDao"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	</head>
	<body>
		<h1>가수 목록</h1>
		<a href="insertSingerForm.jsp">등록</a>
		<table border="1">
			<tr>
				<td>가수 순서</td>
				<td>가수 이름</td>
				<td>가수 나이</td>
			</tr>		
			<%
				SingerDao singerdao = new SingerDao();
				ArrayList<Singer> list =singerdao.selectSingerList();
				for(Singer singer : list){			
			%>
					<tr>
						<td><%=singer.getSingerId()%></td>
						<td><%=singer.getSingerName()%></td>
						<td><%=singer.getSingerAge()%></td>
					</tr>
			<%		
				}
			%>			
		</table>
		<a href="index.jsp">홈으로</a>
	</body>
</html>