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
			<td>����</td>
			<td>��Ȱ</td>
		</tr>
		<tr>
			<td>�赵��</td>
			<td>actor</td>
		</tr>
		<tr>
			<td>������</td>
			<td>actress</td>
		</tr>
		<tr>
			<td>�ֻ��</td>
			<td>singer</td>
		</tr>
		<tr>
			<td>�����</td>
			<td>comedian</td>
		</tr>
		<tr>
			<td>��⼺</td>
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