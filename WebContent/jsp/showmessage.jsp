<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
</head>
<body>
<%
String mid=request.getParameter("msgid");
String strsql="select mtext from message where message_id=?";
ResultSet rs=CrudOperation.getData(strsql,mid);
if(rs.next())
{
%>
<div id="div1" style="background-color:#F7F7F7;margin-left:100px;margin-top:100px;width:700px;height:300px;padding-left:20px;padding-top:20px;font-family:'Monotype Corsiva';font-size:20px;">
<%=rs.getString("mtext") %></div>
<%}
%>
<div style="margin-left:800px;margin-top:50px">
<a href="/college_erp/jsp/inbox.jsp">Back</a></div>
</body>
</html>