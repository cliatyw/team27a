<!-- [��⼺] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "service.Anaunseo" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");

	AnaunseoDao anaunseoDao = new AnaunseoDao();
	ArrayList<Anaunseo> list = anaunseoDao.selectAnaunseoList();
	//�ż��� ���� �� ���ϰ��� �迭�� ����
%>
<table>
	<tr>
		<th>id</th>
		<th>name</th>
		<th>age</th>
	</tr>
	<!-- jsp���� ���߱�� �������� for�� ���� ����Ҷ� ���̺� �ȿ� ������ �鿩 ���°��� ����. -->
	<%
		for(Anaunseo anaunseo : list){
	%>
			<tr>
				<td><%= anaunseo.getAnaunseoId() %></td>
				<td><%= anaunseo.getAnaunseoName() %></td>
				<td><%= anaunseo.getAnaunseoAge() %></td>
			</tr>
	<%
		}
	%>
</table>