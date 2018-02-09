<!-- [최상욱] -->
<%@page import="service.SingerDao"%>
<%@page import="service.Singer"%>

<%
	request.setCharacterEncoding("euc-kr");
	String singerName = request.getParameter("singerName");
	int singerAge = Integer.parseInt(request.getParameter("singerAge"));

	Singer singer = new Singer();
	singer.setSingerName(singerName);
	singer.setSingerAge(singerAge);


	SingerDao singerDao = new SingerDao();
	singerDao.insertSinger(singer);

	response.sendRedirect(request.getContextPath() + "/singerList.jsp");
%>
