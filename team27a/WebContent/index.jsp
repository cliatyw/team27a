<!-- [��⼺] -->
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
			<li><a href="<%= request.getContextPath() %>/actorList.jsp">actor list</a></li>
			<li><a href="<%= request.getContextPath() %>/actressList.jsp">actress list</a></li>
			<li><a href="<%= request.getContextPath() %>/singerList.jsp">singer list</a></li>
			<li><a href="<%= request.getContextPath() %>/comedianList.jsp">comedian list</a></li>
			<li><a href="<%= request.getContextPath() %>/rapperList.jsp">rapper list</a></li>
			<li><a href="<%= request.getContextPath() %>/anaunseoList.jsp">anaunseo list</a></li>
		</ul>
	</nav>
	<section>
		<table border="1" style="width: 50%">
			<tr>
				<th>����</th>
				<th>��Ȱ</th>
				<th>����</th>
			</tr>
			<tr>
				<td>�赵��</td>
				<td>actor</td>
				<td><img src="<%= request.getContextPath() %>/image/kdh.jpg" style="width: 150px; height: auto;"></td>
			</tr>
			<tr>
				<td>������</td>
				<td>rapper, actress</td>
				<td><img src="<%= request.getContextPath() %>/image/bjh.jpg" style="width: 150px; height: auto;"></td>
			</tr>
			<tr>
				<td>�ֻ��</td>
				<td>singer</td>
				<td><img src="<%= request.getContextPath() %>/image/csu.png" style="width: 150px; height: auto;"></td>
			</tr>
			<tr>
				<td>�����</td>
				<td>comedian</td>
				<td><img src="<%= request.getContextPath() %>/image/jks.png" style="width: 150px; height: auto;"></td>
			</tr>
			<tr>
				<td>��⼺</td>
				<td>anaunseo</td>
				<td><img src="<%= request.getContextPath() %>/image/kks.jpg" style="width: 150px; height: auto;"></td>
			</tr>
		</table>
	</section>
</body>
</html>