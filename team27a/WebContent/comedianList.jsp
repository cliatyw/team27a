<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Comedian" %>
<!DOCTYPE html>
<%
request.setCharacterEncoding("euc-kr");
ComedianDao cd = new ComedianDao();
ArrayList<Comedian> arrayComedian = cd.selectActorList();
%>
<table border="1">
	<tr>
		<td>�ڸ޵�� ����</td>
		<td>�ڸ޵�� �̸�</td>
		<td>�ڸ޵�� ����</td>
	</tr>
	<%
	for(int i=0 ; i < arrayComedian.size() ; i++){
		Comedian comedian = arrayComedian.get(i);
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
