<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee | Account</title>
</head>
<body style="margin:0px 0px 0px 0px">
<%@include file="/jsp/header.jsp"%>
<div style="background-color: #B1B1B1;float:left;width:202px;height:70px;font-family: Comic Sans MS;font-size:20px;padding-top:20px;padding-left:20px">
<% 
String str="select * from employee where emp_id=?";
String ui=(String)request.getAttribute("empid");
ResultSet rs=CrudOperation.getData(str, ui);
try
{
	if(rs.next())
	{
%>
Welcome <br><%=rs.getString("name") %>.
<%}
}
catch(SQLException e)
{
	
}
%>
</div>
<div style="height:567px;width:220px;background-color: #F7F7F7;float:left;margin-left:0px;margin-top:0px;border-style:outset;border-color:#F1F1F1">
<div style="height:20px;float:left;text-align:center;border-style:solid;border-color:#F1F1F1;color:#868686;WIDTH:215px;font-family:Comic Sans MS">Menu</div>
<div style="height:20px;float:left;text-align:center;border-style:solid;border-color:#F1F1F1;color:#868686;width:215px;font-family:Comic Sans MS">
<a href="/college_erp/jsp/viewprofilef.jsp" target="f1" style="text-decoration: none;">View Profile</a></div>
<div style="height:20px;float:left;text-align:center;border-style:solid;border-color:#F1F1F1;color:#868686;width:215px;font-family:Comic Sans MS">
<a href="/college_erp/jsp/change_pwd.jsp" target="f1" style="text-decoration: none;">Change Password</a></div>
<div style="height:20px;float:left;text-align:center;border-style:solid;border-color:#F1F1F1;color:#868686;width:215px;font-family:Comic Sans MS">
<a href="/college_erp/jsp/addhostel.jsp" target="f1" style="text-decoration: none;">Add Hostel</a></div>
<div style="height:20px;float:left;text-align:center;border-style:solid;border-color:#F1F1F1;color:#868686;width:215px;font-family:Comic Sans MS">
<a href="/college_erp/jsp/addhosteller.jsp" target="f1" style="text-decoration: none;">Add Hosteller</a></div>
<div style="height:20px;float:left;text-align:center;border-style:solid;border-color:#F1F1F1;color:#868686;width:215px;font-family:Comic Sans MS">
<a href="/college_erp/jsp/viewhrec.jsp" target="f1" style="text-decoration: none;">View Records</a></div>
<div style="height:20px;float:left;text-align:center;border-style:solid;border-color:#F1F1F1;color:#868686;width:215px;font-family:Comic Sans MS">
<a href="/college_erp/jsp/inbox.jsp" target="f1" style="text-decoration: none;">Inbox</a></div>
<div style="height:20px;float:left;text-align:center;border-style:solid;border-color:#F1F1F1;color:#868686;width:215px;font-family:Comic Sans MS">
<a href="/college_erp/jsp/compose.jsp" target="f1" style="text-decoration: none;">Compose Message</a></div>
<div style="height:20px;float:left;text-align:center;border-style:solid;border-color:#F1F1F1;color:#868686;width:215px;font-family:Comic Sans MS">
<a href="/college_erp/jsp/sentitems.jsp" target="f1" style="text-decoration: none;">Sent Items</a></div>

</div>
<div style="float:left;width:1123px;height:567px"><iframe src="/college_erp/html/default.html" width="100%" height="100%" name="f1"></iframe></div>
</body>
</html>