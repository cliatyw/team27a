<!-- [�����] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.ComedianDao" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>deleteComedianAction.jsp</title>
	</head>
	<body>
		<%
		ComedianDao comedianDao = new ComedianDao();
		/* comedianDao��ü�� deleteCoemdian�޼��带 ȣ���Ѵ�.
		�׷��� ���ؼ� �Ű������� int������ �ϳ��� ������ �ϱ� ������, String ������ ���� ���� parseInt�޼���� ����ȯ
		�����༭ ȣ���Ѵ�. */
		comedianDao.deleteComedian(Integer.parseInt(request.getParameter("comedianId")));
		/* ������� ����� ���������� Ȯ���ϱ����� �ٽ� ����Ʈ�� �����Ѵ�. */
		response.sendRedirect(request.getContextPath() + "/comedian/comedianList.jsp");
		%>
	</body>
</html>