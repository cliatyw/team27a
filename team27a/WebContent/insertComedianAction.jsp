<!-- [�����] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("euc-kr");
		/* 
		�ƹ��͵� ���������� �׳� ����Ʈ�� ���ư����ϱ�. ���â�� ���� �;����� �ڹٽ�ũ��Ʈ�� �ȹ�� �����....
		�׸��� ��й�ȣ�� ���� ������ �ϰ�ʹ�. 
		*/
		if(!request.getParameter("comedianName").equals("") && !request.getParameter("comedianAge").equals("")){
			Comedian comedian = new Comedian();
			ComedianDao comedianDao = new ComedianDao();
			comedian.setComedianName(request.getParameter("comedianName"));
			comedian.setComedianAge(Integer.parseInt(request.getParameter("comedianAge")));
			comedianDao.insertComedian(comedian);
		}
		response.sendRedirect(request.getContextPath() + "/comedianList.jsp");
		
		%>
	</body>
</html>