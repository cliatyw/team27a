<!-- [�����] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<%
	/*�̰Ŵ� ����ڰ� �Է��� �����͸� post������� ������ ������ ���ڼ��� euc-kr�� �ްڴٴ°�!*/
	request.setCharacterEncoding("euc-kr");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		/*�ƹ��͵� �Է����� �ʾ������� Ȩ���� ���ư���. 
		���â�� ���� �;����� �ڹٽ�ũ��Ʈ�� �ȹ�� �����....
		*/
		if(!request.getParameter("comedianName").equals("") && !request.getParameter("comedianAge").equals("")){
			Comedian comedian = new Comedian();
			ComedianDao comedianDao = new ComedianDao();
			/* ���� �����͸� �ٷ� ��ü�� �����ϰ� �μ�Ʈ �޼��� ����! 
			���߿��� �̸� �̿��Ͽ�, result���� �޾Ƽ� �Է¿� �����ߴ�,
			Ȥ�� �����ߴٸ� ������ְ� �ʹ�~
			*/
			comedian.setComedianName(request.getParameter("comedianName"));
			comedian.setComedianAge(Integer.parseInt(request.getParameter("comedianAge")));
			comedianDao.insertComedian(comedian);
		}
		response.sendRedirect(request.getContextPath() + "/comedianList.jsp");
		%>
	</body>
</html>