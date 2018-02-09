<!-- {최상욱} -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="service.Singer"%>
<%@ page import="service.SingerDao"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>

<% 
SingerDao singerdao = new SingerDao();
ArrayList<Singer> arraySinger =singerdao.selectSingerList();
%>
<table border="1">
	<tr>
		<td>가수 순서</td>
		<td>가수 이름</td>
		<td>가수 나이</td>
	</tr>
	
<%
	for(Singer singer : arraySinger){
		
%>
	<tr>
		<td><%=singer.getSingerId()%></td>
		<td><%=singer.getSingerName()%></td>
		<td><%= singer.getSingerAge()%></td>
	</tr>
<%		
	}
%>
</table>