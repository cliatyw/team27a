<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1 align="center">team27a</h1>
	</header>
	<nav style="float: left">
		<ul>
			<li><a href="<%= request.getContextPath() %>/image/actorList.jsp">actor list</a></li>
			<li><a href="<%= request.getContextPath() %>/image/actressList.jsp">actress list</a></li>
			<li><a href="<%= request.getContextPath() %>/image/singerList.jsp">singer list</a></li>
			<li><a href="<%= request.getContextPath() %>/image/comedianList.jsp">comedian list</a></li>
			<li><a href="<%= request.getContextPath() %>/image/rapperList.jsp">rapper list</a></li>
			<li><a href="<%= request.getContextPath() %>/image/anaunseoList.jsp">anaunseo list</a></li>
		</ul>
	</nav>
	<section>
		<table border="1" style="width: 50%">
			<tr>
				<th>팀원</th>
				<th>역활</th>
				<th>사진</th>
			</tr>
			<tr>
				<td>김도희</td>
				<td>actor</td>
				<td><img src="kdh.jpg" style="width: 150px; height: auto;"></td>
			</tr>
			<tr>
				<td>백지훈</td>
				<td>rapper, actress</td>
				<td><img src="bjh.jpg" style="width: 150px; height: auto;"></td>
			</tr>
			<tr>
				<td>최상욱</td>
				<td>singer</td>
				<td><img src="csu.png" style="width: 150px; height: auto;"></td>
			</tr>
			<tr>
				<td>진경수</td>
				<td>comedian</td>
				<td><img src="jks.png" style="width: 150px; height: auto;"></td>
			</tr>
			<tr>
				<td>김기성</td>
				<td>anaunseo</td>
				<td><img src="kks.jpg" style="width: 150px; height: auto;"></td>
			</tr>
		</table>
	</section>
	
	
</body>
</html>