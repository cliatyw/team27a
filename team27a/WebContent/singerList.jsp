<!-- {�ֻ��} -->
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
		<td>���� ����</td>
		<td>���� �̸�</td>
		<td>���� ����</td>
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