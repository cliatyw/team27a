<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Comedian" %>
<%
request.setCharacterEncoding("euc-kr");
ComedianDao cd = new ComedianDao();
ArrayList<Comedian> arrCd = cd.selectActorList();



%>
