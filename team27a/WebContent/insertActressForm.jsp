<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>등록 화면</h1>
	<form action="<%= request.getContextPath() %>/insertActressAction.jsp">
		<table border="1">
			<tr>
				<td>여배우 이름</td>
				<td><input type="text" name="actressName"></td>
			</tr>
			<tr>
				<td>여배우 나이</td>
				<td><input type="text" name="actressAge"></td>
			</tr>
		</table>
		<input type="submit" value="등록">
	</form>	
</body>
</html>