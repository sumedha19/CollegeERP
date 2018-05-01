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
String strsql="Select * from login where userid=?";
HttpSession hs=null;
hs=request.getSession(false);
String uid=(String)hs.getAttribute("uinfo");
try
		{
			
			
			ResultSet rs1=CrudOperation.getData(strsql,uid);
			if(rs1.next())
			{%>
			<div>
			<form method="post" action="/college_erp/ChangeP">
			<table cellpadding=10px cellspacing=10px style="margin-left:50px;margin-top:10px;text-align: left;">
			<tr><td>UserId :</td><td><input type="text" value='<%=rs1.getString("userid")%>' name="uid" readonly="readonly"></td></tr>
			<tr><td>Enter New Password :</td><td><input type="password" name="pwd"></td></tr>	
			<tr><td>Re-enter Password :</td><td><input type="password" name="pwd1"></td></tr>
			<tr><td><input type="submit" value="Change Password"></td><td style="color:blue">${param.message}</td></tr>
			</table>
			
			</form>
			</div>
			
<% }
		}
			catch(SQLException e)
			{
				
			}
			%>
</body>
</html>