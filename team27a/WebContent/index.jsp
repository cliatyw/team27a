<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<head>team27a</head>
	<table>
		<tr>
			<td>팀원</td>
			<td>역활</td>
		</tr>
		<tr>
			<td>김도희</td>
			<td>actor</td>
		</tr>
		<tr>
			<td>백지훈</td>
			<td>actress</td>
		</tr>
		<tr>
			<td>최상욱</td>
			<td>singer</td>
		</tr>
		<tr>
			<td>진경수</td>
			<td>comedian</td>
		</tr>
		<tr>
			<td>김기성</td>
			<td>rapper, anaunseo</td>
		</tr>
	</table>
	<ul>
		<li><a href="<%= request.getContextPath() %>/actorList.jsp">actor list</a></li>
		<li><a href="<%= request.getContextPath() %>/actressList.jsp">actress list</a></li>
		<li><a href="<%= request.getContextPath() %>/singerList.jsp">singer list</a></li>
		<li><a href="<%= request.getContextPath() %>/comedianList.jsp">comedian list</a></li>
		<li><a href="<%= request.getContextPath() %>/rapperList.jsp">rapper list</a></li>
		<li><a href="<%= request.getContextPath() %>/anaunseoList.jsp">anaunseo list</a></li>
	</ul>
</body>
</html>