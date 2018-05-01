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
HttpSession hs1=null;
hs1=request.getSession(false);
String ui=(String)hs1.getAttribute("uinfo");

%>
<div style="margin-left:200px;margin-top:50px"><h2>COMPOSE MESSAGE</h2></div>
<div style="margin-left:200px;margin-top:30px;width:600px;height:380px;background-color:#F7F7F7">
<form method="post" action="/college_erp/Compose">
<table cellpadding=10px cellspacing=10px style="margin-left:50px;margin-top:10px">
<tr><th>Sender's Id :</th><td><input type="text" name="sid" value=<%=ui %> readonly style="background-color:#F7F7F7;width:250px"></td></tr>
<tr><th>Receiver's Id :</th><td><input type="text" name="rid" style="width:250px"></td></tr>
<tr><th>Subject :</th><td><input type="text" name="subject" style="width:250px"></td></tr>
<tr><th>Message :</th><td><textarea cols=22 rows=5 name="msg" style="width:250px"></textarea></td></tr>
<tr><td colspan=2 align="center"><button type="submit" value="send" style="width:100px">Send</button></td></tr>
</table>

</form>
<div style="color:blue;margin-left:200px">${param.message}</div>

</div>

</body>
</html>