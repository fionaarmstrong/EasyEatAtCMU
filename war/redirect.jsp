<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- this page is used to redirect to MainPage action 
displaying the post list. -->
<%  
response.sendRedirect("display.action?category=Love&currTab=Top&page=0");
%> 