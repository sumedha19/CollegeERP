<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
<%
response.setHeader("Cache-Control", "no-Cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);
%>
</head>
<body style="margin:0px 0px 0px 0px">
<div style="float:right;background-color: #F7F7F7;width:1120px;height:85px;border-style:outset;border-color:#F1F1F1">


<% 
HttpSession hs=null;
hs=request.getSession(false);
String uid=(String)hs.getAttribute("uinfo");
if(uid==null || hs.isNew())
{
	response.sendRedirect("/college_erp/jsp/home.jsp");
}
else
{
	%>
	
	<div style="float:right;margin-top:10px;font-family:Comic Sans MS"><%=new java.util.Date() %></div>
	<div style="float:right;margin-top:30px;margin-right:-215px;font-family:Comic Sans MS"><a href="/college_erp/LogOut">Logoff</a></div>
	<%} %></div>
</body>
</html>