<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Comedian" %>
<!DOCTYPE html>
<%
request.setCharacterEncoding("euc-kr");
ComedianDao comedianDao = new ComedianDao();
ArrayList<Comedian> arrayComedian = comedianDao.selectComedianList();
%>
<table border="1">
	<tr>
		<td>코메디언 순서</td>
		<td>코메디언 이름</td>
		<td>코메디언 나이</td>
	</tr>
	<%
	for(Comedian comedian : arrayComedian){
		%>
		<tr>
			<td><%= comedian.getComedianId()%></td>
			<td><%= comedian.getComedianName()%></td>
			<td><%= comedian.getComedianAge()%></td>
		</tr>
		<%
	}
	%>
</table>
