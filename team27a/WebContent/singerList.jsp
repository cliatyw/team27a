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
	<td>id값 : <%=singer.getSingerId()%></td>
	<td>name값 : <%=singer.getSingerName()%></td>
	<td>age값 : <%= singer.getSingerAge()%></td>
	<br>
</tr>
<%		
	}
%>