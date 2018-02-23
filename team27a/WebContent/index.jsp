<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>index.jsp</title>
	</head>
	<body>
		<header>
			<h1 align="center">team27a</h1>
		</header>
		<%if(session.getAttribute("memberId") == null) {%>
		<form action="<%= request.getContextPath() %>/login/login.jsp" method="post" align="center">
			아이디 : 
			<input type="text" name="memberId">
			비밀번호 : 
			<input type="text" name="memberPw">
			<input type="submit" value="로그인">
		</form>
		<% } %>
		<table border="1" style="width: 50%" align="center">
			<thead>
				<tr>
					<th>팀원</th>
					<th>역활</th>
					<th>링크</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><img src="<%= request.getContextPath() %>/image/kdh.jpg" style="width: 100px; height: 100px;"><br>김도희</td>
					<td>actor</td>
					<td>
						<ul>
							<li><a href="<%= request.getContextPath() %>/actor/actorList.jsp">actor list</a></li>
						</ul>
					</td>
				</tr>
				<tr>
					<td><img src="<%= request.getContextPath() %>/image/bjh.jpg" style="width: 100px; height: 100px;"><br>백지훈</td>
					<td>rapper, actress</td>
					<td>
						<ul>
							<li><a href="<%= request.getContextPath() %>/rapper/rapperList.jsp">rapper list</a></li>
							<li><a href="<%= request.getContextPath() %>/actress/actressList.jsp">actress list</a></li>
						</ul>
					</td>
				</tr>
				<tr>
					<td><img src="<%= request.getContextPath() %>/image/csu.png" style="width: 100px; height: 100px;"><br>최상욱</td>
					<td>singer</td>
					<td>
						<ul>
							<li><a href="<%= request.getContextPath() %>/singer/singerList.jsp">singer list</a></li>
						</ul>
					</td>
				</tr>
				<tr>
					<td><img src="<%= request.getContextPath() %>/image/jks.png" style="width: 100px; height: 100px;"><br>진경수</td>
					<td>comedian</td>
					<td>
						<ul>
							<li><a href="<%= request.getContextPath() %>/comedian/comedianList.jsp">comedian list</a></li>
						</ul>
					</td>
				</tr>
				<tr>
					<td><img src="<%= request.getContextPath() %>/image/kks.jpg" style="width: 100px; height: 100px;"><br>김기성</td>
					<td>anaunseo</td>
					<td>
						<ul>
							<li><a href="<%= request.getContextPath() %>/anaunseo/anaunseoList.jsp">anaunseo list</a></li>
						</ul>
					</td>
				</tr>
		</table>
	</body>
</html>