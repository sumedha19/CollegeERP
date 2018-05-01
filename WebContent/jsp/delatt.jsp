<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*,java.net.URLEncoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
<script>
function checks()
{
	var st=document.getElementById("sb").value;
	
	if(st=="def")
		{
			alert("Please select one value");
			return false;
			}
		return true;
}
</script>
</head>
<body>
<div style="width:400px;height:200px;background-color:#f1f1f1;margin-left:100px;margin-top:100px;float:left">
<label style="margin-left:30px;margin-top:20px;text-decoration: underline;float:left">Delete Attendance Record</label>
<form method="post" action="/college_erp/Delatt" style="margin-left:30px;margin-top:50px;font-size: 15px">
Date &nbsp &nbsp &nbsp<input type="date" name="dt" required="required">
<br>Subject <select name="sb" id="sb" style="border-style:inset;border-color:#f1f1f1;" required="required">
<option value="def" required="required">Select Subject</option>
<%
	String str1="select * from subjects";
ResultSet rs1=CrudOperation.getValue(str1);
try
{ while(rs1.next())
{
%>
<option value='<%=rs1.getString("sub_id") %>'><%=rs1.getString("name") %>(<%=rs1.getString("sub_id") %>)</option>
<%}
}
catch(SQLException e)
{
	
}
%>
</select><br>
Roll No &nbsp<input type="text" name="roll" required="required"><br>
<input type="submit" value="Delete" onclick="return checks()">
<div style="color:blue">${param.message1}</div>
</form>
</div>
</body>
</html>