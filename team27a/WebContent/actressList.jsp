<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ActressDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Actress" %>
<!DOCTYPE html>
<%
request.setCharacterEncoding("euc-kr");
ActressDao actressDao = new ActressDao();
ArrayList<Actress> arrayActress = actressDao.selectActressList();
%>
<table border="1">
	<tr>
		<td>여배우 순서</td>
		<td>여배우 이름</td>
		<td>여배우 나이</td>
	</tr>
	<%
	for(Actress actress : arrayActress){
		%>
		<tr>
			<td><%= actress.getActressId()%></td>
			<td><%= actress.getActressName()%></td>
			<td><%= actress.getActressAge()%></td>
		</tr>
		<%
	}
	%>
</table>
