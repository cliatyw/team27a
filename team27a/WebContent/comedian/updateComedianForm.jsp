<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateComedianForm.jsp</title>
	</head>
	<body>
		<%
		ComedianDao comedianDao = new ComedianDao();
		/* 코메디언 정보를 수정하기 전에, 이전에 등록되어져있는 정보들을 한번 확인 할 수 있도록 하기위해 호출하는 메서드이다.
		이 메서드는 Comedian형 객체를 리턴한다. */
		Comedian comedian = comedianDao.selectComedianOne(Integer.parseInt(request.getParameter("comedianId")));
		%>
		<h1>수정 화면</h1>
		<form action="<%= request.getContextPath() %>/comedian/updateComedianAction.jsp" method="post">
			<!-- 자신이 입력한 코메디언 정보들을 post방식으로 보내서 업데이트를 하기 위해선 어떤행의 정보를 업데이트할지에대한 정보역시 필요하다.
			그러기 위해 primary key값인 comedianId값을 수정하지 않을값이더라도 같이 보내줘야한다.
			그래서 hidden속성을 줘서 사용자들에게는 보이지 않게 함께 comedian에대한 정보를 보낸다. --> 
			<input type ="hidden" name="comedianId" value=<%= comedian.getComedianId() %>>
			<table border="1">
				<tr>
					<td>코미디언 이름</td>
					<td><input type="text" name="comedianName" value=<%= comedian.getComedianName() %>></td>
				</tr>
				<tr>
					<td>코미디언 나이</td>
					<td><input type="text" name="comedianAge" value=<%= comedian.getComedianAge() %>></td>
				</tr>
			</table>
			<input type="submit" value="수정">
		</form>	
	</body>
</html>