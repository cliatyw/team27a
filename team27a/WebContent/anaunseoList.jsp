<!-- [��⼺] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "service.Anaunseo" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>anaunseoList.jsp</title>
</head>
<body>
	<h1>�Ƴ�� ���</h1>
	<a href="<%= request.getContextPath() %>/insertAnaunseoForm.jsp">���</a>
	<%
		request.setCharacterEncoding("euc-kr");
	
		AnaunseoDao anaunseoDao = new AnaunseoDao();
		ArrayList<Anaunseo> list = anaunseoDao.selectAnaunseoList();
		//�ż��� ���� �� ���ϰ��� �迭�� ����
	%>
	<!-- table�� thead�� tbody ���� -->
	<table border="1">
		<thead>
			<tr>
				<th>�Ƴ�� ����</th>
				<th>�Ƴ�� �̸�</th>
				<th>�Ƴ�� ����</th>
			</tr>
		</thead>
		<tbody>
			<!-- jsp���� ���߱�� �������� for�� ���� ����Ҷ� ���̺� �ȿ� ������ �鿩 ���°��� ����. -->
			<%
				for (Anaunseo anaunseo : list) {
			%>
					<tr>
						<td><%=anaunseo.getAnaunseoId()%></td>
						<td><%=anaunseo.getAnaunseoName()%></td>
						<td><%=anaunseo.getAnaunseoAge()%></td>
						<td><a href="updateAnaunseoForm.jsp?anaunseoId=<%=anaunseo.getAnaunseoId()%>">����</a></td>
						<td><a href="deleteAnaunseoAction.jsp?anaunseoId=<%=anaunseo.getAnaunseoId()%>">����</a></td>
					</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<a href="index.jsp">Ȩ����</a>
</body>
</html>