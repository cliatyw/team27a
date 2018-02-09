<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "service.Anaunseo" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");

	AnaunseoDao anaunseoDao = new AnaunseoDao();
	Anaunseo anaunseo = new Anaunseo();
	ArrayList<Anaunseo> array = new ArrayList<Anaunseo>();
	
	array = anaunseoDao.selectAnaunseoList(); //매서드 실행 후 리턴값을 배열에 대입

%>
<table>
	<tr>
		<th>id</th>
		<th>name</th>
		<th>age</th>
	</tr>
<%
	for(int i=0; i<array.size(); i++){
		anaunseo = array.get(i); //
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