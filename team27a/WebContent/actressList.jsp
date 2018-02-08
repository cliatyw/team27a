<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import = "service.SingerDao" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<% 
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

SingerDao db = new SingerDao();
conn = db.driverDbcon();

pstmt = conn.prepareStatement("select * from actress");

rs = pstmt.executeQuery();

while(rs.next()){
%>
		<tr>
			<td>id값 : <%= rs.getString("actressId")%></td>
			<td>name값 : <%= rs.getString("actressName")%></td>
			<td>age값 : <%= rs.getString("actressAge")%></td><br>
		</tr>
<%		
		}
rs.close();
pstmt.close();
conn.close();
%>	

					


				
