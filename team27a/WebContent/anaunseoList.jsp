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
	array = anaunseoDao.selectAnaunseoList();
%>
<table>
	<tr>
		<td>id</td>
		<td>name</td>
		<td>age</td>
	</tr>
	<%
		for(int i=0; i<array.size(); i++){
			
		}
	%>
	
	
</table>