<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="service.Singer"%>
<%@ page import="service.SingerDao"%>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<% 
SingerDao singerdao = new SingerDao();
ArrayList<Singer> arraySinger =singerdao.selectSingerList();

	for(int i=0;i<arraySinger.size(); i++){
		Singer singer = arraySinger.get(i);
%>
<tr>
	<td>id�� : <%=singer.getSingerId()%></td>
	<td>name�� : <%=singer.getSingerName()%></td>
	<td>age�� : <%= singer.getSingerAge()%></td>
	<br>
</tr>
<%		
	}
%>