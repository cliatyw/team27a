<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>insertActorForm.jsp</title>
</head>
<body>
	<h1>등록 화면</h1>
	<form action="<%=request.getContextPath()%>/insertActorAction.jsp" method="post">
		<table border="1">
			<tr>
				<td>남배우 이름</td>
				<td><input type="text" name="actorName"></td>
			</tr>
			<tr>
				<td>남배우 나이</td>
				<td><input type="text" name="actorAge"></td>
			</tr>
		</table>
		<input type="submit" value="등록">
	</form>	
</body>
</html>