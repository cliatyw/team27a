<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "service.Anaunseo" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");

	AnaunseoDao anaunseoDao = new AnaunseoDao();
	ArrayList<Anaunseo> list = anaunseoDao.selectAnaunseoList();
	//매서드 실행 후 리턴값을 배열에 대입
%>
<table>
	<tr>
		<th>id</th>
		<th>name</th>
		<th>age</th>
	</tr>
	<!-- jsp에서 맞추기는 힘들지만 for문 등을 사용할때 테이블 안에 있으면 들여 놓는것이 좋다. -->
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