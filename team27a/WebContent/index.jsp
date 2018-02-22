<!-- [김기성] -->
<%-- 팀 통일 규칙:<% %>안에 한번 띄기
		html 안에 tap 하기
		한글입력처리 <%@ 밑에 무조건 쓰기
		절대경로는 항상
		<% 다음줄은 <%와 같은 곳에 ex) <%
							   Anaunseo
		--%>
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
		<section>
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
				</tbody>
			</table>
		</section>
	</body>
</html>